package com.inteapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.inteapp.businessObject.Categoria;
import com.inteapp.businessObject.Escala;
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
	
	public void guardar(Escala escBO) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		EscalaEntity escEnt = new EscalaEntity();
		escEnt = escBO.toEntity();
		if(escEnt != null){
			s.beginTransaction();
			s.saveOrUpdate(escEnt);
			s.getTransaction().commit();
			s.close();
		}
	}
	
	public Escala buscarEscala(int idEscala){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		EscalaEntity escEnt;
		Escala escala = null;
		escEnt = (EscalaEntity) s.createQuery("from EscalaEntity where ID_ESCALA = ?").setInteger(0, idEscala);
		s.getTransaction().commit();
		if(escEnt != null){
			escala = toNegocio(escEnt);
		}
		return escala;
	}
	
	public Escala toNegocio(EscalaEntity esc){
		List categorias = new ArrayList<Categoria>();
		categorias = CategoriaDAO.getInstancia().toNegocioAll(esc.getCategorias());
		Escala escalaBO = new Escala(esc.getVigenciaDesde(),esc.getVigenciaHasta(),categorias);
		return escalaBO;
	}
}
