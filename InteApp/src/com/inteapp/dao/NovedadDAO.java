package com.inteapp.dao;

import java.util.ArrayList;
import java.util.List;

import com.inteapp.businessObject.Categoria;
import com.inteapp.businessObject.Novedad;
import com.inteapp.entities.CategoriaEntity;
import com.inteapp.entities.NovedadEntity;

public class NovedadDAO {
private static NovedadDAO instancia;
	
	public static NovedadDAO getInstancia() {
		if(instancia == null){
			instancia = new NovedadDAO();
		}
		return instancia;
	}
	
	
	public Novedad toNegocio(NovedadEntity novEnt){
		Novedad novNegocio = new Novedad(novEnt.getFechaNovedad(), novEnt.getIdNovedad(), novEnt.getCantDias(), novEnt.getConcepto(), novEnt.getEmpleado());
		return novNegocio;
	}
	
	public List<Novedad> toNegocioAll(List<NovedadEntity> novedadesEnt){
		List <Novedad> novNegocio = new ArrayList<Novedad>();
		for(NovedadEntity n: novedadesEnt){
			novNegocio.add(toNegocio(n));
		}
		return novNegocio;
	}
	
}
