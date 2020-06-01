package com.Hibernate_consumirWS-SAP_P3.model;

/****************************************************************************************************
*FECHA DE CREACIÓN: 31 de Marzo de 2020.
*DESCRIPCIÓN: Objeto para almacenar el encabezado de envio a webservices SAP
*
*ULTIMA MODIFICACION FECHA: 
*ULTIMA MODIFICACION DESCRIPCION: 
*
*@author Mauricio González Mondragón  v2.0.1
******************************************************************************************************/

public class EncabezadoEnv
{ 
	private String id_sociedad = "";
	private String id_operacion = "";
	private String fecha_Hibernate_consumirWS-SAP_P3 = "";   // en foemato yyymmdd
	private String fecha_Hibernate_consumirWS-SAP_P3_C = "";   // en formato yyymmdd
	private String ejercicio_anio_f_e = "";   // año segmento yyyy
	private String id_transaccion = "";
	private String clave_moneda = "";
	private String refer_encab_1_hd = "";   // si la póliza en nueva o renovada
	
	private String nombre_razon_social = "";
	private String apellido_paterno = "";  
	private String apellido_materno = "";  
	private String name4 = "";  
	private String cuenta_bancaria = "";  
	private String clave_banco = "";  
	private String pais_banco = "";  
	private String rfc_persona_fisica = "";  
	private String rfc_persona_moral = "";  
	private String persona_fisica = "";  
	private String correo_electronico = ""; //  -- ==== TERMIBA DETALLE === 53
	private String idCPD = ""; //idtransaccion para persona   
	
	
	public String getId_sociedad() {
		return id_sociedad;
	}
	public void setId_sociedad(String id_sociedad) {
		this.id_sociedad = id_sociedad;
	}
	public String getId_operacion() {
		return id_operacion;
	}
	public void setId_operacion(String id_operacion) {
		this.id_operacion = id_operacion;
	}
	public String getFecha_Hibernate_consumirWS-SAP_P3() {
		return fecha_Hibernate_consumirWS-SAP_P3;
	}
	public void setFecha_Hibernate_consumirWS-SAP_P3(String fecha_Hibernate_consumirWS-SAP_P3) {
		this.fecha_Hibernate_consumirWS-SAP_P3 = fecha_Hibernate_consumirWS-SAP_P3;
	}
	public String getFecha_Hibernate_consumirWS-SAP_P3_C() {
		return fecha_Hibernate_consumirWS-SAP_P3_C;
	}
	public void setFecha_Hibernate_consumirWS-SAP_P3_C(String fecha_Hibernate_consumirWS-SAP_P3_C) {
		this.fecha_Hibernate_consumirWS-SAP_P3_C = fecha_Hibernate_consumirWS-SAP_P3_C;
	}
	public String getEjercicio_anio_f_e() {
		return ejercicio_anio_f_e;
	}
	public void setEjercicio_anio_f_e(String ejercicio_anio_f_e) {
		this.ejercicio_anio_f_e = ejercicio_anio_f_e;
	}
	public String getId_transaccion() {
		return id_transaccion;
	}
	public void setId_transaccion(String id_transaccion) {
		this.id_transaccion = id_transaccion;
	}
	public String getClave_moneda() {
		return clave_moneda;
	}
	public void setClave_moneda(String clave_moneda) {
		this.clave_moneda = clave_moneda;
	}
	public String getRefer_encab_1_hd() {
		return refer_encab_1_hd;
	}
	public void setRefer_encab_1_hd(String refer_encab_1_hd) {
		this.refer_encab_1_hd = refer_encab_1_hd;
	}
	public String getNombre_razon_social() {
		return nombre_razon_social;
	}
	public void setNombre_razon_social(String nombre_razon_social) {
		this.nombre_razon_social = nombre_razon_social;
	}
	public String getApellido_paterno() {
		return apellido_paterno;
	}
	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}
	public String getApellido_materno() {
		return apellido_materno;
	}
	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}
	public String getName4() {
		return name4;
	}
	public void setName4(String name4) {
		this.name4 = name4;
	}
	public String getCuenta_bancaria() {
		return cuenta_bancaria;
	}
	public void setCuenta_bancaria(String cuenta_bancaria) {
		this.cuenta_bancaria = cuenta_bancaria;
	}
	public String getClave_banco() {
		return clave_banco;
	}
	public void setClave_banco(String clave_banco) {
		this.clave_banco = clave_banco;
	}
	public String getPais_banco() {
		return pais_banco;
	}
	public void setPais_banco(String pais_banco) {
		this.pais_banco = pais_banco;
	}
	public String getRfc_persona_fisica() {
		return rfc_persona_fisica;
	}
	public void setRfc_persona_fisica(String rfc_persona_fisica) {
		this.rfc_persona_fisica = rfc_persona_fisica;
	}
	public String getRfc_persona_moral() {
		return rfc_persona_moral;
	}
	public void setRfc_persona_moral(String rfc_persona_moral) {
		this.rfc_persona_moral = rfc_persona_moral;
	}
	public String getPersona_fisica() {
		return persona_fisica;
	}
	public void setPersona_fisica(String persona_fisica) {
		this.persona_fisica = persona_fisica;
	}
	public String getCorreo_electronico() {
		return correo_electronico;
	}
	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}
	public String getIdCPD() {
		return idCPD;
	}
	public void setIdCPD(String idCPD) {
		this.idCPD = idCPD;
	}
 
	 
	
	
	
	
}
