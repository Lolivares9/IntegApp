package com.inteapp.businessObject;

import java.util.Date;

public class Escala {
	
	private Date vigenteDesde;
	private Date vigenteHasta;
	private Categoria categoria;
	
	public Escala(Date vigenteDesde, Date vigenteHasta, Categoria categoria) {
		super();
		this.vigenteDesde = vigenteDesde;
		this.vigenteHasta = vigenteHasta;
		this.categoria = categoria;
	}
	public Date getVigenteDesde() {
		return vigenteDesde;
	}
	public void setVigenteDesde(Date vigenteDesde) {
		this.vigenteDesde = vigenteDesde;
	}
	public Date getVigenteHasta() {
		return vigenteHasta;
	}
	public void setVigenteHasta(Date vigenteHasta) {
		this.vigenteHasta = vigenteHasta;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
