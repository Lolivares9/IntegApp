package com.inteapp.businessObject;
import java.util.Date;

public class Novedad {
	
	private Integer idNovedad;
	private Date fecha;
	private Concepto concepto;
	private int dias;
	
		public Novedad(Date fecha, Concepto concepto, int dias) {
		super();
		this.fecha = fecha;
		this.concepto = concepto;
		this.dias = dias;
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
	public int getDias() {
		return dias;
	}
	public void setDias(int dias) {
		this.dias = dias;
	}
	public Integer getIdNovedad() {
		return idNovedad;
	}
	public void setIdNovedad(Integer idNovedad) {
		this.idNovedad = idNovedad;
	}
}
