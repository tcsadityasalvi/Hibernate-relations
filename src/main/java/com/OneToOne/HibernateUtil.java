package com.OneToOne;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

	
	

	public class HibernateUtil {
		private static final SessionFactory sessionFactory = buildSessionFactory();
		 
	    private static SessionFactory buildSessionFactory() {
	        try {
	            
	        	Configuration config = new Configuration()
	        			.configure(new File(HibernateUtil.class
	        					.getClassLoader()
	        					.getResource("hibernate.cfg_OneToOne.xml")
	        					.getFile()));
	            return config.buildSessionFactory();
	 
	        }
	        catch (Throwable ex) {
	            
	           
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	 
	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
	 
	    public static void shutdown() {
	    	
	    	getSessionFactory().close();
	    }
	}


