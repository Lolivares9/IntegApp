package com.inteapp.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.inteapp.entities.CategoriaEntity;
import com.inteapp.entities.ClienteEntity;
import com.inteapp.entities.*;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	
    static
    {
        try
        {
        	AnnotationConfiguration config = new AnnotationConfiguration();
        	config.addAnnotatedClass(ClienteEntity.class);
        	config.addAnnotatedClass(CategoriaEntity.class);
        	config.addAnnotatedClass(ConceptoEntity.class);
        	config.addAnnotatedClass(EmpleadoEntity.class);
        	config.addAnnotatedClass(EscalaEntity.class);
        	config.addAnnotatedClass(FacturaEntity.class);
        	config.addAnnotatedClass(RubroEntity.class);
        	config.addAnnotatedClass(ItemRubroEntity.class);
        	config.addAnnotatedClass(LiquidacionEntity.class);
        	config.addAnnotatedClass(NovedadEntity.class);
            sessionFactory = config.buildSessionFactory();
        }
        catch (Throwable ex)
        {
            System.out.println(ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
