package com.inteapp.businessObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.inteapp.dao.EscalaDAO;
import com.inteapp.entities.CategoriaEntity;
import com.inteapp.entities.EscalaEntity;

public class Escala {
	
	private Integer idEscala;
	private Date vigenteDesde;
	private Date vigenteHasta;
	private List<Categoria> categorias;
	
	public Escala(Date vigenteDesde, Date vigenteHasta, List<Categoria> categorias) {
		super();
		this.vigenteDesde = vigenteDesde;
		this.vigenteHasta = vigenteHasta;
		this.categorias = categorias;
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
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public EscalaEntity toEntity(){
		EscalaEntity esc = new EscalaEntity();
		List<CategoriaEntity> cat = new ArrayList<CategoriaEntity>();
		for(Categoria c : this.categorias){
			cat.add(c.toEntity());
		}
		esc.setIdEscala(this.idEscala);
		esc.setCategorias(cat);
		esc.setVigenciaDesde(this.vigenteDesde);
		esc.setVigenciaHasta(this.vigenteHasta);
		return esc;
	}
	public Integer getIdEscala() {
		return idEscala;
	}
	public void setIdEscala(Integer idEscala) {
		this.idEscala = idEscala;
	}
	
	public void save(){
		EscalaDAO.getInstancia().guardar(this);
	}
}
