package com.Hibernate_consumirWS-SAP_P3.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
 

public class verifProp 
{

	public static Properties verifArchProp()
	{
		 String nomArchivo = "ErpProp.properties";
		 
		 Path pt = Paths.get( System.getProperty("user.dir") + "/" + nomArchivo);
		 
		 Properties p = new Properties();

		 try 
		 {
			 p.load(new FileReader( pt.toFile() ));
		 } 
		 catch (FileNotFoundException e) { e.printStackTrace(); } 
		 catch (IOException e) { e.printStackTrace();   }
		 
		 return p;		  
	}
	
	
	
	
}
