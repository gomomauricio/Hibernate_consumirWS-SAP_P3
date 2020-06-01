package com.Hibernate_consumirWS-SAP_P3.dao;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Hibernate_consumirWS-SAP_P3.model.DetalleEnv;
import com.Hibernate_consumirWS-SAP_P3.model.EncabezadoEnv;
import com.Hibernate_consumirWS-SAP_P3.model.EnvAConfirmacion;
import com.Hibernate_consumirWS-SAP_P3.model.EnvioResultSP2;
import com.Hibernate_consumirWS-SAP_P3.model.ParamEntradaHibernate_consumirWS-SAP_P3;
import com.Hibernate_consumirWS-SAP_P3.util.ConexHib;
import com.Hibernate_consumirWS-SAP_P3.util.CrearXML_Hibernate_consumirWS-SAP_P3;
import com.Hibernate_consumirWS-SAP_P3.util.verifProp;
import com.Hibernate_consumirWS-SAP_P3.ws.CadenaXML;
import com.Hibernate_consumirWS-SAP_P3.ws.EnvioWS_Hilos;
/****************************************************************************************************
*FECHA DE CREACIÓN: 23 de Marzo de 2020.
*DESCRIPCIÓN: Objeto para manejar el resultado de los 3 SP 
*SP(1).- CALL sp_Hibernate_consumirWS-SAP_P3_sap( p_fec_ini, p_fec_fin, p_id_operacion, p_id_origen,  p_id_sociedad, p_id_interfaz )
*SP(2).-CALL sp_env_Hibernate_consumirWS-SAP_P3_sap_ctrl( p_id_transaccion, p_id_operacion, p_id_origen, p_id_sociedad, p_id_interfaz, p_fecha_proceso )
*SP(3).-CALL sp_conf_Hibernate_consumirWS-SAP_P3_sap_ctrl( pIdTransaccion, p_id_operacion,  p_id_origen, p_id_sociedad, p_id_interfaz, pPolizaCont, pCoderr, pMensaje )  
*
*ULTIMA MODIFICACION FECHA:
*ULTIMA MODIFICACION DESCRIPCION:
*
*@author Mauricio González Mondragón  V.0.0.1
******************************************************************************************************/

public class Hibernate_consumirWS-SAP_P3DAO 
{
	private static SessionFactory sessionFactory;
	private ConexHib conh; 
	private Logger log2 = Logger.getLogger("Log");
	private static Properties p;
	 
	private UtilDAO utilDAO;
	 
	 
	 public Hibernate_consumirWS-SAP_P3DAO() { }
	 
	 public Hibernate_consumirWS-SAP_P3DAO(Logger log2 ) {   this.log2 = log2;  } 

	 public Hibernate_consumirWS-SAP_P3DAO(Logger log2,Properties p )
	 {
		 this.log2 = log2;
		 this.p = p;
		 conh = new ConexHib(p);
		 
		 utilDAO = new UtilDAO(log2, p);
	 }
	 
	 public List<Object[]> ExtracSP1(ParamEntradaHibernate_consumirWS-SAP_P3 param)
	 {
		 System.out.println("SP 1 Hibernate_consumirWS-SAP_P3 Extraccion : ");
		 log2.log(Level.FINE,"SP 1 Hibernate_consumirWS-SAP_P3 Extraccion Hibernate_consumirWS-SAP_P3es:");
		
		 List<Object[]> rows = new ArrayList<Object[]>();
		 
		 String error = "0";
		 String info = ""; 
		 Integer errorSP = 0;
		 
		 try
		 {
			 sessionFactory = conh.sesSEPTUP(); 
			 Session session = sessionFactory.openSession();  
			 

			 String cons = "";
			 if(param.getIndOMasivo().toLowerCase().equals("m"))
			 { 
			    cons = "CALL sp_Hibernate_consumirWS-SAP_P3_sap('" + param.getFechIni() + "','" + param.getFechFin() + "'," + 
			    		                     param.getIdOperacion() + "," + param.getIdOrigen() + ",'" + 
			    		                     param.getIdSociedad() + "'," + param.getIdInterfaz() + ")";
			    System.out.println(" Masivo ");
			 }
			 else
			 {
				 cons = "CALL sp_Hibernate_consumirWS-SAP_P3_sap(" + param.getNumSuc() + "," + param.getNumRam() + "," + param.getNumPol() + ",'" 
			                                   + param.getTipEnd() + "'," + param.getNumEnd() + "," + param.getIdOperacion() + ","  
			                                   + param.getIdOrigen() + ",'" + param.getIdSociedad() + "'," + param.getIdInterfaz() + ")";
				 System.out.println("Individual");
			 }
/////////////////////Caso 1//////////////////////////////////////////Borrar TIMER 
			 java.util.Date fechas = new java.util.Date();
				DateFormat hora = new SimpleDateFormat("HH:mm:ss");
				System.out.println("Hora Inicio: "+ hora.format(fechas));
				
				
			 System.out.println("#Consulta= " + cons);
			 log2.log(Level.CONFIG,"Consulta= " + cons );

			   
			 
				Query query = session.createSQLQuery(cons);  
				
				@SuppressWarnings("unchecked")
				ScrollableResults results = query.scroll(); 

				java.util.Date fechas2 = new java.util.Date();
					DateFormat hora2 = new SimpleDateFormat("HH:mm:ss");
					System.out.println("Hora FIN: "+ hora2.format(fechas2));
					
				 while (results.next()) 
				 {   
					 Object[] row = results.get();
					 rows.add(row);
				 }
				  
				 System.out.println("     Termina sp_Hibernate_consumirWS-SAP_P3_sap con " + rows.size() + " registros");
				 
		 }
		 catch (Exception e) 
		 {
			 System.out.println(" *Exception al ejecutar extraccion Hibernate_consumirWS-SAP_P3: \n " + e.getMessage());
			 log2.log(Level.SEVERE, "ejecutar extraccion Hibernate_consumirWS-SAP_P3 ", e);
			  e.printStackTrace(); 
		 }
		 finally 
		 {
			 conh.close(sessionFactory);
		 }
		 
		
		 
        return rows;
	 }
	
	 
	 
