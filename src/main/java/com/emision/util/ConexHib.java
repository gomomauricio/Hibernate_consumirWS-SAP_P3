package com.Hibernate_consumirWS-SAP_P3.util;

import java.util.Properties;
import java.util.logging.Level;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ConexHib 
{
	 public static Properties p;
	 
	 public ConexHib( Properties p)
	 {
		 this.p = p;
	 }
	
	 public SessionFactory sesSEPTUP()
	 {
		 SessionFactory sessionFactory = null;
		 
		
		 
		 Configuration configuration = new Configuration(); 
		 
		    configuration.getProperties().setProperty("hibernate.connection.driver_class",p.getProperty("driverDB"));
	        configuration.getProperties().setProperty("hibernate.connection.username", p.getProperty("userDB") );
	        configuration.getProperties().setProperty("hibernate.connection.password", p.getProperty("passDB") );
	        configuration.getProperties().setProperty("hibernate.connection.url", p.getProperty("urlDB"));

	        configuration.configure();

	        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
 
		 try 
		 { 
			 sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		 } catch (Exception ex) {
			    StandardServiceRegistryBuilder.destroy(serviceRegistry); 
			    ex.printStackTrace(); 
		 } 
		  
		 return sessionFactory;
	 }
	 
	 
	 public void close( SessionFactory sessionFactory ) 
	 {
		 sessionFactory.close(); 
	 }
	 
}
