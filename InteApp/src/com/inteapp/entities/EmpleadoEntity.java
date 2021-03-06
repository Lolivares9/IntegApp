package com.inteapp.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "EMPLEADOS")
public class EmpleadoEntity {
	
	@Id
	@Column (name="ID_EMPLEADO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEmpleado;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private ClienteEntity cliente;
	
	@Column (name="CUIL")
	private String cuil;
	
	@Column (name="NOMBRE")
	private String nombre;
	
	@Column (name="APELLIDO")
	private String apellido;
	
	@Column (name="DIRECCION")
	private String direccion;
	
	@Column (name="TELEFONO")
	private String telefono;
	
	@Column(name="FECHA_INGRESO")
	private Date fechaIngreso;
	
	@Column(name="FECHA_ULT_LIQ")
	private Date FechaUltLiq;
	
	@Column(name="FECHA_PROX_LIQ")
	private Date FechaProxLiq;
	
	@Column (name="TIPO_LIQUIDACION")
	private String tipoLiquidacion;
	
	@Column (name="VACACIONES_DISP")
	private Integer vacacionesDisp;
	
	@Column (name="DIAS_EST_DISP")
	private Integer diasEstudioDisp;
	
	@Column (name="EN_CONVENIO")
	private boolean perteneceConvenio;

	@Column (name="MAIL")
	private String mail;
	
	@Column (name="SALARIO")
	private float salario;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="ID_EMPLEADO")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<LiquidacionEntity> liquidaciones;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="ID_NOVEDAD")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<NovedadEntity> novedades;
	
	@ManyToOne
	@JoinColumn(name="ID_RUBRO")
	private RubroEntity rubro;
	
	@ManyToOne
	@JoinColumn(name="ID_CATEGORIA")
	private CategoriaEntity categoria;
	
	public EmpleadoEntity(){
	}

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
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
	
	public Integer getVacacionesDisp() {
		return vacacionesDisp;
	}

	public void setVacacionesDisp(Integer vacacionesDisp) {
		this.vacacionesDisp = vacacionesDisp;
	}

	public Integer getDiasEstudioDisp() {
		return diasEstudioDisp;
	}

	public void setDiasEstudioDisp(Integer diasEstudioDisp) {
		this.diasEstudioDisp = diasEstudioDisp;
	}
	
	public boolean isPerteneceConvenio() {
		return perteneceConvenio;
	}

	public void setPerteneceConvenio(boolean perteneceConvenio) {
		this.perteneceConvenio = perteneceConvenio;
	}
	
	public RubroEntity getRubro() {
		return rubro;
	}

	public void setRubro(RubroEntity rubro) {
		this.rubro = rubro;
	}
	
	public CategoriaEntity getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEntity categoria) {
		this.categoria = categoria;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public List<LiquidacionEntity> getLiquidaciones() {
		return liquidaciones;
	}

	public void setLiquidaciones(List<LiquidacionEntity> liquidaciones) {
		this.liquidaciones = liquidaciones;
	}

	public List<NovedadEntity> getNovedades() {
		return novedades;
	}

	public void setNovedades(List<NovedadEntity> novedades) {
		this.novedades = novedades;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaUltLiq() {
		return FechaUltLiq;
	}

	public void setFechaUltLiq(Date fechaUltLiq) {
		FechaUltLiq = fechaUltLiq;
	}

	public Date getFechaProxLiq() {
		return FechaProxLiq;
	}

	public void setFechaProxLiq(Date fechaProxLiq) {
		FechaProxLiq = fechaProxLiq;
	}
}
