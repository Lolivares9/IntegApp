package com.inteapp.businessObject;

public class ItemRubro {
	private Concepto concepto;
	private float porcentaje;
	
	public ItemRubro(Concepto concepto, float porcentaje) {
		super();
		this.concepto = concepto;
		this.porcentaje = porcentaje;
	}
	public Concepto getConcepto() {
		return concepto;
	}
	public void setConcepto(Concepto concepto) {
		this.concepto = concepto;
	}
	public float getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}
}
