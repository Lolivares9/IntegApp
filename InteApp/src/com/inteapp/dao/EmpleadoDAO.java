package com.inteapp.dao;

import java.util.ArrayList;
import java.util.List;

import com.inteapp.businessObject.Categoria;
import com.inteapp.businessObject.Empleado;
import com.inteapp.businessObject.Liquidacion;
import com.inteapp.businessObject.Novedad;
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
				empEnt.getCuil(),
				empEnt.getNombre(),
				empEnt.getApellido(),
				empEnt.getDireccion(),
				empEnt.getMail(), 
				empEnt.getCategoria(),
				
				 
				empEnt.getRubro(),
				empEnt.getTelefono(),
				empEnt.getDiasEstudioDisp(),
				empEnt.getSalario(),
				empEnt.getTipoLiquidacion(),
				empEnt.getVacacionesDisp(),
				empEnt.getIdEmpleado());
		return empNegocio;
	}
	
	(String cuil, String nombre, String apellido, String direccion, String mail, String telefono,
			String tipoLiquidacion, int vacacionesDisp, int diasEstudioDisp, boolean convenio, String rubro,
			String categoria, float salario, List<Novedad> novedades, List<Liquidacion> liquidaciones) {
	
	public List<Empleado> toNegocioAll(List<EmpleadoDAO> empEnt){
		List <Empleado> empNegocio = new ArrayList<Empleado>();
		for(EmpleadoDAO c: empEnt){
			empNegocio.add(toNegocio(c));
		}
		return empNegocio;
	}
	

}
