package com.inteapp.businessObject;

import java.util.Date;

import com.inteapp.enums.NovedadLiquidacion;

public class Novedad {
	private Date fecha;
	private NovedadLiquidacion conceptoNovedad;
	private int dias;
	
		public Novedad(Date fecha, String concepto, int dias) {
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
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public int getDias() {
		return dias;
	}
	public void setDias(int dias) {
		this.dias = dias;
	}
	
	
}
