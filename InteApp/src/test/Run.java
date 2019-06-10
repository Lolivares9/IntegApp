package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.inteapp.hibernate.HibernateUtil;

public class Run {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		if(s.isConnected()){
			System.out.println("Conectado");
		}
		
	}

}
