package com.inteapp.businessObject;

import com.inteapp.entities.ConceptoEntity;

public class Concepto {
	
	private Integer idConcepto;
	private String descripcion;
	private boolean obligatorio;
	private String signo;
	
	public Concepto(String descripcion, boolean obligatorio, String signo) {
		super();
		this.descripcion = descripcion;
		this.obligatorio = obligatorio;
		this.signo = signo;
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
	public Integer getIdConcepto() {
		return idConcepto;
	}
	public void setIdConcepto(Integer idConcepto) {
		this.idConcepto = idConcepto;
	}
	public String getSigno() {
		return signo;
	}
	public void setSigno(String signo) {
		this.signo = signo;
	}
	public ConceptoEntity toEntity() {
		ConceptoEntity cE = new ConceptoEntity();
		
		cE.setIdConcepto(this.idConcepto);
		cE.setDescripcion(this.descripcion);
		cE.setObligatorio(this.obligatorio);
		cE.setSigno(this.signo);
		
		return cE;
	}
}
