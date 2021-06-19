package com.omnisport.hello.model;

public class Product {

	private int idProducto;
	private String nombre;
	private String descipcion;
	private double precio;

	public Product() {
	}
	
	public Product(int idProducto, String nombre, String descipcion, double precio) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descipcion = descipcion;
		this.precio = precio;
	}
	
	public int getIdProducto() {
		return idProducto;
	}
	
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescipcion() {
		return descipcion;
	}
	
	public void setDescipcion(String descipcion) {
		this.descipcion = descipcion;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProducto;
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
		Product other = (Product) obj;
		if (idProducto != other.idProducto)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Product [idProducto=" + idProducto + ", nombre=" + nombre + ", descipcion=" + descipcion + ", precio="
				+ precio + "]";
	}
}
