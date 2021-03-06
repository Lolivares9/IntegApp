package com.inteapp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="NOVEDADES")
public class NovedadEntity {
	@Id
	@Column (name="ID_NOVEDAD")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idNovedad;
	
	@ManyToOne
	@JoinColumn(name="ID_EMPLEADO")
	private EmpleadoEntity empleado;
	
	@Column(name="FECHA_NOVEDAD")
	@Temporal(TemporalType.DATE)
	private Date fechaNovedad;
	
	@ManyToOne
	@JoinColumn(name="ID_CONCEPTO")
	private ConceptoEntity concepto;
	
	@Column(name="UNIDADES")
	private Integer cantDias;
	
	public NovedadEntity(){
	}
	
	public Integer getIdNovedad() {
		return idNovedad;
	}

	public void setIdNovedad(Integer idNovedad) {
		this.idNovedad = idNovedad;
	}

	public EmpleadoEntity getEmpleado() {
		return empleado;
	}

	public Date getFechaNovedad() {
		return fechaNovedad;
	}

	public void setFechaNovedad(Date fechaNovedad) {
		this.fechaNovedad = fechaNovedad;
	}

	public ConceptoEntity getConcepto() {
		return concepto;
	}

	public void setConcepto(ConceptoEntity concepto) {
		this.concepto = concepto;
	}

	public Integer getCantDias() {
		return cantDias;
	}

	public void setCantDias(Integer cantDias) {
		this.cantDias = cantDias;
	}
}
