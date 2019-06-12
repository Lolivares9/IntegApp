package com.inteapp.dao;

import java.util.ArrayList;
import java.util.List;

import com.inteapp.businessObject.Cliente;
import com.inteapp.businessObject.Empleado;
import com.inteapp.view.ClienteView;
import com.inteapp.view.EmpleadoView;

public class DAOUtils {
	public static Cliente clienteViewToNegocio(ClienteView cteView) {
		List <EmpleadoView> empleadosView = cteView.getEmpleados();
		List <Empleado> empleados = new ArrayList<Empleado>();
		
		for (EmpleadoView eView: empleadosView ) {
			Empleado e = DAOUtils.empleadoViewToNegocio(eView);
			empleados.add(e);
		}
		return new Cliente(cteView.getRazonSocial(), cteView.getCuit(), cteView.getDireccion()
				, cteView.getLocalidad(), cteView.getMail(), cteView.getTelefono(), cteView.getTipoPersona()
				, empleados);
	}

	public static Empleado empleadoViewToNegocio(EmpleadoView eView) {
		/*Rubro r 
		
		return new Empleado(empView.getCuil(), empView.getNombre(), empView.getApellido(), empView.getDireccion(), empView.getMail(), empView.getTelefono()
				, empView.getFechaIngreso(), empView.getTipoLiquidacion(), empView.getFechaUltimaLiquidacion(), empView.getFechaProximaLiquidacion()
				, empView.getVacacionesDisp(), empView.getDiasEstudioDisp(), empView.isConvenio(), empView.getRubro(), empView.getCategoriaVigente(), empView.getSalario(), empView.getNovedades(), empView.getLiquidaciones());
		*/
		return null;
	}

}
