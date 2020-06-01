package com.Hibernate_consumirWS-SAP_P3.dao;
 
import java.util.Iterator; 
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
 
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Hibernate_consumirWS-SAP_P3.model.ParamEntradaHibernate_consumirWS-SAP_P3;
import com.Hibernate_consumirWS-SAP_P3.util.ConexHib;

/****************************************************************************************************
*FECHA DE CREACIÓN: 30 de Abril de 2020.
*DESCRIPCIÓN: Manejador principal para llamados a funciones generales
*
*ULTIMA MODIFICACION FECHA: 
*ULTIMA MODIFICACION DESCRIPCION: 
*
*@author Mauricio González Mondragón  v0.0.1
******************************************************************************************************/


public class UtilDAO 
{
	private static SessionFactory sessionFactory;
	ConexHib conh; 
	private static final long serialVersionUID = 1L;
	private Logger log2 = Logger.getLogger("Log");
	private static Properties p;
	
    public UtilDAO() { }
	 
	 public UtilDAO(Logger log2 ) {   this.log2 = log2;  } 

	 public UtilDAO(Logger log2,Properties p )
	 {
		 this.log2 = log2;
		 this.p = p;
		 conh = new ConexHib(p);
	 }
	
	
	public Integer tiemposERP(ParamEntradaHibernate_consumirWS-SAP_P3 param,int proceso, String accion)
	{
	   Integer res = 0;
	    
		try
		{
			 sessionFactory = conh.sesSEPTUP();  
		   Session session = sessionFactory.openSession();
			 
			String hql = "CALL sp_bitacora_procesos_erp_sap( " + 
		                param.getIdOperacion() + "," +
					    param.getIdOrigen() + ",'" +
		                param.getIdSociedad() + "'," +
					    param.getIdInterfaz() + ",'" +
					    param.getFechIni() + "'," +
					    proceso + ",'" + accion + "',3,1,'Hibernate_consumirWS-SAP_P3');";  

			 log2.log(Level.INFO," TIMER " + hql);  
			
			Query query = session.createSQLQuery(hql);
			
			@SuppressWarnings("unchecked")
			Iterator<Object> i = query.list().iterator();
				
				while (i.hasNext()) 
				{ 
					Object[] row = (Object[]) i.next(); 
	
					if(row[0] != null) if( row[0] instanceof Integer)  res = (Integer)row[0]  ; 
				} 
			 
				 log2.log(Level.INFO, hql +" finalizado  con " + res ); 
		}
		catch (Exception e) 
		{
			 log2.log(Level.SEVERE,"Error en sp_bitacora_procesos_erp_sap" , e);  
			e.printStackTrace(); 
		} 
		finally
		{
			conh.close(sessionFactory);
		}
		
		 
		
		return res;
	}
	
	  

	 

}
