package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.inteapp.businessObject.Cliente;
import com.inteapp.dao.ClienteDAO;
import com.inteapp.entities.ClienteEntity;
import com.inteapp.hibernate.HibernateUtil;

public class Run {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		//Cliente cl = new Cliente("asd","12344","aaa","masd","asd","adsads","asdads",null);
		if(s.isConnected()){
			System.out.println("Conectado");
			ClienteEntity cl = new ClienteEntity();
			cl.setRazonSocial("cristian");
			ClienteDAO c = ClienteDAO.getInstancia();
			c.guardar(cl);
		}
		
		s.disconnect();
	}

}
