package com.inteapp.view;


public class ItemRubroView {
	
	private Integer idItemRubro;
	private ConceptoView concepto;
	private float porcentaje;
	
	public ItemRubroView(ConceptoView concepto, float porcentaje) {
		super();
		this.concepto = concepto;
		this.porcentaje = porcentaje;
	}
	public ConceptoView getConcepto() {
		return concepto;
	}
	public void setConcepto(ConceptoView concepto) {
		this.concepto = concepto;
	}
	public float getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}
	public Integer getIdItemRubro() {
		return idItemRubro;
	}
	public void setIdItemRubro(Integer idItemRubro) {
		this.idItemRubro = idItemRubro;
	}
}
