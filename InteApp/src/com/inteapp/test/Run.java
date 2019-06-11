package com.inteapp.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.inteapp.businessObject.Categoria;
import com.inteapp.businessObject.Cliente;
import com.inteapp.businessObject.Escala;
import com.inteapp.dao.ClienteDAO;
import com.inteapp.dao.EscalaDAO;
import com.inteapp.entities.CategoriaEntity;
import com.inteapp.entities.ClienteEntity;
import com.inteapp.entities.EscalaEntity;
import com.inteapp.hibernate.HibernateUtil;

public class Run {

	public static void main(String[] args) {
		Categoria cat = new Categoria("Desarrollador",40000);
		List<Categoria> categorias = new ArrayList<Categoria>();
		categorias.add(cat);
		Escala esc = new Escala(null,null,categorias);
		EscalaDAO es = EscalaDAO.getInstancia();
		es.guardar(esc);
		
	}

}
