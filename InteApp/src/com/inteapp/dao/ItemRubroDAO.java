package com.inteapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.inteapp.entities.ItemRubroEntity;
import com.inteapp.hibernate.HibernateUtil;

public class ItemRubroDAO {
	private static ItemRubroDAO instancia;
	
	public static ItemRubroDAO getInstancia() {
		if(instancia == null){
			instancia = new ItemRubroDAO();
		}
		return instancia;
	}
	
	
	
}
