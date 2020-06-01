package com.Hibernate_consumirWS-SAP_P3.util;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
 

public class CrearXML_Hibernate_consumirWS-SAP_P3 
{
	 private Logger log2 =  Logger.getLogger("Log");
 
	 
	 public CrearXML_Hibernate_consumirWS-SAP_P3() {}
	
	public CrearXML_Hibernate_consumirWS-SAP_P3(Logger log2) 
	{ 
		this.log2 = log2;
	}
	
	
	/**{@code Guardar XMl de envio a sap}
	 * 
	 * @param mapXml map de id unico con xml asociado
	 * 
	 * @return vacio
	 */ 
	public void generaTxt_Pago(Map<String,String> mapXml)
	{ 
           java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_hhmmss");
			
			String IdNomArch = "Hibernate_consumirWS-SAP_P3";
			String nomAr = "ErpSap_"+ IdNomArch + dateFormat.format(date) + ".xml";
         try
         {
        	 File file = new File(nomAr);
        	  
        	 file.createNewFile();
        	 
        	 FileWriter fw = new FileWriter(file);
        	 BufferedWriter bw = new BufferedWriter(fw);
        	 
        	 StringBuilder xml = new StringBuilder();

			 for (  Entry<String,String> llm  : mapXml.entrySet() ) 
			 { 
				 xml.append(llm.getValue() + "\n");
//				 log.log(Level.INFO, llm.getKey() + " " + llm.getValue() ); 
			 }
        	 
        	 bw.write(xml.toString());
        	 bw.close();
         } catch (Exception e) 
         {
        	 System.out.println("Error al crear el archivo");
        	 e.printStackTrace();
         }
		
	}

	 
 

}
