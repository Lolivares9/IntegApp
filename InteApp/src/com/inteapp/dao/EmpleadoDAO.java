package com.inteapp.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.inteapp.businessObject.Categoria;
import com.inteapp.businessObject.Empleado;
import com.inteapp.businessObject.ItemRubro;
import com.inteapp.businessObject.Liquidacion;
import com.inteapp.businessObject.Novedad;
import com.inteapp.businessObject.Rubro;
import com.inteapp.entities.CategoriaEntity;
import com.inteapp.entities.EmpleadoEntity;
import com.inteapp.entities.ItemRubroEntity;
import com.inteapp.entities.RubroEntity;

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
	


//	private String cuil;
//	private String nombre;
//	private String apellido;
//	private String direccion;
//	private String mail; 
//	private String telefono;
//	
//	//Datos laborales
//	private Date fechaIngreso;
//	private String tipoLiquidacion;
//	private Date fechaUltimaLiquidacion;
//	private Date fechaProximaLiquidacion;
//	private int vacacionesDisp;
//	private int diasEstudioDisp;
//	private boolean convenio;
//	private Rubro rubro;
//	private Categoria categoriaVigente;
//	private float salario;
//	private List<Novedad> novedades;
//	private List<Liquidacion> liquidaciones;
	
	
	public List<Empleado> empleadosToNegocio(List<EmpleadoEntity> empleadosEntity) {
		List <Empleado> empleados = new ArrayList<Empleado>();
		List <Liquidacion> liquidaciones = new ArrayList<Liquidacion>();
		List <Novedad> novedades = new ArrayList<Novedad>();
		for(EmpleadoEntity e: empleadosEntity)
		{
			liquidaciones = LiquidacionDAO.getInstancia().liquidacionesToNegocio(e.getLiquidaciones());
			novedades = NovedadDAO.getInstancia().toNegocioAll(e.getNovedades());
			RubroEntity rE= e.getRubro();//rubro
			List <ItemRubro> itemsRubro = new ArrayList<ItemRubro>();
			for (ItemRubroEntity it: rE.getItemsRubro()) {
				itemsRubro.add(RubroDAO.getInstancia().toNegocio(it));
			}
			//TODO REVISAR EN RUBRO, TENGO QUE CAMBIAR EL NULL POR ESCALA
			Rubro r  = new Rubro(rE.getNombre(), rE.getConvenio(), itemsRubro ,null);
			CategoriaEntity cE = e.getCategoria();
			Categoria cat = new Categoria(cE.getCategoria(), cE.getSueldo());
			//categoriaVigente
			Empleado nuevo =new Empleado(e.getCuil(), e.getNombre(), e.getApellido(), e.getDireccion(),e.getMail(),e.getTelefono(), e.getFechaIngreso()
					, e.getTipoLiquidacion(),e.getFechaUltLiq(), e.getFechaProxLiq(), e.getVacacionesDisp(),e.getDiasEstudioDisp(), e.isPerteneceConvenio()
					,r, cat,e.getSalario(),novedades,liquidaciones);
			
		}
		
		
		return null;
	}

}
