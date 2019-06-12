package com.inteapp.view;

import java.util.List;

import com.inteapp.businessObject.Empleado;

public class ClienteView {

	
	private String razonSocial;
	private String cuit;
	private String direccion;
	private String localidad;
	private String mail;
	private String telefono;
	private String tipoPersona;
	private List<EmpleadoView> empleados;
	
	public ClienteView() {};
	
	public ClienteView(String razonSocial, String cuit, String direccion, String localidad, String mail, String telefono,
			String tipoPersona, List<EmpleadoView> empleados) {
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
	public List<EmpleadoView> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(List<EmpleadoView> empleados) {
		this.empleados = empleados;
	}
}
