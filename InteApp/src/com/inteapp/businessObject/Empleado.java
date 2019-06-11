package com.inteapp.businessObject;
import java.util.List;

public class Empleado {
	//Datos personales
	private String cuil;
	private String nombre;
	private String apellido;
	private String direccion;
	private String mail; 
	private String telefono;
	
	//Datos laborales
	private String tipoLiquidacion;
	private int vacacionesDisp;
	private int diasEstudioDisp;
	private boolean convenio;
	private String rubro;
	private String categoria;
	private float salario;
	private List<Novedad> novedades;
	private List<Liquidacion> liquidaciones;ç
	

	public Empleado(String cuil, String nombre, String apellido, String direccion, String mail, String telefono,
			String tipoLiquidacion, int vacacionesDisp, int diasEstudioDisp, boolean convenio, String rubro,
			String categoria, float salario, List<Novedad> novedades, List<Liquidacion> liquidaciones) {
		super();
		this.cuil = cuil;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.mail = mail;
		this.telefono = telefono;
		this.tipoLiquidacion = tipoLiquidacion;
		this.vacacionesDisp = vacacionesDisp;
		this.diasEstudioDisp = diasEstudioDisp;
		this.convenio = convenio;
		this.rubro = rubro;
		this.categoria = categoria;
		this.salario = salario;
		this.novedades = novedades;
		this.liquidaciones = liquidaciones;
	}
	
	public void AltaNovedad(Novedad n) {
		this.novedades.add(n);
	}
	
	public void AltaLiquidacion (Liquidacion l){
		this.liquidaciones.add(l);	
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
	public boolean isConvenio() {
		return convenio;
	}
	public void setConvenio(boolean convenio) {
		this.convenio = convenio;
	}
	public String getRubro() {
		return rubro;
	}
	public void setRubro(String rubro) {
		this.rubro = rubro;
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
	public List<Liquidacion> getLiquidaciones() {
		return liquidaciones;
	}
	public void setLiquidaciones(List<Liquidacion> liquidaciones) {
		this.liquidaciones = liquidaciones;
	}
}
