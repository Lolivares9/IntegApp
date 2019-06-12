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
	private RubroView rubro;
	private CategoriaView categoriaVigente;
	private float salario;
	private List<NovedadView> novedades;
	private List<LiquidacionView> liquidaciones;
	

	public EmpleadoView(String cuil, String nombre, String apellido, String direccion, String mail, String telefono, Date fechaIngreso,
			String tipoLiquidacion,Date fechaUltimaLiquidacion ,Date fechaProximaLiquidacion,  int vacacionesDisp, int diasEstudioDisp, boolean convenio, RubroView rubro,
			CategoriaView categoriaVigente, float salario, List<NovedadView> novedades, List<LiquidacionView> liquidaciones) {
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
	public RubroView getRubro() {
		return rubro;
	}
	public void setRubro(RubroView rubro) {
		this.rubro = rubro;
	}
	public CategoriaView getCategoriaVigente() {
		return categoriaVigente;
	}
	public void setCategoria(CategoriaView categoriaVigente) {
		this.categoriaVigente = categoriaVigente;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public List<NovedadView> getNovedades() {
		return novedades;
	}
	public void setNovedades(List<NovedadView> novedades) {
		this.novedades = novedades;
	}
	public List<LiquidacionView> getLiquidaciones() {
		return liquidaciones;
	}
	public void setLiquidaciones(List<LiquidacionView> liquidaciones) {
		this.liquidaciones = liquidaciones;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public void setCategoriaVigente(CategoriaView categoriaVigente) {
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
