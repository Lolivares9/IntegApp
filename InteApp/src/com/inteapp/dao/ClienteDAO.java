package com.inteapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.inteapp.businessObject.Cliente;
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
	
	public List<ClienteEntity> getCliente(String cuit){
		List<ClienteEntity> clientesList = new ArrayList<ClienteEntity>();
		
		List<Cliente> clientes;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query = session.createQuery(" from ClientesEntity c where c.cuit = :clie").setParameter("clie",cuit );
		clientesList = query.list();
		for(ClienteEntity ce: clientesList)
			//clientes.add(ce)
		
		session.close();
		return clientesList;
	}

	public Cliente findByCodigo(String cuit) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Cliente c) {
		
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		ClienteEntity cliEnt = new ClienteEntity();
		cliEnt = c.toEntity();
		
		s.beginTransaction();
		s.saveOrUpdate(cliEnt);
		s.getTransaction().commit();
		s.close();
	}
	
}
