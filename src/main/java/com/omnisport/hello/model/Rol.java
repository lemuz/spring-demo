package com.omnisport.hello.model;

import java.util.List;

public class Rol {
	
	private long idRol;
	private String nombre;
	private boolean estado;
	private List<Usuario> usuarios;
	
	public Rol() {

	}

	public Rol(long idRol, String nombre, boolean estado, List<Usuario> usuarios) {
		super();
		this.idRol = idRol;
		this.nombre = nombre;
		this.estado = estado;
		this.usuarios = usuarios;
	}

	public long getIdRol() {
		return idRol;
	}

	public void setIdRol(long idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idRol ^ (idRol >>> 32));
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
		Rol other = (Rol) obj;
		if (idRol != other.idRol)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rol [idRol=" + idRol + ", nombre=" + nombre + ", estado=" + estado + "]";
	}
}
