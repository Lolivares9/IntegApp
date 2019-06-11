package com.inteapp.businessObject;

public class Concepto {
	
	private String descripcion;
	private boolean obligatorio;
	private String signo;
	
	public Concepto(String descripcion, boolean obligatorio) {
		super();
		this.descripcion = descripcion;
		this.obligatorio = obligatorio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isObligatorio() {
		return obligatorio;
	}
	public void setObligatorio(boolean obligatorio) {
		this.obligatorio = obligatorio;
	}
}
