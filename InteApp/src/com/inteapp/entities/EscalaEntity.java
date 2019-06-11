package com.inteapp.entities;

import java.sql.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "ESCALAS")
public class EscalaEntity {
	@Id
	@Column (name="ID_ESCALA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEscala;
	
	@Column(name="VIGENCIA_DESDE")
	private Date vigenciaDesde;
	
	@Column(name="VIGENCIA_HASTA")
	private Date vigenciaHasta;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="ID_ESCALA")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<CategoriaEntity> categorias;
	
	public EscalaEntity(){
	}

	public Integer getIdEscala() {
		return idEscala;
	}

	public void setIdEscala(Integer idEscala) {
		this.idEscala = idEscala;
	}

	public Date getVigenciaDesde() {
		return vigenciaDesde;
	}

	public void setVigenciaDesde(Date vigenciaDesde) {
		this.vigenciaDesde = vigenciaDesde;
	}

	public Date getVigenciaHasta() {
		return vigenciaHasta;
	}

	public void setVigenciaHasta(Date vigenciaHasta) {
		this.vigenciaHasta = vigenciaHasta;
	}

	public List<CategoriaEntity> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<CategoriaEntity> categorias) {
		this.categorias = categorias;
	}
}
