package com.inteapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.inteapp.entities.ClienteEntity;
import com.inteapp.hibernate.HibernateUtil;

public class ClienteDAO {

	private static ClienteDAO instancia;
	
	public static ClienteDAO getInstancia() {
		if(instancia == null){
			instancia = new ClienteDAO();
		}
		return instancia;
	}
	
	public void guardar(ClienteEntity c) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.saveOrUpdate(c);
		s.getTransaction().commit();
		s.close();
	}
	
}
