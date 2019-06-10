package com.inteapp.businessObject;

import java.util.List;

import com.inteapp.enums.Rubro;

public class Empleado {
	private String cuil;
	private String nombre;
	private String apellido;
	private String direccion;
	private String mail; 
	private String telefono;
	private String tipoLiquidacion;
	private boolean convenio;
	private String rubro;
	private String categoria;
	private float salario;
	private List<Concepto> conceptos;
	private int vacacionesDisp;
	private int diasEstudioDisp;
	
	public Empleado(String cuil, String nombre, String apellido, String direccion, String mail, String telefono,
			String tipoLiquidacion, boolean convenio, String categoria, float salario, List<Novedad> novedades,
			int vacacionesDisp, int diasEstudioDisp) {
		super();
		this.cuil = cuil;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.mail = mail;
		this.telefono = telefono;
		this.tipoLiquidacion = tipoLiquidacion;
		this.convenio = convenio;
		this.categoria = categoria;
		this.salario = salario;
		this.novedades = novedades;
		this.vacacionesDisp = vacacionesDisp;
		this.diasEstudioDisp = diasEstudioDisp;
	}
	public String getCuil() {
		return cuil;
	}
	public void setCuil(String cuil) {
		this.cuil = cuil;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
	public String getTipoLiquidacion() {
		return tipoLiquidacion;
	}
	public void setTipoLiquidacion(String tipoLiquidacion) {
		this.tipoLiquidacion = tipoLiquidacion;
	}
	public boolean isConvenio() {
		return convenio;
	}
	public void setConvenio(boolean convenio) {
		this.convenio = convenio;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public List<Novedad> getNovedades() {
		return novedades;
	}
	public void setNovedades(List<Novedad> novedades) {
		this.novedades = novedades;
	}
	public int getVacacionesDisp() {
		return vacacionesDisp;
	}
	public void setVacacionesDisp(int vacacionesDisp) {
		this.vacacionesDisp = vacacionesDisp;
	}
	public int getDiasEstudioDisp() {
		return diasEstudioDisp;
	}
	public void setDiasEstudioDisp(int diasEstudioDisp) {
		this.diasEstudioDisp = diasEstudioDisp;
	}
	
	


	
	
}
