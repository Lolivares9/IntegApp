package com.inteapp.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.inteapp.businessObject.ItemRubro;

@Entity
@Table (name="RUBROS")
public class RubroEntity {

	@Column (name= "nombre")	
	private String nombre;

	@Column (name= "convenio")
	private String convenio;

	@OneToMany
	@JoinColumn (name ="itemRubro") 
	private List <ItemRubro> conceptos;

	

}
