package com.inteapp.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.inteapp.businessObject.Categoria;
import com.inteapp.businessObject.Concepto;
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
	
	
	/*/private Integer idNovedad;
	private Date fecha;
	private Concepto concepto;
	private int dias
	/*/
	public Novedad toNegocio(NovedadEntity novEnt){
		Novedad novNegocio = new Novedad(novEnt.getFechaNovedad(),null, novEnt.getCantDias());//TODO:AgregarConcepto
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
