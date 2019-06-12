package com.inteapp.controller;

import java.util.ArrayList;
import java.util.List;

import com.inteapp.businessObject.Cliente;
import com.inteapp.businessObject.Concepto;
import com.inteapp.businessObject.Empleado;
import com.inteapp.businessObject.ItemRubro;
import com.inteapp.businessObject.Novedad;
import com.inteapp.businessObject.Rubro;
import com.inteapp.dao.ClienteDAO;
import com.inteapp.dao.DAOUtils;
import com.inteapp.dao.RubroDAO;
import com.inteapp.view.ClienteView;
import com.inteapp.view.ConceptoView;
import com.inteapp.view.EmpleadoView;
import com.inteapp.view.FacturaView;
import com.inteapp.view.ItemRubroView;
import com.inteapp.view.NovedadView;
import com.inteapp.view.RubroView;

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
			c = DAOUtils.clienteViewToNegocio(cteView);
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
	
	public boolean bajaCliente (ClienteView cteView){
		Cliente c = null;
		c = buscarCliente (cteView);
		if (c != null){
			c.delete();
			return true;
		}else{ //Existe
			System.console().writer().println("El cliente no existe!");
			return false;
		}
	}
	
	public boolean facturarCliente(FacturaView f){
		ClienteView cView = f.getCliente();
		Cliente c = DAOUtils.clienteViewToNegocio(cView);
		return false;
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
				e = DAOUtils.empleadoViewToNegocio(empView);
				c.AltaEmpleado(e);
				c.save();
				return true;
			}	
		}
		return false;
	}
	
	public boolean liquidacionFinalEmpleado (ClienteView cteView, EmpleadoView empView, boolean renuncia) {
		Cliente c = null;
		Empleado e = null;
		c = buscarCliente (cteView);
		if (c != null) {
			e = c.buscarEmpleado (e);
			if (e != null) {
				e.liquidacionFinal(renuncia);
			}
		}
		return false;
	}
	
	public boolean AltaRubro (RubroView rView) {
		Rubro r = null;
		r = buscarRubro (rView);
		if (r == null){
			List<ItemRubro> conceptos = new ArrayList<ItemRubro>();
			ItemRubro itemRubro = null;
			ConceptoView concView = null;
			for (ItemRubroView it : rView.getConceptos()) {
				concView = it.getConcepto();
				Concepto c = new Concepto(concView.getDescripcion(), concView.isObligatorio(), concView.getSigno());
				itemRubro = new ItemRubro(c, it.getPorcentaje());
				conceptos.add(itemRubro);
			}
			//TODO CAMBIAR EL NULL POR ESCALA (VER QUE LLEVA ADENTRO ESCALA)
			r = new Rubro(rView.getNombre(), rView.getConvenio(), conceptos,null);
			r.save();
			return true;
		}else{ //Existe
			System.console().writer().println("Ya existe el Rubro!");
			return false;
		}
	}

	private Rubro buscarRubro(RubroView rView) {
		Rubro r = RubroDAO.getInstancia().buscarRubro(rView.getIdRubro());
		return r;
	}

	public boolean altaNovedad (ClienteView cteView, EmpleadoView empView, NovedadView nView) {
		Cliente c = null;
		Empleado e = null;
		c = buscarCliente (cteView);
		if (c != null) {
			e = c.buscarEmpleado (e);
			if (e != null) {
				ConceptoView cView = nView.getConcepto();
				Concepto con = new Concepto(cView.getDescripcion(), cView.isObligatorio(), cView.getSigno());
				Novedad nov = new Novedad(nView.getFecha(), con, nView.getUnidades());
				e.AltaNovedad(nov);
				c.save();
				return true;
			}
		}
		return false;
	}
}
