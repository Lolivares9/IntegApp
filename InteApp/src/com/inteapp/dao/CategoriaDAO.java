package com.inteapp.dao;

import java.util.ArrayList;
import java.util.List;

import com.inteapp.businessObject.Categoria;
import com.inteapp.entities.CategoriaEntity;

public class CategoriaDAO {
	private static CategoriaDAO instancia;
	
	public static CategoriaDAO getInstancia() {
		if(instancia == null){
			instancia = new CategoriaDAO();
		}
		return instancia;
	}
	
	
	public Categoria toNegocio(CategoriaEntity catEnt){
		Categoria catNegocio = new Categoria(catEnt.getCategoria(),catEnt.getSueldo());
		catNegocio.setIdCategoria(catEnt.getIdCategoria());
		return catNegocio;
	}
	
	public List<Categoria> toNegocioAll(List<CategoriaEntity> categoriasEnt){
		List <Categoria> catNegocio = new ArrayList<Categoria>();
		for(CategoriaEntity c: categoriasEnt){
			catNegocio.add(toNegocio(c));
		}
		return catNegocio;
	}
	
}
