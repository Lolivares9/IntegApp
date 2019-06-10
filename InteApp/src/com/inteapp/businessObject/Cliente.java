package com.inteapp.businessObject;

import java.util.List;

public class Cliente {
	
	private String razonSocial;
	private String cuit;
	private String direccion;
	private String localidad;
	private String mail;
	private String telefono;
	private String tipoPersona;
	private List<Empleado> empleados;
	private Cuenta cuentaCliente;
	

	public Cliente(String razonSocial, String cuit, String direccion, String localidad, String mail, String telefono,
			String tipoPersona, List<Empleado> empleados, Cuenta cuenta) {
		super();
		this.razonSocial = razonSocial;
		this.cuit = cuit;
		this.direccion = direccion;
		this.localidad = localidad;
		this.mail = mail;
		this.telefono = telefono;
		this.tipoPersona = tipoPersona;
		this.empleados = empleados;
		this.setCuentaCliente(cuenta);
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
	public Cuenta getCuentaCliente() {
		return cuentaCliente;
	}
	public void setCuentaCliente(Cuenta cuentaCliente) {
		this.cuentaCliente = cuentaCliente;
	}
}
