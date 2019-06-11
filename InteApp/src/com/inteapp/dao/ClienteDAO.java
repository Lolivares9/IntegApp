package com.inteapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.inteapp.businessObject.Categoria;
import com.inteapp.businessObject.Cliente;
import com.inteapp.businessObject.Escala;
import com.inteapp.entities.ClienteEntity;
import com.inteapp.entities.EscalaEntity;
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
	
	
	public Cliente buscarCliente(String cuit){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		ClienteEntity cliEnt;
		Cliente cliente = null;
		cliEnt = (ClienteEntity) s.createQuery("from ClienteEntity where CUIT = ?").setString(0, cuit);
		s.getTransaction().commit();
		if(cliEnt != null){
			cliente = toNegocio(cliEnt);
		}
		return cliente;
	}
	
	public Cliente toNegocio(ClienteEntity cli){
		Cliente aux= null;
		
		aux.setCuit(cli.getCuit());
		aux.setDireccion(cli.getDireccion());
		//aux.setEmpleados(cli.getEmpleados());
		aux.setRazonSocial(cli.getRazonSocial());
		aux.setLocalidad(cli.getLocalidad());
		aux.setMail(cli.getMail());
		aux.setTelefono(cli.getTelefono());
		aux.setTipoPersona(cli.getTipoPersona());
		
		return aux ;
	}
	
	public Cliente findByCodigo(String cuit) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
