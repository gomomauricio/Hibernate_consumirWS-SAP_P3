package com.Hibernate_consumirWS-SAP_P3.main; 

import java.text.Format;
import java.text.SimpleDateFormat; 
import java.util.HashMap; 
import java.util.List;
import java.util.Map;
import java.util.Map.Entry; 
import java.util.logging.Level;
import java.util.logging.Logger;

import com.Hibernate_consumirWS-SAP_P3.dao.Hibernate_consumirWS-SAP_P3DAO;
import com.Hibernate_consumirWS-SAP_P3.dao.UtilDAO;
import com.Hibernate_consumirWS-SAP_P3.model.DetalleEnv;
import com.Hibernate_consumirWS-SAP_P3.model.EncabezadoEnv;
import com.Hibernate_consumirWS-SAP_P3.model.ParamEntradaHibernate_consumirWS-SAP_P3;
import com.Hibernate_consumirWS-SAP_P3.util.verifProp; 
/****************************************************************************************************
*FECHA DE CREACIÓN: 31 de Marzo de 2020.
*DESCRIPCIÓN: Objeto para orquestar (Hibernate_consumirWS-SAP_P3) el llamado a los SP y el envio a webservices SAP
*
*ULTIMA MODIFICACION FECHA: 
*ULTIMA MODIFICACION DESCRIPCION: 
*
*@author Mauricio González Mondragón  v2.0.1
******************************************************************************************************/

public class Hibernate_consumirWS-SAP_P3Main 
{

	private Logger log;  
	private Hibernate_consumirWS-SAP_P3DAO emi2020; 
	private static String error;
	private static String info; 
	private UtilDAO utilDAO;
	
	public Hibernate_consumirWS-SAP_P3Main(Logger log) { this.log = log; }

	public void Hibernate_consumirWS-SAP_P3Env( List<String> param )
	{   
		// Enviando a extraccion SP1
		emi2020 = new Hibernate_consumirWS-SAP_P3DAO(log,verifProp.verifArchProp()); 
		utilDAO = new UtilDAO(log, verifProp.verifArchProp());
		
		ParamEntradaHibernate_consumirWS-SAP_P3 parme = new ParamEntradaHibernate_consumirWS-SAP_P3();
		
		try
		{		
			if( param.get(1).toLowerCase().equals("m") )
			 { //java -jar aERP.jar 1 m 06/10/2019 06/10/2019 4 GSEG 1
				parme.setIdOperacion( param.get(0) );
				parme.setIndOMasivo( param.get(1) );
				parme.setFechIni( param.get(2) );
				parme.setFechFin( param.get(3) );
				parme.setIdOrigen( param.get(4) );
				parme.setIdSociedad( param.get(5) );
				parme.setIdInterfaz( param.get(6) );   
			 }
			 else
			 {  
					parme.setIdOperacion( param.get(0) );
					parme.setIndOMasivo( param.get(1) );
					parme.setNumSuc( param.get(2) );
					parme.setNumRam( param.get(3) );
					parme.setNumPol( param.get(4) );
					parme.setTipEnd( param.get(5) );
					parme.setNumEnd( param.get(6) );
					parme.setIdOrigen( param.get(7) ); 
					parme.setIdSociedad( param.get(8) );
					parme.setIdInterfaz( param.get(9) ); 
					
					java.util.Date fecha = new java.util.Date(); 
					Format for1 = new SimpleDateFormat("dd/MM/yyyy"); 
					parme.setFechIni(for1.format(fecha));
			 }
		}
		catch (Exception e) 
		{
			System.out.println("Faltan Parametros, " + e.getMessage());
			 System.exit(0);
		}
		 
		/**** Inicia Extraccion con SP 1 ********************************************/
	     	 
		List<Object[]> rows = emi2020.ExtracSP1(parme);
			//fin del timer DB
				try { utilDAO.tiemposERP(parme,7, "F");  	} catch (Exception e) 	{	}
				
		for(Object[] row : rows)
		{   
			if(row[0] != null) 
				error = row[0].toString();
			
			if(row[2] != null) 
				info =  row[2].toString(); 
		}
		System.out.println(" error = " + error +" - info: " + info + " \n"); 
		log.log(Level.INFO,"SP 1 Hibernate_consumirWS-SAP_P3 terminado con error = " + error +" - info: " + info);
		
		 Map<EncabezadoEnv,List<DetalleEnv>> mapEnvio = new HashMap<EncabezadoEnv, List<DetalleEnv>>();
		
		 if(error.equals("0"))
		 {       
			 System.out.println(" Sin problemas . . . ");
		 
			 try
			 {
				 
				 /**** Inicia Envio con SP 2 ********************************************/
				 mapEnvio = emi2020.ExtracSP2(parme);  
				 	//fin del timer DB
						try { utilDAO.tiemposERP(parme,8, "F");  	} catch (Exception e) 	{	}
					
				 
				 if(mapEnvio.size() < 1)
				 {   
					 System.out.println("No hay registros");
				 }
				 
			 }
			 catch (Exception e) 
			 {
				System.out.println("Error en Hibernate_consumirWS-SAP_P3 main ");
				e.printStackTrace();
			 }
			 
		 }
		 else
		 {
			 System.out.println(" Error al ejecutar Sp_Hibernate_consumirWS-SAP_P3_Sap\n "
			 		          + "    vsqlerror: " + error + "\n"
			 		          + "    verrorinformacion: " + info + "\n");
			 log.log(Level.SEVERE," al ejecutar Sp_Hibernate_consumirWS-SAP_P3_Sap = " + error +" - info: " + info);
		 }
		  
	}
	 
	 
	 
	
}
