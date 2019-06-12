package com.inteapp.view;

import java.util.Date;
import java.util.List;
import com.inteapp.businessObject.Categoria;
import com.inteapp.businessObject.Liquidacion;
import com.inteapp.businessObject.Novedad;
import com.inteapp.businessObject.Rubro;
import com.inteapp.entities.EmpleadoEntity;

public class EmpleadoView {

	
	private Integer idEmpleado;
	//Datos personales
	private String cuil;
	private String nombre;
	private String apellido;
	private String direccion;
	private String mail; 
	private String telefono;
	
	//Datos laborales
	private Date fechaIngreso;
	private String tipoLiquidacion;
	private Date fechaUltimaLiquidacion;
	private Date fechaProximaLiquidacion;
	private int vacacionesDisp;
	private int diasEstudioDisp;
	private boolean convenio;
	private Rubro rubro;
	private Categoria categoriaVigente;
	private float salario;
	private List<Novedad> novedades;
	private List<Liquidacion> liquidaciones;
	

	public EmpleadoView(String cuil, String nombre, String apellido, String direccion, String mail, String telefono, Date fechaIngreso,
			String tipoLiquidacion,Date fechaUltimaLiquidacion ,Date fechaProximaLiquidacion,  int vacacionesDisp, int diasEstudioDisp, boolean convenio, Rubro rubro,
			Categoria categoriaVigente, float salario, List<Novedad> novedades, List<Liquidacion> liquidaciones) {
		super();
		this.cuil = cuil;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.mail = mail;
		this.telefono = telefono;
		this.fechaIngreso = fechaIngreso;
		this.tipoLiquidacion = tipoLiquidacion; 
		this.fechaUltimaLiquidacion = fechaUltimaLiquidacion;
		this.fechaProximaLiquidacion = fechaProximaLiquidacion;
		this.vacacionesDisp = vacacionesDisp;
		this.diasEstudioDisp = diasEstudioDisp;
		this.convenio = convenio;
		this.rubro = rubro;
		this.categoriaVigente = categoriaVigente;
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
	public Rubro getRubro() {
		return rubro;
	}
	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}
	public Categoria getCategoriaVigente() {
		return categoriaVigente;
	}
	public void setCategoria(Categoria categoriaVigente) {
		this.categoriaVigente = categoriaVigente;
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

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public void setCategoriaVigente(Categoria categoriaVigente) {
		this.categoriaVigente = categoriaVigente;
	}

	public EmpleadoEntity toEntity() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Date getFechaUltimaLiquidacion() {
		return fechaUltimaLiquidacion;
	}

	public void setFechaUltimaLiquidacion(Date fechaUltimaLiquidacion) {
		this.fechaUltimaLiquidacion = fechaUltimaLiquidacion;
	}

	public Date getFechaProximaLiquidacion() {
		return fechaProximaLiquidacion;
	}

	public void setFechaProximaLiquidacion(Date fechaProximaLiquidacion) {
		this.fechaProximaLiquidacion = fechaProximaLiquidacion;
	}
}
