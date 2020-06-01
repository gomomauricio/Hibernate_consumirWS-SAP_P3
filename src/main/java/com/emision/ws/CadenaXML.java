package com.Hibernate_consumirWS-SAP_P3.ws;

import java.util.List;
import java.util.Map;

import com.Hibernate_consumirWS-SAP_P3.model.DetalleEnv;
import com.Hibernate_consumirWS-SAP_P3.model.EncabezadoEnv;

public class CadenaXML 
{

	static public String setXmlaEnviar( EncabezadoEnv enca,List<DetalleEnv> deta)
	{
		 StringBuilder xmls = new StringBuilder(); 
		
		xmls.append("  <soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:sap-com:document:sap:rfc:functions\">\n" + 
				"   <soapenv:Header/>\n" + 
				"   <soapenv:Body>\n" + 
				"      <urn:ZFI_I0001_INTRF_SEGUROS>\n" + 
				"         <IT_CPD>\n" + 
				"            <!--Zero or more repetitions:-->\n" + 
				"            <item>\n" + 
				"               <XBLNR>" + enca.getIdCPD()+ "</XBLNR> <!--id_transaccion  >>>   Referencia (idTransaccion) *CHAR 16 -->\n" + 
				"               <NAME1>" + enca.getNombre_razon_social() + "</NAME1> <!--N/A  >>>  Nombre *CHAR 35 -->\n" + 
				"               <NAME2>" + enca.getApellido_paterno() + "</NAME2> <!--N/A  >>>  Apellido Paterno *CHAR 35 -->\n" + 
				"               <NAME3>" + enca.getApellido_materno() + "</NAME3> <!--N/A  >>>  Apellido Materno *CHAR 35 -->\n" + 
				"               <NAME4>" + enca.getName4() + "</NAME4> <!--N/A  >>>   *CHAR 35 -->\n" + 
				"               <BANKN>" + enca.getCuenta_bancaria() + "</BANKN> <!--N/A  >>>  Cuenta Bancaria *CHAR 18 -->\n" + 
				"               <BANKL>" + enca.getClave_banco() + "</BANKL> <!--N/A  >>>  Clave del Banco *CHAR 15 -->\n" + 
				"               <BANKS>" + enca.getPais_banco() + "</BANKS> <!--N/A  >>>  Pais del Banco *CHAR 3 -->\n" + 
				"               <STCD1>" + enca.getRfc_persona_fisica() + "</STCD1> <!--N/A  >>>  RFC Persona Fisica *CHAR 16-->\n" + 
				"               <STCD2>" + enca.getRfc_persona_moral() + "</STCD2> <!--N/A  >>>  RFC Persona Moral *CHAR 11 -->\n" + 
				"               <STKZN>" + enca.getPersona_fisica() + "</STKZN> <!--N/A  >>>  Persona fisica *CHAR 1 -->\n" + 
				"               <SMTP_ADDR>" + enca.getCorreo_electronico() + "</SMTP_ADDR> \n" + 
				"            </item>\n" + 
				"         </IT_CPD>\n" + 
				"         <IT_HEADER>\n" + 
				"            <!--Zero or more repetitions:-->\n" + 
				"            <item>\n" + 
				"               <BUKRS>" + enca.getId_sociedad() + "</BUKRS> <!--id_sociedad >>> Sociedad *CHAR 4 -->\n" + 
				"               <BLART>" + enca.getId_operacion() + "</BLART> <!--id_operacion >>> Clase Documento *CHAR 2-->\n" + 
				"               <BLDAT>" + enca.getFecha_Hibernate_consumirWS-SAP_P3() + "</BLDAT> <!--fecha_Hibernate_consumirWS-SAP_P3 >>> Fecha Documento *DAT 8 -->\n" + 
				"               <BUDAT>" + enca.getFecha_Hibernate_consumirWS-SAP_P3_C() + "</BUDAT> <!--fecha_Hibernate_consumirWS-SAP_P3_C >>> Fecha de Contabilización Documento *DAT 8  -->\n" + 
				"               <GJAHR>" + enca.getEjercicio_anio_f_e() + "</GJAHR> <!--ejercicio_anio_f_e  >>>   Ejercicio *NUMC 4-->\n" + 
				"               <XBLNR>" + enca.getId_transaccion()+ "</XBLNR> <!--id_transaccion >>>   Referencia (idTransaccion) *CHAR 16 -->\n" + 
				"               <WAERS>" + enca.getClave_moneda() + "</WAERS> <!--clave_moneda  >>>  Clave Moneda *Char 16 -->\n" + 
				"               <XREF1_HD>" + enca.getRefer_encab_1_hd() + "</XREF1_HD> <!--refer_encab_1_hd  >>>  Referencia Encabezado 1 HD *CHAR 20 -->\n" + 
				"               <!-- numero_asignacion *FALTA-->\n" + 
				"            </item>\n" + 
				"         </IT_HEADER>\n" + 
				"         <IT_ITEM>\n" + 
				"            <!--Zero or more repetitions:-->\n");
		
		       xmls.append( getDetalles(deta)  );
				  
		       xmls.append( "    </IT_ITEM> \n"
		       		      +  "      </urn:ZFI_I0001_INTRF_SEGUROS>\n" + 
		    		   		"   </soapenv:Body>\n" + 
		    		   		"</soapenv:Envelope>\n" );
		
		 String xml = xmls.toString();
		
		return xml;		
	}
	
	
	private static String getDetalles(List<DetalleEnv> lsDet)
	{
		String detalle = null;
		 StringBuilder det = new StringBuilder(); 
		
		for (DetalleEnv dt : lsDet) 
		{
			det.append( "    <item>\n" + 
					"               <XBLNR>" + dt.getId_transaccion() + "</XBLNR> <!--id_transaccion  >>>   Referencia (idTransaccion) *CHAR 16 -->\n" + 
					"               <SGTXT>" + dt.getConcepto() + "</SGTXT> <!--  >>>  TextoPosicion *CHAR 50 -->\n" + 
					"               <DMBTR>" + dt.getLf_importe() + "</DMBTR> <!--  >>>  Importe *CURR 25 -->\n" + 
					"               <HKONT>" + dt.getCuenta_l_m() + "</HKONT> <!-- cuenta_l_m >>>  Cuenta L/M *CHAR10 -->\n" + 
					"               <FIPOS>" + dt.getPosicion_presup() + "</FIPOS> <!--posicion_presup  >>>  Posición presupuestaria *CHAR 14-->\n" + 
					"               <FISTL>" + dt.getCentro_gestor() + "</FISTL> <!--centro_gestor  >>>  Centro Gestor *CHAR 16 -->\n" + 
					"               <GEBER>" + dt.getFondos() + "</GEBER> <!--fondos  >>>  Fondos *CHAR 10 -->\n" + 
					"               <FKBER>" + dt.getArea_funcional() + "</FKBER> <!--area_funcional  >>>  Area Funcional *CHAR 4 -->\n" + 
					"               <KOSTL>" + dt.getCentro_coste() + "</KOSTL> <!--centro_coste  >>>  Centro de coste *CHAR 10 -->\n" + 
					"               <MWSKZ>" + dt.getIndicador_iva() + "</MWSKZ> <!--indicador_iva  >>>  Indicador IVA *CHAR 2 -->\n" + 
					"               <SEGMENT>" + dt.getSegmento() + "</SEGMENT> <!--segmento  >>>  Segmento *CHAR 10 -->\n" + 
					"               <VERTT>" + dt.getClase_contrato() + "</VERTT> <!--clase_contrato  >>>  Clase De Contrato *CHAR 1 -->\n" + 
					"               <PRCTR>" + dt.getLf_ramo() + "</PRCTR> <!--  >>>  Centro De Beneficio *CHAR 10 -->\n" + 
					"               <WERKS>" + dt.getCentro() + "</WERKS> <!--centro  >>>  Centro *CHAR 4 -->\n" + 
					"               <LIFNR>" + dt.getAcreedor_bp() + "</LIFNR> <!--acreedor_bp  >>>  Acreedor(BP) *CHAR 10 -->\n" + 
					"               <ZFBDT>" + dt.getFecha_base() + "</ZFBDT> <!--fecha_base >>>  Fecha base para cálculo del vencimiento *DAT 8 -->\n" + 
					"               <ZTERM>" + dt.getClave_condi_pago() + "</ZTERM> <!--clave_condi_pago  >>>  Clave de condiciones de pago *CHAR 4 -->\n" + 
					"               <ZZUUID>" + dt.getS_uuid() + "</ZZUUID> <!--s_uuid  >>>  UUID *CHAR 23 -->\n" + 
					"               <ZZSEGTO>" + dt.getZ_segmento() + "</ZZSEGTO> <!--z_segmento  >>>  Z Segmento *CHAR 10 -->\n" + 
					"               <ZZTIPO_RVA>" + dt.getZ_tipo_reserva() + "</ZZTIPO_RVA> <!--  >>>  Z Tipo de Reserva *CHAR 40-->\n" + 
					"               <ZZREFCOB>" + dt.getZ_referencia_cobro() + "</ZZREFCOB> <!-- z_referencia_cobro >>>  Z Referencia de cobro *CHAR 20 -->\n" + 
					"               <ZZNUMPOL2>" + dt.getZ_numero_poliza() + "</ZZNUMPOL2> <!--z_numero_poliza  >>>  Z Número de Póliza *CHAR 50-->\n" + 
					"               <ZZNSIN2>" + dt.getZ_numero_siniestro() + "</ZZNSIN2> <!--z_numero_siniestro  >>>  Z Número de Siniestro *CHAR 50 -->\n" + 
					"               <ZZREGION>" + dt.getZ_region() + "</ZZREGION> <!-- z_region >>>  z region *CHAR 3 -->\n" + 
					"               <ZZOFICINA>" + dt.getZ_oficina() + "</ZZOFICINA> <!--z_oficina  >>>  z oficina *CHAR 3 -->\n" + 
					"               <ZZSISTEMA>" + dt.getZ_sistema() + "</ZZSISTEMA> <!--z_sistema  >>>  z sistema *CHAR 8 -->\n" + 
					"               <ZZSUCURSAL>" + dt.getZ_sucursal() + "</ZZSUCURSAL> <!--z_sucursal  >>>  z sucursal *CHAR 8 -->\n" + 
					"               <ZZPAISREAS>" + dt.getZ_pais_reasegurador() + "</ZZPAISREAS> <!--z_pais_reasegurador  >>>  Z País del Reasegurador *CHAR 3 -->\n" + 
					"               <ZZCICLOCUL>" + dt.getZ_ciclo_cultivo() + "</ZZCICLOCUL> <!--z_ciclo_cultivo  >>>  Z Ciclo de Cultivo *CHAR 30  -->\n" + 
					"               <ZZCANDISTR>" + dt.getZ_canal_distrib() + "</ZZCANDISTR> <!--z_canal_distrib  >>>  Z Canal de Distribución *CHAR 50 -->\n" + 
					"               <ZZPRODUCTO>" + dt.getZ_producto() + "</ZZPRODUCTO> <!--z_producto  >>>  Z Producto *CHAR 50 -->\n" + 
					"               <ZZSEGMERCA>" + dt.getZ_segmento_mercado() + "</ZZSEGMERCA> <!--z_segmento_mercado  >>>  Z Segmento de Mercado *CHAR 50 -->\n" + 
					"               <ZZCVEAGENT>" + dt.getZ_clave_agente() + "</ZZCVEAGENT> <!--z_clave_agente  >>>  Z Clave de Agente *NUM 10 -->\n" + 
					"               <ZZNUMSALVA>" + dt.getZ_numero_salvamento() + "</ZZNUMSALVA> <!--z_numero_salvamento  >>>  Z Número de Salvamento *NUM 10 -->\n" + 
					"               <ZZTPENDOSO>" + dt.getTipo_endoso() + "</ZZTPENDOSO> <!--tipo_endoso  >>>   TIPO ENDOSO *CHAR 1-->\n" + 
					"               <ZZTPCONTRI>" + dt.getFisico_moral() + "</ZZTPCONTRI> <!--Fisico_moral  >>>  FISICO/MORAL -->\n" + 
					"               <ZZGRUPO>" + dt.getGru_rea() + "</ZZGRUPO> \n" +
					"               <ZZRAMOPOL>" + dt.getRamo_poliza() + "</ZZRAMOPOL> \n" +
					"               <ZZRAMOPUR>" + dt.getRamo_puro() + "</ZZRAMOPUR> \n" +
					"               <ZZREGIMEN></ZZREGIMEN> \n" +
					"               <ZZTPPROV>" + dt.getTipo_proveedor() + "</ZZTPPROV> <!-- tipo_proveedor >>>  Tipo de proveedor -->\n" + 
					"               <ZZRFCPROV>" + dt.getRfc_proveedor() + "</ZZRFCPROV> <!--rfc_proveedor  >>>   RFC proveedor -->\n" + 
					"               <ZZTPTRANS>?</ZZTPTRANS> \n" + 
					"               <ZZTPGUIA>?</ZZTPGUIA> \n" + 
            		"               <ZZCONCEPTO>?</ZZCONCEPTO> \n" + 
					"            </item> \n");
			
		}
//		System.out.println(" det " + det + " \n");
		
		detalle = det.toString();
		
		return detalle;
	}
	
	
	private static String cNull(String dat)
	{
		if(dat.isEmpty() || dat.equals(null)) dat="";
		
		return dat;
	}
	
}
