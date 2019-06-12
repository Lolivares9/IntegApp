package com.inteapp.view;

import java.util.Date;

import com.inteapp.businessObject.Concepto;

public class NovedadView {

	
	private Integer idNovedad;
	private Date fecha;
	private Concepto concepto;
	private int unidades;
	
		public NovedadView(Date fecha, Concepto concepto, int unidades) {
		super();
		this.fecha = fecha;
		this.concepto = concepto;
		this.unidades = unidades;
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Concepto getConcepto() {
		return concepto;
	}
	public void setConcepto(Concepto concepto) {
		this.concepto = concepto;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public Integer getIdNovedad() {
		return idNovedad;
	}
	public void setIdNovedad(Integer idNovedad) {
		this.idNovedad = idNovedad;
	}

}
