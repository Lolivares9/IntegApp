
package com.inteapp.businessObject;

import java.util.ArrayList;
import java.util.List;

import com.inteapp.entities.CategoriaEntity;

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
	
	public CategoriaEntity toEntity() {
		CategoriaEntity ct = new CategoriaEntity();
		ct.setCategoria(categoria);
		ct.setSueldo(sueldo);
		return ct;
	}
	
	public List<CategoriaEntity> toEntityAll(List<Categoria> categoriasBO){
		List<CategoriaEntity> categoriasEntity = new ArrayList<CategoriaEntity>();
		for(Categoria c : categoriasBO){
			categoriasEntity.add(c.toEntity());
		}
		return categoriasEntity;
	}
}
