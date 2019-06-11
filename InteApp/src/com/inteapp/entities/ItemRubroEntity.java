package com.inteapp.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table (name="ITEM_RUBRO")
public class ItemRubroEntity {
	@Id
	@Column (name="ID_ITEM_RUBRO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private String idItemRubro;

	@OneToOne
	@JoinColumn(name="ID_CONCEPTO")
	private ConceptoEntity concepto;
	
	@Column (name= "PORCENTAJE")
	private float porcentaje;

	@ManyToOne
	@JoinColumn(name="ID_RUBRO")
	private RubroEntity rubro;
	
	public ItemRubroEntity(){
	}

	public String getIdItemRubro() {
		return idItemRubro;
	}

	public void setIdItemRubro(String idItemRubro) {
		this.idItemRubro = idItemRubro;
	}

	public ConceptoEntity getConcepto() {
		return concepto;
	}

	public void setConcepto(ConceptoEntity concepto) {
		this.concepto = concepto;
	}

	public float getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}

	public RubroEntity getRubro() {
		return rubro;
	}

	public void setRubro(RubroEntity rubro) {
		this.rubro = rubro;
	}
}
