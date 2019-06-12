package com.inteapp.dao;

import com.inteapp.businessObject.Rubro;

public class RubroDAO {
	private static RubroDAO instancia;
	
	public static RubroDAO getInstancia() {
		if(instancia == null){
			instancia = new RubroDAO();
		}
		return instancia;
	}

	public void save(Rubro rubro) {
		// TODO Auto-generated method stub
		
	}
}
