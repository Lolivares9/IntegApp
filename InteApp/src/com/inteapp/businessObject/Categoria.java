
package com.inteapp.businessObject;

public class Categoria {
	private String categoria;
	private float sueldo;
	
	public Categoria(String categoria, float sueldo) {
		super();
		this.categoria = categoria;
		this.sueldo = sueldo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public float getSueldo() {
		return sueldo;
	}
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
}
