package com.inteapp.view;

import java.util.Date;

import com.inteapp.businessObject.Cliente;

public class FacturaView {
	
	private Integer idFactura;
	private Date fecha;
	private ClienteView cliente;
	private String descripcion;
	private float importe;


	public FacturaView(Date fecha, ClienteView cliente, String descripcion, float importe) {
		super();
		this.fecha = fecha;
		this.cliente = cliente;
		this.descripcion = descripcion;
		this.importe = importe;
	}
	public ClienteView getCliente() {
		return cliente;
	}
	public void setCliente(ClienteView cliente) {
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
