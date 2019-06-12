package com.inteapp.controller;

import com.inteapp.businessObject.Cliente;
import com.inteapp.businessObject.Empleado;
import com.inteapp.dao.ClienteDAO;
import com.inteapp.view.ClienteView;
import com.inteapp.view.EmpleadoView;

public class Liquidador {
	private static Liquidador instance;
	
	public static Liquidador getInstance(){
		if (instance == null){
			instance = new Liquidador();
		}
		return instance;
	}
	
	public boolean altaCliente (ClienteView cteView){
		Cliente c = null;
		c = buscarCliente (cteView);
		if (c == null){
			c = new Cliente(cteView.getRazonSocial(), cteView.getCuit(), cteView.getDireccion(), cteView.getLocalidad(), cteView.getMail(), cteView.getTelefono(), cteView.getTipoPersona(), cteView.getEmpleados());
			c.save();
			return true;
		}else{ //Existe
			System.console().writer().println("Ya existe el cliente!");
			return false;
		}
	}
	
	public boolean liquidarCliente (ClienteView cView) {
		Cliente c = buscarCliente(cView); 
		return c.liquidarEmpleados();
	}
	
	private Cliente buscarCliente(ClienteView cView) {
		Cliente c = ClienteDAO.getInstancia().buscarCliente(cView.getCuit());
		return c;
	}
	
	public boolean altaEmpleado (ClienteView cteView, EmpleadoView empView) {
		Cliente c = null;
		Empleado e = null;
		c = buscarCliente (cteView);
		if (c != null) {
			e = c.buscarEmpleado (e);
			if (e == null) {
				e = new Empleado(empView.getCuil(), empView.getNombre(), empView.getApellido(), empView.getDireccion(), empView.getMail(), empView.getTelefono()
						, empView.getFechaIngreso(), empView.getTipoLiquidacion(), empView.getFechaUltimaLiquidacion(), empView.getFechaProximaLiquidacion()
						, empView.getVacacionesDisp(), empView.getDiasEstudioDisp(), empView.isConvenio(), empView.getRubro(), empView.getCategoriaVigente(), empView.getSalario(), empView.getNovedades(), empView.getLiquidaciones());
				c.AltaEmpleado(e);
				c.save();
				return true;
			}	
		}
		return false;
	}

}
