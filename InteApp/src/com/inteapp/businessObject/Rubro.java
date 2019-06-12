package com.inteapp.businessObject;

import java.util.ArrayList;
import java.util.List;

import com.inteapp.dao.ClienteDAO;
import com.inteapp.dao.RubroDAO;
import com.inteapp.entities.ClienteEntity;
import com.inteapp.entities.EmpleadoEntity;
import com.inteapp.entities.ItemRubroEntity;
import com.inteapp.entities.RubroEntity;

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
	public List<ItemRubro> getItemsRubroObligatorios() {
		List<ItemRubro> itemsRubro = new ArrayList<ItemRubro>();
		for (ItemRubro ir: conceptos) {
			if (ir.getConcepto().isObligatorio()) {
				itemsRubro.add(ir);
			}
		}
		return itemsRubro;
	}
	public ItemRubro buscarItemRubro(Concepto c) {
		ItemRubro item= null;
		for (ItemRubro it: conceptos) {
			if (it.getConcepto().getDescripcion().equals(c.getDescripcion())) {
				item = it;
			}
		}
		return item;
	}
	public void save() {
		RubroDAO.getInstancia().save(this);
	}
	public RubroEntity toEntity() {
		RubroEntity re = new RubroEntity();
		List<ItemRubroEntity> conceptosE = new ArrayList<ItemRubroEntity>();
		for(ItemRubro it : this.conceptos){
			conceptosE.add(it.toEntity());
		}
		
		re.setIdRubro(this.idRubro);
		re.setNombre(this.nombre);
		re.setConvenio(this.convenio);
		re.setItemsRubro(conceptosE);
		
		return re;
	}	
}
