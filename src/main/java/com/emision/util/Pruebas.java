package com.Hibernate_consumirWS-SAP_P3.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.Hibernate_consumirWS-SAP_P3.dao.UtilDAO;
import com.Hibernate_consumirWS-SAP_P3.model.DetalleEnv;
import com.Hibernate_consumirWS-SAP_P3.model.EncabezadoEnv;
import com.Hibernate_consumirWS-SAP_P3.ws.CadenaXML;


public class Pruebas {

	private static Logger log; 
	private static String cons1 = "select * from tb_operaciones_sap_dm;";
	
	public static void main(String[] args) 
	{
		String cadXml = "nada";
		
		System.out.println(" Iniciando cadena xml " + cadXml);
		
		EncabezadoEnv enca = getEnca();
        List<DetalleEnv> lsDeta = getDeta();		
		
		cadXml = CadenaXML.setXmlaEnviar(enca, lsDeta);
		
		System.out.println(" >>>>>\n " + cadXml + "\n<<<<<");
		System.out.println("Termina . . . "); 
	
	}
 
	static public EncabezadoEnv getEnca()
	{
		EncabezadoEnv enca = new EncabezadoEnv();
		
		enca.setClave_moneda("MXN");
		enca.setEjercicio_anio_f_e("2020");
		enca.setFecha_Hibernate_consumirWS-SAP_P3("30122020");
		enca.setFecha_Hibernate_consumirWS-SAP_P3_C("29122020");
		enca.setId_operacion("1");
		enca.setId_sociedad("GSEG");
		enca.setId_transaccion("123456");
		enca.setRefer_encab_1_hd(""); 
		
		return enca;
	}
	 
	static public List<DetalleEnv> getDeta()
    {
    	List<DetalleEnv> lsDeta = new ArrayList<DetalleEnv>();
    	DetalleEnv deta;
    	
    	for(int i = 0;i<2;i++)
    	{
    		deta = new DetalleEnv();
    		
    		deta.setId_transaccion("123456");
    		deta.setZ_region("22222");
    		deta.setConcepto("33333");
    		deta.setRamo_poliza(444444);
    		
    		lsDeta.add(deta);
    	}
    	
    	
    	return lsDeta;
    }

}
