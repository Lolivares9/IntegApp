package com.inteapp.businessObject;

import java.util.List;

public class Rubro {
	
	private Integer idRubro;
	private String nombre;
	private String convenio;
	private List <ItemRubro> conceptos;
	
	public Rubro(String nombre, String convenio, List<ItemRubro> conceptos) {
		super();
		this.nombre = nombre;
		this.convenio = convenio;
		this.conceptos = conceptos;
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
	public List<ItemRubro> getConceptos() {
		return conceptos;
	}
	public void setConceptos(List<ItemRubro> conceptos) {
		this.conceptos = conceptos;
	}
	public Integer getIdRubro() {
		return idRubro;
	}
	public void setIdRubro(Integer idRubro) {
		this.idRubro = idRubro;
	}	
}