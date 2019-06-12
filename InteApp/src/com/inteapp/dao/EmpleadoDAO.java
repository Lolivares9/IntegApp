package com.inteapp.dao;

import java.util.ArrayList;
import java.util.List;
import com.inteapp.businessObject.Empleado;

public class EmpleadoDAO {
	private static EmpleadoDAO instancia;
	
	public static EmpleadoDAO getInstancia() {
		if(instancia == null){
			instancia = new EmpleadoDAO();
		}
		return instancia;
	}
	
	
//	public Empleado toNegocio(EmpleadoEntity empEnt){
//		
//	}
	
	
	public List<Empleado> toNegocioAll(List<EmpleadoDAO> empEnt){
		List <Empleado> empNegocio = new ArrayList<Empleado>();
		for(EmpleadoDAO c: empEnt){
			//empNegocio.add(toNegocio(c));
		}
		return empNegocio;
	}
	

}
