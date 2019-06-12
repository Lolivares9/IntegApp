package com.inteapp.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.inteapp.businessObject.ItemRubro;

@Entity
@Table (name="RUBROS")
public class RubroEntity {
	
	@Id
	@Column (name="ID_RUBRO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRubro;
	
	@Column (name= "NOMBRE_RUBRO")	
	private String nombre;

	@Column (name= "CONVENIO")
	private String convenio;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn (name ="ID_RUBRO") 
	private List <ItemRubroEntity> itemsRubro;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn (name ="ID_RUBRO") 
	private List <EscalaEntity> escalas;
	
	public RubroEntity(){
	}

	public Integer getIdRubro() {
		return idRubro;
	}

	public void setIdRubro(Integer idRubro) {
		this.idRubro = idRubro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	public List<ItemRubroEntity> getItemsRubro() {
		return itemsRubro;
	}

	public void setItemsRubro(List<ItemRubroEntity> itemsRubro) {
		this.itemsRubro = itemsRubro;
	}

	public List<EscalaEntity> getEscalas() {
		return escalas;
	}

	public void setEscalas(List<EscalaEntity> escalas) {
		this.escalas = escalas;
	}
}
