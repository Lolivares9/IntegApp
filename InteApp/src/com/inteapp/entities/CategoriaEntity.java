package com.inteapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="CATEGORIAS")
public class CategoriaEntity {
	@Id
	@Column (name="ID_CATEGORIA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCategoria;
	
	@Column (name="CATEGORIA")
	private String categoria;
	
	@Column (name="sueldo")
	private float signo;
	
	@ManyToOne
	@JoinColumn(name="ID_ESCALA")
	private EscalaEntity escala;
	
	public CategoriaEntity(){
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public float getSigno() {
		return signo;
	}

	public void setSigno(float signo) {
		this.signo = signo;
	}

	public EscalaEntity getEscala() {
		return escala;
	}

	public void setEscala(EscalaEntity escala) {
		this.escala = escala;
	}
}
