package com.omnisport.hello.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;

	public MyUserDetails(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Rol> roles = usuario.getRoles();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for(Rol rol : roles) {
			authorities.add(new SimpleGrantedAuthority(rol.getNombre()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return usuario.getPassword();
	}

	@Override
	public String getUsername() {
		return usuario.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return !usuario.isExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return !usuario.isLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !usuario.isCredentialsExpired();
	}

	@Override
	public boolean isEnabled() {
		return usuario.isEnabled();
	}

}