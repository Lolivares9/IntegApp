package com.inteapp.businessObject;

public class Concepto {
	private String descripcion;
	private String Tipo;
	
	
	
	public Concepto(String descripcion, String tipo) {
		super();
		this.descripcion = descripcion;
		Tipo = tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	
	
}
