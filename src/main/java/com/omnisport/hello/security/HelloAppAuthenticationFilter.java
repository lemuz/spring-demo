package com.omnisport.hello.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.omnisport.hello.model.MyUserDetails;
import com.omnisport.hello.model.Usuario;

public class HelloAppAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	private AuthenticationManager manager;

	public HelloAppAuthenticationFilter(AuthenticationManager manager) {
		super();
		this.manager = manager;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException{
		try {
			Usuario usuario = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword(), new ArrayList<>());
			Authentication auth = manager.authenticate(token);
			return auth;
		}catch(IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication auth) throws IOException {
		MyUserDetails detalles = (MyUserDetails)auth.getPrincipal();
		String token = detalles.getPassword();//create token not password
		response.addHeader(Constants.HEADER_AUTHORIZATION_KEY, token);
	}

}
