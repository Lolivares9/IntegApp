package com.inteapp.dao;

import com.inteapp.businessObject.Concepto;
import com.inteapp.entities.ConceptoEntity;

public class ConceptoDAO {

		private static ConceptoDAO instancia;
		
		public static ConceptoDAO getInstancia() {
			if(instancia == null){
				instancia = new ConceptoDAO();
			}
			return instancia;
		}


		public Concepto toNegocio(ConceptoEntity concepto) {
			
			return new Concepto(concepto.getDescripcion(),concepto.isBasico(),concepto.getDescripcion());
		}
		
		
		
}
