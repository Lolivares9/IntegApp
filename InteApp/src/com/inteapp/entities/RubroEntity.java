package com.inteapp.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	private Integer idRUbro;
	
	@Column (name= "nombre")	
	private String nombre;

	@Column (name= "convenio")
	private String convenio;
	
	@OneToMany
	@JoinColumn (name ="ID_ITEM_RUBRO") 
	private List <ItemRubro> itemsRubro;

	@OneToMany
	@JoinColumn (name ="ID_CONCEPTO") 
	private List <ConceptoEntity> conceptos;
	
	public RubroEntity(){
	}

	public Integer getIdRUbro() {
		return idRUbro;
	}

	public void setIdRUbro(Integer idRUbro) {
		this.idRUbro = idRUbro;
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

	public List<ItemRubro> getItemsRubro() {
		return itemsRubro;
	}

	public void setItemsRubro(List<ItemRubro> itemsRubro) {
		this.itemsRubro = itemsRubro;
	}

	public List<ConceptoEntity> getConceptos() {
		return conceptos;
	}

	public void setConceptos(List<ConceptoEntity> conceptos) {
		this.conceptos = conceptos;
	}
	
	
}
