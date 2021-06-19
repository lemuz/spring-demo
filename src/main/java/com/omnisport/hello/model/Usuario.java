package com.omnisport.hello.model;

import java.util.List;

public class Usuario {
	
	private long idUsuario;
	private String username;
	private String password;
	private List<Rol> roles;
	private boolean expired;
	private boolean locked;
	private boolean credentialsExpired;
	private boolean enabled;
	
	public Usuario() {
		
	}

	public Usuario(long idUsuario, String username, String password, List<Rol> roles, boolean expired, boolean locked,
			boolean credentialsExpired, boolean enabled) {
		super();
		this.idUsuario = idUsuario;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.expired = expired;
		this.locked = locked;
		this.credentialsExpired = credentialsExpired;
		this.enabled = enabled;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public boolean isCredentialsExpired() {
		return credentialsExpired;
	}

	public void setCredentialsExpired(boolean credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idUsuario ^ (idUsuario >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (idUsuario != other.idUsuario)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", username=" + username + ", password=" + password + ", roles="
				+ roles + ", expired=" + expired + ", locked=" + locked + ", credentialsExpired=" + credentialsExpired
				+ ", enabled=" + enabled + "]";
	}
}