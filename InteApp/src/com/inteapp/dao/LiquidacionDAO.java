package com.inteapp.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.inteapp.businessObject.ItemRubro;
import com.inteapp.businessObject.Liquidacion;
import com.inteapp.entities.ItemRubroEntity;
import com.inteapp.entities.LiquidacionEntity;

public class LiquidacionDAO {
	
		private static LiquidacionDAO instancia;
		
		public static LiquidacionDAO getInstancia() {
			if(instancia == null){
				instancia = new LiquidacionDAO();
			}
			return instancia;
		}
		
//		private Integer idLiquidacion;
//		private List<ItemRubro> items; 
//		private Date fechaDesde;
//		private Date fechaHasta;
//		private float liqBruta;
//		private float liqNeta;
//		
		public List<Liquidacion> liquidacionesToNegocio (List<LiquidacionEntity> liqsEntity){
			List<Liquidacion> LiquidacionBO = new ArrayList<Liquidacion>();
			
			
			for (LiquidacionEntity aux : liqsEntity ) {
				List<ItemRubro> rubrosBO = new ArrayList<ItemRubro>();
				for (ItemRubroEntity itrEnt : aux.getItemsRubro()){
					rubrosBO.add(RubroDAO.getInstancia().toNegocio(itrEnt));
				}
				Liquidacion LiqBO = new Liquidacion(rubrosBO,aux.getFechaDesde(),aux.getFechaHasta(),aux.getLiqBruta(),aux.getLiqNeta()); 
				LiquidacionBO.add(LiqBO);
			}
			return null;
		}

}
