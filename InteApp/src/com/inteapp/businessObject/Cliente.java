package com.inteapp.businessObject;

import java.util.ArrayList;
import java.util.List;

import com.inteapp.dao.ClienteDAO;
import com.inteapp.entities.CategoriaEntity;
import com.inteapp.entities.ClienteEntity;
import com.inteapp.entities.EmpleadoEntity;
import com.inteapp.entities.EscalaEntity;

public class Cliente {
	
	private Integer idCliente;
	private String razonSocial;
	private String cuit;
	private String direccion;
	private String localidad;
	private String mail;
	private String telefono;
	private String tipoPersona;
	private List<Empleado> empleados;
	
	public Cliente(String razonSocial, String cuit, String direccion, String localidad, String mail, String telefono,String tipoPersona, List<Empleado> empleados) {
		super();
		this.razonSocial = razonSocial;
		this.cuit = cuit;
		this.direccion = direccion;
		this.localidad = localidad;
		this.mail = mail;
		this.telefono = telefono;
		this.tipoPersona = tipoPersona;
		this.empleados = empleados;
	}
	
	public void AltaEmpleado(Empleado e) {
		this.empleados.add(e);
	}
	
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getTipoPersona() {
		return tipoPersona;
	}
	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}
	public List<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	public void save() {
		ClienteDAO.getInstancia().save(this);
	}

	public ClienteEntity toEntity() {
		ClienteEntity ce = new ClienteEntity();
		List<EmpleadoEntity> empleados = new ArrayList<EmpleadoEntity>();
		for(Empleado e : this.empleados){
			empleados.add(e.toEntity());
		}
		ce.setRazonSocial(razonSocial);
		ce.setCuit(cuit);
		ce.setDireccion(direccion);
		ce.setLocalidad(localidad);
		ce.setMail(mail);
		ce.setTelefono(telefono);
		ce.setTipoPersona(tipoPersona);
		ce.setEmpleados(empleados);
		
		return ce;
	}

	public boolean liquidarEmpleados() {
		for (Empleado e: empleados) {
			e.liquidarSueldo();
		}
		return true;
	}
}
