package com.inteapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.inteapp.businessObject.Categoria;
import com.inteapp.businessObject.Cliente;
import com.inteapp.businessObject.Empleado;
import com.inteapp.businessObject.Escala;
import com.inteapp.entities.ClienteEntity;
import com.inteapp.entities.EmpleadoEntity;
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
	public void guardar(Cliente clienteBO) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Cliente clienteCarga =  this.buscarCliente(clienteBO.getCuit());
		if (clienteCarga == null){		
			s.beginTransaction();
			ClienteEntity cE = clienteBO.toEntity();
			s.saveOrUpdate(cE);
			s.getTransaction().commit();
			s.close();
		}
	}
	
	
	public Cliente buscarCliente(String cuit){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		ClienteEntity cliEnt;
		Cliente cliente = null;
		cliEnt = (ClienteEntity) s.createQuery("from ClienteEntity where CUIT = ?").setString(0, cuit);
		s.getTransaction().commit();
		if(cliEnt != null)
			cliente = toNegocio(cliEnt);
		
	return cliente;
	}
		
	public Cliente toNegocio(ClienteEntity cli){
		Cliente aux= null;
		List <Empleado> empleados = new ArrayList<Empleado>();
		aux.setCuit(cli.getCuit());
		aux.setDireccion(cli.getDireccion());
		empleados = EmpleadoDAO.getInstancia().empleadosToNegocio(cli.getEmpleados());
		aux.setEmpleados(empleados);
		aux.setRazonSocial(cli.getRazonSocial());
		aux.setLocalidad(cli.getLocalidad());
		aux.setMail(cli.getMail());
		aux.setTelefono(cli.getTelefono());
		aux.setTipoPersona(cli.getTipoPersona());
		
		return aux ;
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
	
 	public void guardarEntity(ClienteEntity cli) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		s.saveOrUpdate(cli);
		s.getTransaction().commit();
		s.close();
	}
	
}
