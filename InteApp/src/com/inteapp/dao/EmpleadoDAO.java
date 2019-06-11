package com.inteapp.dao;

import java.util.ArrayList;
import java.util.List;

import com.inteapp.businessObject.Categoria;
import com.inteapp.businessObject.Empleado;
import com.inteapp.entities.EmpleadoEntity;

public class EmpleadoDAO {
	private static EmpleadoDAO instancia;
	
	public static EmpleadoDAO getInstancia() {
		if(instancia == null){
			instancia = new EmpleadoDAO();
		}
		return instancia;
	}
	
	
	public Empleado toNegocio(EmpleadoEntity empEnt){
		Empleado empNegocio = new Empleado(
				empEnt.getApellido(),
				empEnt.getCategoria(),
				empEnt.getCuil(),
				empEnt.getDireccion(), 
				empEnt.getNombre(), 
				empEnt.getRubro(),
				empEnt.getTelefono(),
				empEnt.getDiasEstudioDisp(),
				empEnt.getSalario(),
				empEnt.getTipoLiquidacion(),
				empEnt.getVacacionesDisp(),
				empEnt.getIdEmpleado());
		return empNegocio;
	}
	
	public List<Empleado> toNegocioAll(List<EmpleadoDAO> empEnt){
		List <Empleado> empNegocio = new ArrayList<Empleado>();
		for(EmpleadoDAO c: empEnt){
			empNegocio.add(toNegocio(c));
		}
		return empNegocio;
	}
	

}
