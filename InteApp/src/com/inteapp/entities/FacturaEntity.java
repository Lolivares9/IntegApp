package com.inteapp.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FACTURAS")
public class FacturaEntity {
	@Id
	@Column (name="ID_FACTURA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFactura;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private ClienteEntity cliente;
	
	@Column (name="DESCRIPCION")
	private String descripcion;
	
	@Column (name="IMPORTE")
	private float importe;

	public FacturaEntity(){
	}
	
	public Integer getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
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
