package com.inteapp.controller;

import com.inteapp.businessObject.Cliente;
import com.inteapp.dao.ClienteDAO;
import com.inteapp.view.ClienteView;

public class Liquidador {
	private static Liquidador instance;
	
	public static Liquidador getInstance(){
		if (instance == null){
			instance = new Liquidador();
		}
		return instance;
	}
	
	public boolean liquidarCliente (ClienteView cView) {
		Cliente c = buscarCliente(cView); 
		return c.liquidarEmpleados();
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
	
	private Cliente buscarCliente(ClienteView cView) {
		Cliente c = ClienteDAO.getInstancia().buscarCliente(cView.getCuit());
		return c;
	}
}
