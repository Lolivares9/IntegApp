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
	private Integer idRubro;
	
	@Column (name= "nombre")	
	private String nombre;

	@Column (name= "convenio")
	private String convenio;
	
	@OneToMany
	@JoinColumn (name ="ID_ITEM_RUBRO") 
	private List <ItemRubroEntity> itemsRubro;
	
	public RubroEntity(){
	}

	public Integer getIdRubro() {
		return idRubro;
	}

	public void setIdRUbro(Integer idRubro) {
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
}