	 public Map<EncabezadoEnv,List<DetalleEnv>> ExtracSP2(ParamEntradaHibernate_consumirWS-SAP_P3 param)
	 {
		 System.out.println("SP 2 Hibernate_consumirWS-SAP_P3 Extraccion Hibernate_consumirWS-SAP_P3es (2020): ");
		 log2.log(Level.FINE,"SP 2 Hibernate_consumirWS-SAP_P3 Extraccion Hibernate_consumirWS-SAP_P3es (2020):"); 
		 
		 List<DetalleEnv> lsDeta = new ArrayList<DetalleEnv>();
		 
		 Map<EncabezadoEnv,List<DetalleEnv>> mapEnvio = new HashMap<EncabezadoEnv, List<DetalleEnv>>();
		  
		 try
		 {
			 sessionFactory = conh.sesSEPTUP(); 
			 Session session = sessionFactory.openSession();   
  
			 String cons = "";
			 
			    cons = "CALL sp_env_Hibernate_consumirWS-SAP_P3_sap_ctrl(" + param.getIdTransaccion() + "," 
			    									   + param.getIdOperacion() + "," 
			    									   + param.getIdOrigen() + ",'" 
			    									   + param.getIdSociedad() + "'," 
			    									   + param.getIdInterfaz() + ",'" 
			    									   + param.getFechIni() + "')";
			    		               
			    
/////////////////////Caso 1//////////////////////////////////////////Borrar TIMER 
		 java.util.Date fechas = new java.util.Date();
			DateFormat hora = new SimpleDateFormat("HH:mm:ss");
			System.out.println("Hora Inicio: "+ hora.format(fechas));
			
			 System.out.println(" Consulta SP2 (2020) = " + cons);
			 log2.log(Level.CONFIG,"Consulta SP2 (2020) = " + cons ); 
			 
				Query query = session.createSQLQuery(cons);  
				
				@SuppressWarnings("unchecked")
				ScrollableResults results = query.scroll(); 
				 
				 String idPiv = "0";
	/////////////////Caso 2 //////////////////////////////////////////Borrar TIMER 
					 java.util.Date fechas2 = new java.util.Date();
						DateFormat hora2 = new SimpleDateFormat("HH:mm:ss");
						System.out.println("Hora FIN: "+ hora2.format(fechas2));
				
				 
				 EnvioResultSP2 deta;
				 List<EnvioResultSP2> lsdeta = new ArrayList<EnvioResultSP2>();
				 Set<String> hsId = new HashSet<String>(); 
				 List<String> mapID = new ArrayList<String>();
				 
				 Boolean isOK = true;
				 System.out.println("Inicia empaquetado . . . "); 
				 int a = 1;
				 while (results.next()) 
				 {   
					 Object[] row = results.get();
					 
					 deta = new EnvioResultSP2(); 
					 
					 if(row[2]!=null) deta.setColumn3( row[2].toString().trim() );  
					 if( deta.getColumn3().contains("No hay Datos") ) { isOK = false;  }
					 else	 
					 {     
							if(row[5] != null) deta.setId_sociedad( row[5].toString().trim() );
							if(row[6] != null) deta.setId_operacion( row[6].toString().trim() );
							if(row[7] != null) deta.setFecha_Hibernate_consumirWS-SAP_P3( row[7].toString().trim() );   // en foemato yyymmdd
							if(row[8] != null) deta.setFecha_Hibernate_consumirWS-SAP_P3_C( row[8].toString().trim() );   // en formato yyymmdd
							if(row[9] != null) deta.setEjercicio_anio_f_e( row[9].toString().trim() );   // año segmento yyyy
							if(row[10] != null)
							{ 
								deta.setId_transaccion( row[10].toString().trim() );
								 hsId.add(deta.getId_transaccion());
							}
							if(row[11] != null) deta.setClave_moneda( row[11].toString().trim() );
							if(row[12] != null) deta.setRefer_encab_1_hd( row[12].toString().trim() );   // si la póliza en nueva o renovada
								 
							/*********** == TERMINA ENCABEZADO  ****************/ 
							if(row[13] != null) deta.setNumero_asignacion( row[13].toString().trim() );   // ctrlrbof3.uso_cfdi  == TERMINA ENCABEZADO == 17  
							if(row[14] != null) deta.setConcepto( row[14].toString().trim() );
							if(row[15] != null) deta.setLf_importe( ((BigDecimal)row[15]).doubleValue() );   // DECIMAL ,lf_pritot_gp
							if(row[16] != null) deta.setCuenta_l_m( row[16].toString().trim() ); 
							if(row[17] != null) deta.setPosicion_presup( row[17].toString().trim() );
							if(row[18] != null) deta.setCentro_gestor( row[18].toString().trim() );   // iruta.num_suc( row[0].toString().trim() ); genprima.ofna_gp o crecibo.num_suc
							if(row[19] != null) deta.setFondos( row[19].toString().trim() );
							if(row[20] != null) deta.setArea_funcional( row[20].toString().trim() );   // ram_rea           ( row[0].toString().trim() );
							if(row[21] != null) deta.setCentro_coste( row[21].toString().trim() );   // iruta.num_suc( row[0].toString().trim() ); genprima.ofna_gp o crecibo.num_suc
							if(row[22] != null) deta.setIndicador_iva( row[22].toString().trim() );
							if(row[23] != null) deta.setSegmento( row[23].toString().trim() );   // ram_rea          ( row[0].toString().trim() );
							if(row[24] != null) deta.setClase_contrato( row[24].toString().trim() );
							if(row[25] != null) deta.setLf_moneda( row[25].toString().trim() );   // 1= MXN 2=USD
							if(row[26] != null) deta.setLf_ramo( row[26].toString().trim() );   // 
							if(row[27] != null) deta.setCentro( row[27].toString().trim() );   // constante  R101 = México 
							if(row[28] != null) deta.setAcreedor_bp( row[28].toString().trim() );
							if(row[29] != null) deta.setFecha_base( row[29].toString().trim() );
							if(row[30] != null) deta.setClave_condi_pago( row[30].toString().trim() );
							if(row[31] != null) deta.setS_uuid( row[31].toString().trim() );   // ctrlrbof3.numcertif
							if(row[32] != null) deta.setZ_segmento( row[32].toString().trim() );
							if(row[33] != null) deta.setZ_tipo_reserva( row[33].toString().trim() );
							if(row[34] != null) deta.setZ_referencia_cobro( row[34].toString().trim() );
							if(row[35] != null) deta.setZ_numero_poliza( row[35].toString().trim() );
							if(row[36] != null) deta.setZ_numero_siniestro( row[36].toString().trim() );
							if(row[37] != null) deta.setZ_region( row[37].toString().trim() );	 
							if(row[38] != null) deta.setZ_oficina( row[38].toString().trim() );  
							if(row[39] != null) deta.setZ_sistema( row[39].toString().trim() );
							if(row[40] != null) deta.setZ_sucursal( row[40].toString().trim() );
							if(row[41] != null) deta.setZ_pais_reasegurador( row[41].toString().trim() ); 
							if(row[42] != null) deta.setZ_ciclo_cultivo( row[42].toString().trim() );
							if(row[43] != null) deta.setZ_canal_distrib( row[43].toString().trim() );
							if(row[44] != null) deta.setZ_producto( row[44].toString().trim() );
							if(row[45] != null) deta.setZ_segmento_mercado( row[45].toString().trim() );
							if(row[46] != null) deta.setZ_clave_agente( row[46].toString().trim() );
							if(row[47] != null) deta.setZ_numero_salvamento( row[47].toString().trim() );
							if(row[48] != null) deta.setTipo_endoso( row[48].toString().trim() ); 
							if(row[49] != null) deta.setGru_rea( ((Short)row[49]).intValue() );  //SMALLINT      
							if(row[50] != null) deta.setRamo_poliza( (Integer)row[50] );
							if(row[51] != null) deta.setRamo_puro( ((Short)row[51]).intValue() );   //SMALLINT  
							
							if(row[52] != null) deta.setFisico_moral( row[52].toString().trim() );
							if(row[53] != null) deta.setTipo_proveedor( row[53].toString().trim() );
							if(row[54] != null) deta.setRfc_proveedor( row[54].toString().trim() );       // ==== TERMINA DETALLE === 38   
							if(row[55] != null) deta.setNombre_razon_social( row[55].toString().trim() );
							if(row[56] != null) deta.setApellido_paterno( row[56].toString().trim() );
							if(row[57] != null) deta.setApellido_materno( row[57].toString().trim() );
							if(row[58] != null) deta.setName4( row[58].toString().trim() );
							if(row[59] != null) deta.setCuenta_bancaria( row[59].toString().trim() );
							if(row[60] != null) deta.setClave_banco( row[60].toString().trim() );
							if(row[61] != null) deta.setPais_banco( row[61].toString().trim() );
							if(row[62] != null) deta.setRfc_persona_fisica( row[62].toString().trim() );
							if(row[63] != null) deta.setRfc_persona_moral( row[63].toString().trim() );
							if(row[64] != null) deta.setPersona_fisica( row[64].toString().trim() );
//							if(row[6] != null) deta.setCorreo_electronico( row[66].toString().trim() );
							
							lsdeta.add(deta);
					 }
					 
					 
				 }
				 System.out.println("Terminado");
				 results = null;
				 log2.log(Level.INFO, "COMPLETO: \n" + lsdeta  + "\n " ); 
				 
				  mapID.addAll(hsId);
				  hsId.clear();
				  
				  if(isOK)
				  { 
					  
					  System.out.println("Envio a crear xml");
					  
					  Map<String,String> mapXml = new HashMap<String, String>();
					  
					  mapXml = getEmpaquetaXML(mapID, lsdeta);
//					  
					  try 
					  {
						  CrearXML_Hibernate_consumirWS-SAP_P3 creaXML = new CrearXML_Hibernate_consumirWS-SAP_P3();
						  creaXML.generaTxt_Pago(mapXml);
					  }catch (Exception e) { }
					 
	 
					  confirmaSP3(mapID, mapXml, param);

				  }
				   
				System.out.println("Termina sp_env_Hibernate_consumirWS-SAP_P3_sap_ctrl con " + mapID.size() + " registros");
				 log2.log(Level.INFO, "Termina sp_env_Hibernate_consumirWS-SAP_P3_sap_ctrl con " + mapID.size()  + " registros" );
				 mapID.clear();
				  lsdeta.clear();
		 }
		 catch (Exception e) 
		 {
			 System.out.println(" *Exception al ejecutar sp_env_Hibernate_consumirWS-SAP_P3_sap_ctrl Hibernate_consumirWS-SAP_P3: \n " + e.getMessage());
			 log2.log(Level.SEVERE, "Exception al ejecutar sp_env_Hibernate_consumirWS-SAP_P3_sap_ctrl Hibernate_consumirWS-SAP_P3: ", e);
			  e.printStackTrace(); 
		 }
		 finally 
		 {
			 conh.close(sessionFactory);
		 }
		   
        return mapEnvio;
	 }
	 
	 
	 
	 
	 

	 
	 private Map<String,String> getEmpaquetaXML(List<String> ids,  List<EnvioResultSP2> lsEnv )
	 { 
		 //  idTransferencia,xml 
		 Map<String,String> mapXml = new HashMap<String, String>();
		 
		 EncabezadoEnv enca = null;
		 DetalleEnv deta = null;
		  
		 List<DetalleEnv> lsdetalles = null;
		 
		 System.out.println("     *********Entra a empaquetar xml por encabezado y detalle*********");
		 
		 for (String id : ids) 
		 { 
			 lsdetalles = new ArrayList<DetalleEnv>();
			 int conta = 1; 
			 
			 for (EnvioResultSP2 env : lsEnv) 
				 { 
					 if( id.equals( env.getId_transaccion() ) )
					 { 
						 enca = new EncabezadoEnv(); 
						 deta = new DetalleEnv();
						 
						    enca.setId_sociedad( env.getId_sociedad());
							enca.setId_operacion( env.getId_operacion());
							enca.setFecha_Hibernate_consumirWS-SAP_P3( env.getFecha_Hibernate_consumirWS-SAP_P3());   
							enca.setFecha_Hibernate_consumirWS-SAP_P3_C( env.getFecha_Hibernate_consumirWS-SAP_P3_C());    
							enca.setEjercicio_anio_f_e( env.getEjercicio_anio_f_e());   
							enca.setId_transaccion( env.getId_transaccion());
							enca.setClave_moneda( env.getClave_moneda());
							enca.setRefer_encab_1_hd( env.getRefer_encab_1_hd());   
							 
							enca.setNombre_razon_social(env.getNombre_razon_social());
							enca.setApellido_paterno( env.getApellido_paterno());  
							enca.setApellido_materno( env.getApellido_materno());  
							enca.setName4( env.getName4());  
							enca.setCuenta_bancaria( env.getCuenta_bancaria());  
							enca.setClave_banco( env.getClave_banco());  
							enca.setPais_banco( env.getPais_banco());  
							enca.setRfc_persona_fisica( env.getRfc_persona_fisica());  
							enca.setRfc_persona_moral( env.getRfc_persona_moral());  
							enca.setPersona_fisica( env.getPersona_fisica());  
							enca.setCorreo_electronico( env.getCorreo_electronico());  
//							enca.setIdCPD( env.getIdCPD());   // solo si usa la parte de CPD ---> id transaccion
							
							
						 						/*********** == TERMINA ENCABEZADO  ****************/ 
						 
						 deta.setId_transaccion( env.getId_transaccion()  );
						 
						 deta.setNumero_asignacion( env.getNumero_asignacion()  );   // ctrlrbof3.uso_cfdi  == TERMINA ENCABEZADO == 17  
						 deta.setConcepto( env.getConcepto()  );
						 deta.setLf_importe( env.getLf_importe() );   // DECIMAL ,lf_pritot_gp
						 deta.setCuenta_l_m( env.getCuenta_l_m()  ); 
						 deta.setPosicion_presup( env.getPosicion_presup()  );
						 deta.setCentro_gestor( env.getCentro_gestor()  );   // iruta.num_suc( env.get[0()  ); genprima.ofna_gp o crecibo.num_suc
						 deta.setFondos( env.getFondos()  );
						 deta.setArea_funcional( env.getArea_funcional()  );   // ram_rea           ( env.get[0()  );
						 deta.setCentro_coste( env.getCentro_coste()  );   // iruta.num_suc( env.get[0()  ); genprima.ofna_gp o crecibo.num_suc
						 deta.setIndicador_iva( env.getIndicador_iva()  );
						 deta.setSegmento( env.getSegmento()  );   // ram_rea          ( env.get[0()  );
						 deta.setClase_contrato( env.getClase_contrato()  );
						 deta.setLf_moneda( env.getLf_moneda()  );   // 1= MXN 2=USD
						 deta.setLf_ramo( env.getLf_ramo()  );   // 
						 deta.setCentro( env.getCentro()  );   // constante  R101 = México 
						 deta.setAcreedor_bp( env.getAcreedor_bp()  );
						 deta.setFecha_base( env.getFecha_base()  );
						 deta.setClave_condi_pago( env.getClave_condi_pago()  );
						 deta.setS_uuid( env.getS_uuid()  );   // ctrlrbof3.numcertif
						 deta.setZ_segmento( env.getZ_segmento()  );
						 deta.setZ_tipo_reserva( env.getZ_tipo_reserva()  );
						 deta.setZ_referencia_cobro( env.getZ_referencia_cobro()  );
						 deta.setZ_numero_poliza( env.getZ_numero_poliza()  );
						 deta.setZ_numero_siniestro( env.getZ_numero_siniestro()  );
						 deta.setZ_region( env.getZ_region()  );	 
						 deta.setZ_oficina( env.getZ_oficina()  );  
						 deta.setZ_sistema( env.getZ_sistema()  );
						 deta.setZ_sucursal( env.getZ_sucursal()  );
						 deta.setZ_pais_reasegurador( env.getZ_pais_reasegurador()  ); 
						 deta.setZ_ciclo_cultivo( env.getZ_ciclo_cultivo()  );
						 deta.setZ_canal_distrib( env.getZ_canal_distrib()  );
						 deta.setZ_producto( env.getZ_producto()  );
						 deta.setZ_segmento_mercado( env.getZ_segmento_mercado()  );
						 deta.setZ_clave_agente( env.getZ_clave_agente()  );
						 deta.setZ_numero_salvamento( env.getZ_numero_salvamento()  );
						 deta.setTipo_endoso( env.getTipo_endoso()  ); 
						 deta.setGru_rea( env.getGru_rea() );  //SMALLINT      
						 deta.setRamo_poliza( env.getRamo_poliza() );
						 deta.setRamo_puro( env.getRamo_puro() );   //SMALLINT   
						 deta.setFisico_moral( env.getFisico_moral() );
						 deta.setTipo_proveedor( env.getTipo_proveedor()  );
						 deta.setRfc_proveedor( env.getRfc_proveedor()  );       // ==== TERMINA DETALLE === 38   
						 
						
						 lsdetalles.add(deta);
					 } //if id == id
					 
				 } // for envio SP2
			 
			    mapXml.put( enca.getId_transaccion(), CadenaXML.setXmlaEnviar(enca, lsdetalles) ); 
		 } 
		 
		 return mapXml;
	 }
	 
	 
	 
	 
	  /**  {@code Con entrada de XML} */
	 ///Confirma SP3 con xml de envio
	 public void confirmaSP3(List<String> lId, Map<String,String> mapXml,ParamEntradaHibernate_consumirWS-SAP_P3 param)
	 {  
			Integer ids = lId.size();
		
			System.out.println( ids + " Id transaccion por enviar" );
			log2.log(Level.FINE, ids + " Id transaccion por enviar" );
			 
			log2.log(Level.INFO, "Inicia confirmacion de registros WebServices ( *sin llamado REAL )...."); 
			System.out.println("Inicia confirmacion de registros WebServices ( *sin llamado REAL )....");
			 
			//////////////////////////////////////////////////////////////////////////////////////
			 
			Properties p = verifProp.verifArchProp();
			
			EnvioWS_Hilos uno1 = null, uno2 = null, uno3 = null, uno4 = null, uno5 = null; 
			EnvioWS_Hilos uno6 = null, uno7 = null, uno8 = null, uno9 = null, uno10 = null; 	
			EnvioWS_Hilos uno11 = null, uno12 = null, uno13 = null, uno14 = null, uno15 = null; 	
			EnvioWS_Hilos uno16 = null, uno17 = null, uno18 = null, uno19 = null, uno20 = null; 	
		 
			
			
				Integer total = ids;

				Integer cont = 1;  
				Integer conteo = 0;
				Integer tope = 20;
				Integer sobran = (total%tope);
				Integer enciclo = total - sobran;
			 
			  List<String> listIds = new ArrayList<String>();  //para alamcenar los ids de transaccion para cada envio
			  List<EnvAConfirmacion> listEnvioConfirma = new ArrayList<EnvAConfirmacion>(); 
			  List<String> lsxml = new ArrayList<String>();
			  
			  int i = 0;
			  
			  for (String st : lId) 	  
			  {
				  i++; 
				  if(enciclo >= i )
				  {
					  if(cont < tope)
					  {
						  cont++; 
						  listIds.add(st); 
						  for(  Entry<String, String> llm  : mapXml.entrySet() ) 
						  { 
							  if(llm.getKey().equals(st))
								  		lsxml.add(llm.getValue());
						  }
							continue;
					  }
					  else 
					  { 
						  listIds.add(st); 
						  for(  Entry<String, String> llm  : mapXml.entrySet() ) 
						  { 
							  if(llm.getKey().equals(st))
								  		lsxml.add(llm.getValue());  
						  }
						   
						  conteo += cont;  
						  cont = 1;
							EnvAConfirmacion evc1 = new EnvAConfirmacion(listIds.get(0).toString()); 
							EnvAConfirmacion evc2 = new EnvAConfirmacion(listIds.get(1).toString());
							EnvAConfirmacion evc3 = new EnvAConfirmacion(listIds.get(2).toString());
							EnvAConfirmacion evc4 = new EnvAConfirmacion(listIds.get(3).toString());
							EnvAConfirmacion evc5 = new EnvAConfirmacion(listIds.get(4).toString());
							EnvAConfirmacion evc6 = new EnvAConfirmacion(listIds.get(5).toString());
							EnvAConfirmacion evc7 = new EnvAConfirmacion(listIds.get(6).toString());
							EnvAConfirmacion evc8 = new EnvAConfirmacion(listIds.get(7).toString());
							EnvAConfirmacion evc9 = new EnvAConfirmacion(listIds.get(8).toString());
							EnvAConfirmacion evc10 = new EnvAConfirmacion(listIds.get(9).toString());
							EnvAConfirmacion evc11 = new EnvAConfirmacion(listIds.get(10).toString());
							EnvAConfirmacion evc12 = new EnvAConfirmacion(listIds.get(11).toString());
							EnvAConfirmacion evc13 = new EnvAConfirmacion(listIds.get(12).toString());
							EnvAConfirmacion evc14 = new EnvAConfirmacion(listIds.get(13).toString());
							EnvAConfirmacion evc15 = new EnvAConfirmacion(listIds.get(14).toString());
							EnvAConfirmacion evc16 = new EnvAConfirmacion(listIds.get(15).toString());
							EnvAConfirmacion evc17 = new EnvAConfirmacion(listIds.get(16).toString());
							EnvAConfirmacion evc18 = new EnvAConfirmacion(listIds.get(17).toString());
							EnvAConfirmacion evc19 = new EnvAConfirmacion(listIds.get(18).toString());
							EnvAConfirmacion evc20 = new EnvAConfirmacion(listIds.get(19).toString()); 
							
							cont = 1;
									 
							uno1 = new EnvioWS_Hilos( log2,p,evc1, lsxml.get(0) );  	uno2 = new EnvioWS_Hilos( log2,p,evc2, lsxml.get(1)  ); 
							uno3 = new EnvioWS_Hilos( log2,p,evc3, lsxml.get(2)  );    uno4 = new EnvioWS_Hilos( log2,p,evc4, lsxml.get(3)  ); 
							uno5 = new EnvioWS_Hilos( log2,p,evc5, lsxml.get(4)  );    uno6 = new EnvioWS_Hilos( log2,p,evc6, lsxml.get(5)  ); 
							uno7 = new EnvioWS_Hilos( log2,p,evc7, lsxml.get(6)  );    uno8 = new EnvioWS_Hilos( log2,p,evc8, lsxml.get(7)  ); 
							uno9 = new EnvioWS_Hilos( log2,p,evc9, lsxml.get(8)  );    uno10 = new EnvioWS_Hilos( log2,p,evc10, lsxml.get(9)  );
							
							uno11 = new EnvioWS_Hilos( log2,p,evc11, lsxml.get(10)  );  uno12 = new EnvioWS_Hilos( log2,p,evc12, lsxml.get(11)  ); 
							uno13 = new EnvioWS_Hilos( log2,p,evc13, lsxml.get(12)  );  uno14 = new EnvioWS_Hilos( log2,p,evc14, lsxml.get(13)  ); 
							uno15 = new EnvioWS_Hilos( log2,p,evc15, lsxml.get(14)  );  uno16 = new EnvioWS_Hilos( log2,p,evc16, lsxml.get(15)  ); 
							uno17 = new EnvioWS_Hilos( log2,p,evc17, lsxml.get(16)  );  uno18 = new EnvioWS_Hilos( log2,p,evc18, lsxml.get(17)  ); 
							uno19 = new EnvioWS_Hilos( log2,p,evc19, lsxml.get(18)  );  uno20 = new EnvioWS_Hilos( log2,p,evc20, lsxml.get(19)  );
							
							uno1.start(); 	uno2.start(); 	uno3.start(); 	uno4.start();
							uno5.start();   uno6.start();   uno7.start();   uno8.start();
							uno9.start();   uno10.start();  uno11.start();  uno12.start();
							uno13.start();  uno14.start();  uno15.start();  uno16.start();
							uno17.start();  uno18.start(); 	uno19.start();  uno20.start(); 
							
							 if(uno1.isAlive()) while(uno1.isAlive()) {	 }  
							 if(uno2.isAlive()) while(uno2.isAlive()) { }  
							 if(uno3.isAlive()) while(uno3.isAlive()) { }  
							 if(uno4.isAlive()) while(uno4.isAlive()) { }  
							 if(uno5.isAlive()) while(uno5.isAlive()) { }  
							 if(uno6.isAlive()) while(uno6.isAlive()) { }  
							 if(uno7.isAlive()) while(uno7.isAlive()) { }  
							 if(uno8.isAlive()) while(uno8.isAlive()) { }  
							 if(uno9.isAlive()) while(uno9.isAlive()) { }  
							 if(uno10.isAlive()) while(uno10.isAlive()) { }  
							 
							 if(uno11.isAlive()) while(uno11.isAlive()) { }  
							 if(uno12.isAlive()) while(uno12.isAlive())  { }  
							 if(uno13.isAlive()) while(uno13.isAlive())  { }  
							 if(uno14.isAlive()) while(uno14.isAlive())  { }  
							 if(uno15.isAlive()) while(uno15.isAlive())  { }  
							 if(uno16.isAlive()) while(uno16.isAlive())  { }  
							 if(uno17.isAlive()) while(uno17.isAlive())  { }  
							 if(uno18.isAlive()) while(uno18.isAlive())  { }  
							 if(uno19.isAlive()) while(uno19.isAlive())  { }  
							 if(uno20.isAlive()) while(uno20.isAlive())  { }  
							  
							 listEnvioConfirma.add( uno1.evc);
							 listEnvioConfirma.add( uno2.evc);
							 listEnvioConfirma.add( uno3.evc);
							 listEnvioConfirma.add( uno4.evc);
							 listEnvioConfirma.add( uno5.evc);
							 listEnvioConfirma.add( uno6.evc);
							 listEnvioConfirma.add( uno7.evc);
							 listEnvioConfirma.add( uno8.evc);
							 listEnvioConfirma.add( uno9.evc);
							 listEnvioConfirma.add( uno10.evc);
							 
							 listEnvioConfirma.add( uno11.evc);
							 listEnvioConfirma.add( uno12.evc);
							 listEnvioConfirma.add( uno13.evc);
							 listEnvioConfirma.add( uno14.evc);
							 listEnvioConfirma.add( uno15.evc);
							 listEnvioConfirma.add( uno16.evc);
							 listEnvioConfirma.add( uno17.evc);
							 listEnvioConfirma.add( uno18.evc);
							 listEnvioConfirma.add( uno19.evc);
							 listEnvioConfirma.add( uno20.evc);
					 
							 listIds.clear(); 
							 lsxml.clear();
							 System.out.println("#" + conteo + " de " + total);
					   }
					}
					else
					{ 
						EnvAConfirmacion evc1 = new EnvAConfirmacion(st.toString());
						String xml = null;
						
						for(  Entry<String, String> llm  : mapXml.entrySet() ) 
						  { 
							  if(llm.getKey().equals(st))
								  xml = llm.getValue(); 
						  }
								 
						uno1 = new EnvioWS_Hilos( log2,p,evc1, xml ); 
					 
						uno1.start();
			
						 if(uno1.isAlive()) while(uno1.isAlive())  { }  
						
						 listEnvioConfirma.add( uno1.evc); 
						 
						 System.out.println("#" + i + " de " + total); 
					} 
				  
					 
				}
			  
			  
			  
			  System.out.println("   ---> lista confirmacion tamaño: " + listEnvioConfirma.size());
			  log2.log(Level.INFO, "Inicia confirmacion de registros a base datos....");
				 
				System.out.println("Inicia confirmacion de registros a base datos....");
			
		 
			
			lId = null; 
			 
			
			 sessionFactory = conh.sesSEPTUP();
			 Session session = sessionFactory.openSession();
			  
			 String error = "0";
			 String info = ""; 
			 String cons = "";
			 Integer totalEncabezado = ids;
			 Integer totalEjecutados = 1;
			 
					//Inicio  del timer DB 
						try { utilDAO.tiemposERP(param,9, "I");  } catch (Exception e) { }
			 
//			 for ( EnvAConfirmacion ev : lsConfirmacion) 
			 for ( EnvAConfirmacion ev : listEnvioConfirma )
			 {

 				 cons = " CALL sp_conf_Hibernate_consumirWS-SAP_P3_sap_ctrl('" + ev.getEstatus()  + "',"  +  
 				        ev.getIdTransaccion() + "," + param.getIdOperacion() + "," +
 						param.getIdOrigen() + ",'" +  param.getIdSociedad() + "'," + 
 						param.getIdInterfaz() + ",'" + ev.getFechaConf() + "','" +
 						ev.getHoraConf() + "','" + ev.getPolizaContable() + "', '" + 
 						ev.getCodigoError() + "', '" + ev.getMensaje() + "')";
 				log2.log(Level.INFO, ">>> " + cons +" <<<" );
 				

 				 try
 				 {
		 				Query query = session.createSQLQuery(cons); 

		 				@SuppressWarnings("unchecked")
						List<Object[]> rows =  query.list();	 
						 
						for(Object[] row : rows)
						{   
							if(row[0] != null) 
								error = ((Integer)row[0]).toString(); 
							
							if(row[2] != null) 
								info =  row[2].toString(); 
						}
 				 }
 				 catch (Exception e) 
 				 {
					error = "-1";
					info = "No se logro hacer la consulta: " + cons + " - " + e.getMessage();
					
				 }
 				 
 				 if(!error.equals("0"))
		 				log2.log(Level.INFO, "Termina SP 3 Hibernate_consumirWS-SAP_P3 para " + ev.getIdTransaccion() +  " - " + ev );
 
		 				System.out.println( totalEjecutados++ + " de " + totalEncabezado + " por ejecutar " + ids ); // + " error& info:  " + error + " - "+ info );
		 				
		 				ids--; 
 				 
			 } 
			 
			 
			 		//	FIN  del timer DB 
			 			try { utilDAO.tiemposERP(param,9, "F");  } catch (Exception e) { }
			 
			 listEnvioConfirma.clear();
			 listEnvioConfirma = null;
			 
			 	
		 conh.close(sessionFactory);
		 
	 }
	  
	   
}
