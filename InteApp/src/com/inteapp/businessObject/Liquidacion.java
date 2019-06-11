package com.inteapp.businessObject;

import java.util.Date;
import java.util.List;

public class Liquidacion {
	
	private Integer idLiquidacion;
	private List<ItemRubro> items; 
	private Date fechaDesde;
	private Date fechaHasta;
	private float liqBruta;
	private float liqNeta;

	public Liquidacion(List<ItemRubro> items, Date fechaDesde, Date fechaHasta, float liqBruta,
			float liqNeta) {
		super();
		this.items = items;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.liqBruta = liqBruta;
		this.liqNeta = liqNeta;
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
	public List<ItemRubro> getItems() {
		return items;
	}
	public void setItems(List<ItemRubro> items) {
		this.items = items;
	}
	
	
}
