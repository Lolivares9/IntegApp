package com.inteapp.businessObject;

public class Factura {

	private Cliente cliente;
	private String descripcion;
	private float importe;

	public Factura(Cliente cliente, String descripcion, float importe) {
		super();
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
}
