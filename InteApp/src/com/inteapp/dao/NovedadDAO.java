package com.inteapp.dao;

import java.util.ArrayList;
import java.util.List;

import com.inteapp.businessObject.Concepto;
import com.inteapp.businessObject.Novedad;
import com.inteapp.entities.NovedadEntity;

public class NovedadDAO {
private static NovedadDAO instancia;
	
	public static NovedadDAO getInstancia() {
		if(instancia == null){
			instancia = new NovedadDAO();
		}
		return instancia;
	}
	
	public List<Novedad> toNegocioAll(List<NovedadEntity> novedadesEnt){
		List <Novedad> novNegocio = new ArrayList<Novedad>();
		for(NovedadEntity n: novedadesEnt){
			novNegocio.add(novedadesToNegocio(n));
		}
		return novNegocio;
	}
	
	
	public Novedad novedadesToNegocio(NovedadEntity novEnt){
		Concepto conceptoBO = ConceptoDAO.getInstancia().toNegocio(novEnt.getConcepto());
		Novedad novNegocio = new Novedad(novEnt.getFechaNovedad(),conceptoBO, novEnt.getCantDias());//TODO:AgregarConcepto
	return novNegocio;
}

	
	
}
