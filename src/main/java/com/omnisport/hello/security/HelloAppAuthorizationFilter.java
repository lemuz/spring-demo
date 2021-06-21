package com.omnisport.hello.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.omnisport.hello.model.MyUserDetails;
import com.omnisport.hello.model.Rol;
import com.omnisport.hello.model.Usuario;
import com.omnisport.hello.service.RolService;
import com.omnisport.hello.service.UsuarioService;

public class HelloAppAuthorizationFilter extends BasicAuthenticationFilter {

	private UsuarioService usuarioService;
	private RolService rolService;

	public HelloAppAuthorizationFilter(AuthenticationManager authenticationManager, UsuarioService usuarioService, RolService rolService) {
		super(authenticationManager);
		this.usuarioService = usuarioService;
		this.rolService = rolService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		String header = request.getHeader(Constants.HEADER_AUTHORIZATION_KEY);
		if (header == null || !header.startsWith(Constants.TOKEN_BEARER_PREFIX)) {
			chain.doFilter(request, response);
			return;
		}
		Authentication auth = getAuthentication(request);
		SecurityContextHolder.getContext().setAuthentication(auth);
		chain.doFilter(request, response);
		return;
	}

	private Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(Constants.HEADER_AUTHORIZATION_KEY).replace(Constants.TOKEN_BEARER_PREFIX, "");
		String username = null;
		if (token != null) {
			try {
				username = usuarioService.findByPassword(token);// get username by token
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (username != null) {
				Usuario usuario = usuarioService.getById().get();
				List<Rol> roles = rolService.findByUsuarios(usuario.getIdUsuario());
				usuario.setRoles(roles);
				MyUserDetails detalles = new MyUserDetails(usuario);
				UsernamePasswordAuthenticationToken autenticado = new UsernamePasswordAuthenticationToken(username, null, detalles.getAuthorities());
				return autenticado;
			}
		}
		return null;
	}
}