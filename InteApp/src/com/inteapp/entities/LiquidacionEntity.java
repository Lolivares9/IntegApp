package com.inteapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="LIQUIDACIONES")
public class LiquidacionEntity {
	@Id
	@Column (name="ID_LIQUIDACION")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idLiquidacion;
}
