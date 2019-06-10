package com.inteapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLEADOS")
public class EmpleadoEntity {
	
	@Id
	@Column (name="ID_EMPLEADO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEmpleado;
	
	@ManyToOne
	@JoinColumn(name="ID_EMPLEADO")
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
	
	@Column (name="TIPO_LIQUIDACION")
	private String tipoLiquidacion;
	
	@Column (name="EN_CONVENIO")
	private boolean perteneceConvenio;
	
	@Column (name="CATEGORIA")
	private String categoria;
	
	@Column (name="VACACIONES_DISP")
	private Integer vacacionesDisp;
	
	@Column (name="DIAS_EST_DISP")
	private Integer diasEstudioDisp;
	
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

	public boolean isPerteneceConvenio() {
		return perteneceConvenio;
	}

	public void setPerteneceConvenio(boolean perteneceConvenio) {
		this.perteneceConvenio = perteneceConvenio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
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
}
