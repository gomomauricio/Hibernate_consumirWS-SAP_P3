package com.Hibernate_consumirWS-SAP_P3.main;
 
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List; 
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
 
  

/****************************************************************************************************
*FECHA DE CREACIÓN: 30 de Abril de 2020.
*DESCRIPCIÓN: Manejador principal para llamados a SP
*
*ULTIMA MODIFICACION FECHA: 
*ULTIMA MODIFICACION DESCRIPCION: 
*
*@author Mauricio González Mondragón  v0.0.1
******************************************************************************************************/

public class SapHibernate_consumirWS-SAP_P3Main 
{ 
	private static Logger log; 
    	
    private static Hibernate_consumirWS-SAP_P3Main Hibernate_consumirWS-SAP_P3Main;   
	
	public static void main(String[] args) 
	{
		init(); 
		
		List<String> param = new ArrayList<String>();
		
		System.out.println("Inicia Proceso");
		
		if(args.length <= 0 || args.length < 4)
		{ 
			 System.out.println("¡¡ Faltan Opciones !! ( operacion Indv/Masivo parametros . . . )");  
			 System.out.println(" Parametros ");
			 System.out.println("    Hibernate_consumirWS-SAP_P3 ");
			 System.out.println("      Masivo:");
			 System.out.println("        1 m fechIn fechFin IdOrigen idSociedad IdInterfaz");
			 System.out.println("        1 m 06/10/2019 06/10/2019 4 GSEG 1");
			 System.out.println("      Individual:");
			 System.out.println("        1 i num_suc num_ram num_pol tip_end num_end id_origen id_sociedad id_interfaz");
 
		}
		else
		{
			 for(int i = 0; i < args.length; i++) 
			 {
				param.add(args[i]);
			 }
			  
			    System.out.println("      >>> Hibernate_consumirWS-SAP_P3 <<< "); 
			    log.log(Level.FINE,"      >>> Hibernate_consumirWS-SAP_P3 <<<     ");
			    
			    Hibernate_consumirWS-SAP_P3Main = new Hibernate_consumirWS-SAP_P3Main(log);
			    Hibernate_consumirWS-SAP_P3Main.Hibernate_consumirWS-SAP_P3Env(param); 
			    
			    log.log(Level.FINE,"Termina Hibernate_consumirWS-SAP_P3 "); 
		}
		
		System.out.println("\n -- -- Fin proceso - - - - \n");
		 log.log(Level.ALL," -- -- Fin proceso -- -- \n ");
		 System.exit(0); 
	}
	 
 
	
	private static void init()
	{
		Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		log = Logger.getLogger("LogHibernate_consumirWS-SAP_P3");
		log.setLevel(Level.OFF);
		
		FileHandler fhand = null;
		
		try 
		{
			 java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
				DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_hhmmss");
				 
				String nomAr = "LogHibernate_consumirWS-SAP_P3_" + dateFormat.format(date) + ".log";
				fhand = new FileHandler(nomAr, true);
//			fhand = new FileHandler("LogHibernate_consumirWS-SAP_P3.log", true); 
		} 
		catch (SecurityException e) { e.printStackTrace(); } 
		catch (IOException e) {  e.printStackTrace(); }
		
		log.addHandler(fhand);
		log.setLevel(Level.ALL);
		log.setUseParentHandlers(false);
		
		SimpleFormatter formatter = new SimpleFormatter();
		fhand.setFormatter(formatter); 
		log.log(Level.ALL,"<-----------   Inicia proceso Hibernate_consumirWS-SAP_P3  ----------->");
  
	}
	
	

}
