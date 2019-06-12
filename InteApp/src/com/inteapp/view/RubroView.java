package com.inteapp.view;

import java.util.List;

public class RubroView {
	
	private Integer idRubro;
	private String nombre;
	private String convenio;
	private List <ItemRubroView> conceptos;
	
	public RubroView(String nombre, String convenio, List<ItemRubroView> conceptos) {
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
	public List<ItemRubroView> getConceptos() {
		return conceptos;
	}
	public void setConceptos(List<ItemRubroView> conceptos) {
		this.conceptos = conceptos;
	}
	public Integer getIdRubro() {
		return idRubro;
	}
	public void setIdRubro(Integer idRubro) {
		this.idRubro = idRubro;
	}
}
