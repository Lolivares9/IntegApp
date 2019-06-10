package com.inteapp.businessObject;

import java.util.List;

public class Cliente {
	
	private String razonSocial;
	private String cuit;
	private String mail;
	private String direccion;
	private String telefono;
	private String nroCuenta;
	private String pais;
	private String tipoPersona;
	private List<Empleado> empleados;
	
	

	public Cliente(String razonSocial, String cuit, String mail, String direccion, String telefono, String nroCuenta,String pais, String tipoPersona, List<Empleado> empleados) {
		super();
		this.razonSocial = razonSocial;
		this.cuit = cuit;
		this.mail = mail;
		this.direccion = direccion;
		this.telefono = telefono;
		this.nroCuenta = nroCuenta;
		this.pais = pais;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCuenta() {
		return nroCuenta;
	}
	public void setCuenta(String cuenta) {
		this.nroCuenta = cuenta;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public List<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	public String getNroCuenta() {
		return nroCuenta;
	}
	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}
	public String getTipoPersona() {
		return tipoPersona;
	}
	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}
	
}
