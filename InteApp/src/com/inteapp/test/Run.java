package com.inteapp.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.inteapp.businessObject.Cliente;
import com.inteapp.dao.ClienteDAO;
import com.inteapp.dao.EscalaDAO;
import com.inteapp.entities.CategoriaEntity;
import com.inteapp.entities.ClienteEntity;
import com.inteapp.entities.EscalaEntity;
import com.inteapp.hibernate.HibernateUtil;

public class Run {

	public static void main(String[] args) {
		EscalaEntity ec = new EscalaEntity();
		List<CategoriaEntity> l = new ArrayList<CategoriaEntity>();
		CategoriaEntity ce = new CategoriaEntity();
		ce.setCategoria("assaddsa");
		ce.setSueldo(111);
		ec.setVigenciaDesde(null);
		ec.setVigenciaHasta(null);
		l.add(ce);
		ec.setCategorias(l);
		
		EscalaDAO es = EscalaDAO.getInstancia();
		es.guardar(ec);
		
	}

}
