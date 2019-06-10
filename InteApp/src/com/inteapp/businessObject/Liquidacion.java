package com.inteapp.businessObject;

import java.util.Date;
import java.util.List;

public class Liquidacion {
	private Empleado empleado;
	Li
	private List<Novedad> novedades;
	private Date fechaDesde;
	private Date fechaHasta;
	private float liqBruta;
	private float liqNeta;
	
	public Liquidacion(Empleado empleado, List<Novedad> novedades, Date fechaDesde, Date fechaHasta, float liqBruta,
			float liqNeta) {
		super();
		this.empleado = empleado;
		this.novedades = novedades;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.liqBruta = liqBruta;
		this.liqNeta = liqNeta;
	}
	public List<Novedad> getNovedades() {
		return novedades;
	}
	public void setNovedades(List<Novedad> novedades) {
		this.novedades = novedades;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
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
}