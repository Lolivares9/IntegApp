package com.inteapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.inteapp.entities.ClienteEntity;
import com.inteapp.entities.EscalaEntity;
import com.inteapp.hibernate.HibernateUtil;

public class EscalaDAO {
	private static EscalaDAO instancia;
	
	public static EscalaDAO getInstancia() {
		if(instancia == null){
			instancia = new EscalaDAO();
		}
		return instancia;
	}
	
	public void guardar(EscalaEntity c) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.saveOrUpdate(c);
		s.getTransaction().commit();
		s.close();
	}
}
