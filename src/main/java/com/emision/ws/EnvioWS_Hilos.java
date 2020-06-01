package com.Hibernate_consumirWS-SAP_P3.ws;

 
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.soap.SOAPMessage;

import org.w3c.dom.NodeList;

import com.Hibernate_consumirWS-SAP_P3.model.EnvAConfirmacion;
import com.Hibernate_consumirWS-SAP_P3.util.verifProp;
import com.erp.ws.lib.*;
 

 

public class EnvioWS_Hilos extends Thread  
{
	private Logger log2 = Logger.getLogger("Log");
	 
	 private LLamarServicioLib ws = new LLamarServicioLib();
	 private static  Properties p;
	 
	 public EnvAConfirmacion evc = new EnvAConfirmacion();
	 
	 public Boolean isError = false; //para pruebas de BD mandar con errores
	 
	 
	 
	 public EnvioWS_Hilos() {}
	 
	 
	 public EnvioWS_Hilos(Logger log2, Properties p, EnvAConfirmacion evc, String xml) 
	 {
		 this.log2 = log2;
		 this.p = p;
		 this.evc = evc;
		  
			ws.setCadenaEnvio(xml);
			ws.setNamespace(p.getProperty("nameSpace"));
			ws.setNamespaceURI(p.getProperty("uri"));
			ws.setPassword(p.getProperty("passWS"));
			ws.setSoapActionA(p.getProperty("action"));
			ws.setSoapEndpoUrl(p.getProperty("SoapEndpoUrl"));
			ws.setUsername(p.getProperty("userWS"));
			
//          log2.log(Level.CONFIG, "  ---->>> " + xml ); 
	 }
	  
	 
	 @Override
	   public void run() 
		{ 
//		     envWSErp();  
		     try {  Thread.sleep(1300);  } catch(Exception e) { }
		     
		     		java.util.Date fechas = new java.util.Date();
				
		     		//  p_hora_confir  char(8),   -- FORMATO hh:mm:ss  '08:30:00' 
		     		DateFormat hora = new SimpleDateFormat("HH:mm:ss"); 
				
		     		// fecha  con formato:yyyymmdd  '20200414'
		     		DateFormat fecha = new SimpleDateFormat("yyyyMMdd");
		     		
				 evc.setHoraConf(hora.format(fechas));
				 evc.setFechaConf(fecha.format(fechas));
		     		
		     if(isError)
		     {
		    	 evc.setPolizaContable("");
			     evc.setCodigoError("-1");
			     evc.setEstatus(" ");
			     evc.setMensaje("ERROR Prueba ERP SIN llamado a webservices - " + evc.getIdTransaccion() );
		     }
		     else
		     {
		    	 envWSErp();
			     evc.setPolizaContable( "12" + evc.getIdTransaccion() );
			     evc.setCodigoError("0");
			     evc.setEstatus("A");
			     evc.setMensaje(" Prueba ERP SIN llamado a webservices - " + evc.getIdTransaccion() );
		     }
		     
		}
	 

	public String envWs()
	{
		String res = null; 
		 
		return res;
	}
	
	public List<String> envWSErp()
	{
		List<String> respWS = new ArrayList<String>();  
		
//		System.out.println("Va envio ***");
		
		    String type = null;
	        String id = null;
	        String num = null;
	        String msg = null;
	        String msgV2 = null;
		
		try
		{
 
		   @SuppressWarnings("restriction")
		   SOAPMessage respSOAP = ws.llamaWsLib();
		   
		   System.out.println(" >>>>> " + respSOAP.toString());
		
		    NodeList nType = respSOAP.getSOAPPart().getElementsByTagName("TYPE");
	        NodeList nId = respSOAP.getSOAPPart().getElementsByTagName("ID");
	        NodeList nNum = respSOAP.getSOAPPart().getElementsByTagName("NUMBER");
	        NodeList nMsg = respSOAP.getSOAPPart().getElementsByTagName("MESSAGE");
	        NodeList nMsgV2 = respSOAP.getSOAPPart().getElementsByTagName("MESSAGE_V2");
	        
	       
	        
	        org.w3c.dom.Node node = null;
	        
	        node = nType.item(0);
	        type = node != null ? node.getTextContent() : "";
	        
	        if( type.contains("S") )  // correcto
	        {
	        	node = nId.item(0);
	        	id = node != null ? node.getTextContent() : "";
	             
	        	num = "0";
	            
	            node = nMsg.item(0);
	            msg = node != null ? node.getTextContent() : "";
	            
	            node = nMsgV2.item(0);
	            msgV2 = node != null ? node.getTextContent() : "";
	            String string = msgV2;
	            String[] parts = string.split("RPAT2019");
	            String part1 = parts[0]; // 123 
	            msgV2 = part1;
	        }
	        else
	        {
	        	node = nId.item(1);
	        	id = node != null ? node.getTextContent() : "";
	            
	            node = nNum.item(1);
	            num = node != null ? node.getTextContent() : "";
	            
	            node = nMsg.item(1);
	            msg = "error en ws sap";
	            msg += node != null ? node.getTextContent() : "";
	             
	            msgV2 = "0";
	        } 
	        
	        System.out.println("type: " + type);
	        System.out.println("msgV2: " + msgV2);
	        System.out.println("num: " + num);
	        System.out.println("msg: " + msg);
	        System.out.println("id: " + id);
	        
	        /* quitar Comentarios */
//	        respWS.add(type); //0
//	        respWS.add(msgV2); //1
//	        respWS.add(num); //2
//	        respWS.add(msg); //3 
//	        respWS.add(id);
//	        
		}
		catch (Exception e) 
		{
			 
		}
	        
	        /* Borrar */
	        respWS.add("S"); //0
	        respWS.add("1234567890"); //1
	        respWS.add("0"); //2
	        respWS.add("HardCode Prueba"); //3 
	        respWS.add(id);
	        
	     
	        
//	        System.out.println(" type " + type + 
//	        		" msgV2 " + msgV2 +
//	        		" num " + num +
//	        		" msg " +  msg +
//	        		" id " + id);
 
//	        System.out.println("   -->> " + respWS);
		return respWS;
	}
	
	 
	
}
