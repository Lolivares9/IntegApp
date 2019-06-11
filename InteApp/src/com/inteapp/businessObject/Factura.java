package com.inteapp.businessObject;

import java.util.Date;

public class Factura {
	
	private Integer idFactura;
	private Date fecha;
	private Cliente cliente;
	private String descripcion;
	private float importe;


	public Factura(Date fecha, Cliente cliente, String descripcion, float importe) {
		super();
		this.fecha = fecha;
		this.cliente = cliente;
		this.descripcion = descripcion;
		this.importe = importe;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getImporte() {
		return importe;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}	
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public void guardar() {
		
	}
	public Integer getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	};
}
