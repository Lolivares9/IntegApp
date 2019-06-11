package com.inteapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONCEPTOS")
public class ConceptoEntity {
	@Id
	@Column (name="ID_CONCEPTO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConcepto;
	
	@Column (name="DESCRIPCION")
	private String descripcion;
	
	@Column (name="BASICO")
	private boolean basico;
	
	@Column (name="SIGNO")
	private String signo;

	public ConceptoEntity(){
	}
	
	public Integer getIdConcepto() {
		return idConcepto;
	}

	public void setIdConcepto(Integer idConcepto) {
		this.idConcepto = idConcepto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isBasico() {
		return basico;
	}

	public void setBasico(boolean basico) {
		this.basico = basico;
	}

	public String getSigno() {
		return signo;
	}

	public void setSigno(String signo) {
		this.signo = signo;
	}
	
}
