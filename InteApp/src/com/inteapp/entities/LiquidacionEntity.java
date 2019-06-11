package com.inteapp.entities;

import java.sql.Date;
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
@Table (name="LIQUIDACIONES")
public class LiquidacionEntity {
	@Id
	@Column (name="ID_LIQUIDACION")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idLiquidacion;
	
	@Column (name="DESCRIPCION")
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="ID_EMPLEADO")
	private EmpleadoEntity empleado;
	
	@Column(name="FECHA_DESDE")
	@Temporal(TemporalType.DATE)
	private Date fechaDesde;
	
	@Column(name="FECHA_HASTA")
	@Temporal(TemporalType.DATE)
	private Date fechaHasta;
	
	@Column (name="LIQ_BRUTA")
	private float liqBruta;
	
	@Column (name="LIQ_NETA")
	private float liqNeta;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="ID_NOVEDAD")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<NovedadEntity> novedades;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="ID_CONCEPTO")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ConceptoEntity> conceptos;

	public LiquidacionEntity(){
	}
	
	public Integer getIdLiquidacion() {
		return idLiquidacion;
	}

	public void setIdLiquidacion(Integer idLiquidacion) {
		this.idLiquidacion = idLiquidacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public EmpleadoEntity getEmpleado() {
		return empleado;
	}

	public void setEmpleado(EmpleadoEntity empleado) {
		this.empleado = empleado;
	}

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public float getLiqBruta() {
		return liqBruta;
	}

	public void setLiqBruta(float liqBruta) {
		this.liqBruta = liqBruta;
	}

	public float getLiqNeta() {
		return liqNeta;
	}

	public void setLiqNeta(float liqNeta) {
		this.liqNeta = liqNeta;
	}

	public List<NovedadEntity> getNovedades() {
		return novedades;
	}

	public void setNovedades(List<NovedadEntity> novedades) {
		this.novedades = novedades;
	}

	public List<ConceptoEntity> getConceptos() {
		return conceptos;
	}

	public void setConceptos(List<ConceptoEntity> conceptos) {
		this.conceptos = conceptos;
	}
}
