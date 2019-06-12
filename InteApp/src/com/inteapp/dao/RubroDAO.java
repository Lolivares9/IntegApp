package com.inteapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.inteapp.businessObject.Cliente;
import com.inteapp.businessObject.Rubro;
import com.inteapp.entities.ClienteEntity;
import com.inteapp.entities.RubroEntity;
import com.inteapp.hibernate.HibernateUtil;

public class RubroDAO {
	private static RubroDAO instancia;
	
	public static RubroDAO getInstancia() {
		if(instancia == null){
			instancia = new RubroDAO();
		}
		return instancia;
	}

	public void save(Rubro rubro) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Rubro r =  this.buscarRubro(rubro.getIdRubro());
		if (r == null){		
			s.beginTransaction();
			RubroEntity rE = rubro.toEntity();
			s.saveOrUpdate(rE);
			s.getTransaction().commit();
			s.close();
		}
	}

	public Rubro buscarRubro(Integer idRubro) {
		// TODO Auto-generated method stub
		return null;
	}
}
