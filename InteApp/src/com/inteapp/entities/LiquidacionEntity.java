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
@Table (name="LIQUIDACIONES")
public class LiquidacionEntity {
	@Id
	@Column (name="ID_LIQUIDACION")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idLiquidacion;
	
	@ManyToOne
	@JoinColumn(name="ID_EMPLEADO")
	private EmpleadoEntity empleado;
	
	@Column(name="FECHA_DESDE")
	private Date fechaDesde;
	
	@Column(name="FECHA_HASTA")
	private Date fechaHasta;
	
	@Column (name="LIQ_BRUTA")
	private float liqBruta;
	
	@Column (name="LIQ_NETA")
	private float liqNeta;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="ID_LIQUIDACION")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ItemRubroEntity> itemsRubro;

	public LiquidacionEntity(){
	}
	
	public Integer getIdLiquidacion() {
		return idLiquidacion;
	}

	public void setIdLiquidacion(Integer idLiquidacion) {
		this.idLiquidacion = idLiquidacion;
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

	public List<ItemRubroEntity> getItemsRubro() {
		return itemsRubro;
	}

	public void setItemsRubro(List<ItemRubroEntity> itemsRubro) {
		this.itemsRubro = itemsRubro;
	}
}
