package com.Hibernate_consumirWS-SAP_P3.model;

public class EnvioResultSP2 
{

	
	 
	private Integer column1;                                   
	private String column2;                                   
	private String column3;                                   
	private String fecha_ope_o_sisT;       // dd/mm/aaaa    
	private String tiempo_sistema;         // hh:mm:ss  // Integer       AS id_transaccion;       AS id_operacion; 
	private String id_sociedad;
	private String id_operacion;
	private String fecha_Hibernate_consumirWS-SAP_P3;    //fec_apl       //en foemato yyymmdd
	private String fecha_Hibernate_consumirWS-SAP_P3_C;   //fec_apl_C  // en formato yyymmdd 
	private String ejercicio_anio_f_e;   // año segmento yyyy
	private String id_transaccion;
	private String clave_moneda;
	private String refer_encab_1_hd;   // si la póliza en nueva o renovada
	private String numero_asignacion;   // ctrlrbof3.uso_cfdi  == TERMINA ENCABEZADO == 17 
	private String concepto;
	private Double lf_importe;   // DECIMAL ,lf_pritot_gp
	private String cuenta_l_m; 
	private String posicion_presup;
	private String centro_gestor;   // iruta.num_suc; genprima.ofna_gp o crecibo.num_suc
	private String fondos;
	private String area_funcional;   // ram_rea           ;
	private String centro_coste;   // iruta.num_suc; genprima.ofna_gp o crecibo.num_suc
	private String indicador_iva;
	private String segmento;   // ram_rea          ;
	private String clase_contrato;
	private String lf_moneda;   // 1= MXN 2=USD
	private String lf_ramo;   // 
	private String centro;   // constante  R101 = México 
	private String acreedor_bp;
	private String fecha_base;
	private String clave_condi_pago;
	private String s_uuid;   // ctrlrbof3.numcertif
	private String z_segmento;
	private String z_tipo_reserva;
	private String z_referencia_cobro;
	private String z_numero_poliza;
	private String z_numero_siniestro;
	private String z_region;	 
	private String z_oficina;  
	private String z_sistema;
	private String z_sucursal;
	private String z_pais_reasegurador; 
	private String z_ciclo_cultivo;
	private String z_canal_distrib;
	private String z_producto;
	private String z_segmento_mercado;
	private String z_clave_agente;
	private String z_numero_salvamento;
	private String tipo_endoso; 
	private Integer gru_rea;  //SMALLINT      
	private Integer ramo_poliza;
	private Integer ramo_puro;   //SMALLINT  
//	private Integer num_endoso;  //SMALLINT  
	private String fisico_moral;
	private String tipo_proveedor;
	private String rfc_proveedor;       // ==== TERMIBA DETALLE === 38  
	
	private String nombre_razon_social;
	private String apellido_paterno;  
	private String apellido_materno;  
	private String name4;  
	private String cuenta_bancaria;  
	private String clave_banco;  
	private String pais_banco;  
	private String rfc_persona_fisica;  
	private String rfc_persona_moral;  
	private String persona_fisica;  
	private String correo_electronico; //  -- ==== TERMIBA DETALLE === 53
	
	
	public Integer getColumn1() {
		return column1;
	}
	public void setColumn1(Integer column1) {
		this.column1 = column1;
	}
	public String getColumn2() {
		return column2;
	}
	public void setColumn2(String column2) {
		this.column2 = column2;
	}
	public String getColumn3() {
		return column3;
	}
	public void setColumn3(String column3) {
		this.column3 = column3;
	}
	public String getFecha_ope_o_sisT() {
		return fecha_ope_o_sisT;
	}
	public void setFecha_ope_o_sisT(String fecha_ope_o_sisT) {
		this.fecha_ope_o_sisT = fecha_ope_o_sisT;
	}
	public String getTiempo_sistema() {
		return tiempo_sistema;
	}
	public void setTiempo_sistema(String tiempo_sistema) {
		this.tiempo_sistema = tiempo_sistema;
	}
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
	public String getNumero_asignacion() {
		return numero_asignacion;
	}
	public void setNumero_asignacion(String numero_asignacion) {
		this.numero_asignacion = numero_asignacion;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public Double getLf_importe() {
		return lf_importe;
	}
	public void setLf_importe(Double lf_importe) {
		this.lf_importe = lf_importe;
	}
	public String getCuenta_l_m() {
		return cuenta_l_m;
	}
	public void setCuenta_l_m(String cuenta_l_m) {
		this.cuenta_l_m = cuenta_l_m;
	}
	public String getPosicion_presup() {
		return posicion_presup;
	}
	public void setPosicion_presup(String posicion_presup) {
		this.posicion_presup = posicion_presup;
	}
	public String getCentro_gestor() {
		return centro_gestor;
	}
	public void setCentro_gestor(String centro_gestor) {
		this.centro_gestor = centro_gestor;
	}
	public String getFondos() {
		return fondos;
	}
	public void setFondos(String fondos) {
		this.fondos = fondos;
	}
	public String getArea_funcional() {
		return area_funcional;
	}
	public void setArea_funcional(String area_funcional) {
		this.area_funcional = area_funcional;
	}
	public String getCentro_coste() {
		return centro_coste;
	}
	public void setCentro_coste(String centro_coste) {
		this.centro_coste = centro_coste;
	}
	public String getIndicador_iva() {
		return indicador_iva;
	}
	public void setIndicador_iva(String indicador_iva) {
		this.indicador_iva = indicador_iva;
	}
	public String getSegmento() {
		return segmento;
	}
	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}
	public String getClase_contrato() {
		return clase_contrato;
	}
	public void setClase_contrato(String clase_contrato) {
		this.clase_contrato = clase_contrato;
	}
	public String getLf_moneda() {
		return lf_moneda;
	}
	public void setLf_moneda(String lf_moneda) {
		this.lf_moneda = lf_moneda;
	}
	public String getLf_ramo() {
		return lf_ramo;
	}
	public void setLf_ramo(String lf_ramo) {
		this.lf_ramo = lf_ramo;
	}
	public String getCentro() {
		return centro;
	}
	public void setCentro(String centro) {
		this.centro = centro;
	}
	public String getAcreedor_bp() {
		return acreedor_bp;
	}
	public void setAcreedor_bp(String acreedor_bp) {
		this.acreedor_bp = acreedor_bp;
	}
	public String getFecha_base() {
		return fecha_base;
	}
	public void setFecha_base(String fecha_base) {
		this.fecha_base = fecha_base;
	}
	public String getClave_condi_pago() {
		return clave_condi_pago;
	}
	public void setClave_condi_pago(String clave_condi_pago) {
		this.clave_condi_pago = clave_condi_pago;
	}
	public String getS_uuid() {
		return s_uuid;
	}
	public void setS_uuid(String s_uuid) {
		this.s_uuid = s_uuid;
	}
	public String getZ_segmento() {
		return z_segmento;
	}
	public void setZ_segmento(String z_segmento) {
		this.z_segmento = z_segmento;
	}
	public String getZ_tipo_reserva() {
		return z_tipo_reserva;
	}
	public void setZ_tipo_reserva(String z_tipo_reserva) {
		this.z_tipo_reserva = z_tipo_reserva;
	}
	public String getZ_referencia_cobro() {
		return z_referencia_cobro;
	}
	public void setZ_referencia_cobro(String z_referencia_cobro) {
		this.z_referencia_cobro = z_referencia_cobro;
	}
	public String getZ_numero_poliza() {
		return z_numero_poliza;
	}
	public void setZ_numero_poliza(String z_numero_poliza) {
		this.z_numero_poliza = z_numero_poliza;
	}
	public String getZ_numero_siniestro() {
		return z_numero_siniestro;
	}
	public void setZ_numero_siniestro(String z_numero_siniestro) {
		this.z_numero_siniestro = z_numero_siniestro;
	}
	public String getZ_region() {
		return z_region;
	}
	public void setZ_region(String z_region) {
		this.z_region = z_region;
	}
	public String getZ_oficina() {
		return z_oficina;
	}
	public void setZ_oficina(String z_oficina) {
		this.z_oficina = z_oficina;
	}
	public String getZ_sistema() {
		return z_sistema;
	}
	public void setZ_sistema(String z_sistema) {
		this.z_sistema = z_sistema;
	}
	public String getZ_sucursal() {
		return z_sucursal;
	}
	public void setZ_sucursal(String z_sucursal) {
		this.z_sucursal = z_sucursal;
	}
	public String getZ_pais_reasegurador() {
		return z_pais_reasegurador;
	}
	public void setZ_pais_reasegurador(String z_pais_reasegurador) {
		this.z_pais_reasegurador = z_pais_reasegurador;
	}
	public String getZ_ciclo_cultivo() {
		return z_ciclo_cultivo;
	}
	public void setZ_ciclo_cultivo(String z_ciclo_cultivo) {
		this.z_ciclo_cultivo = z_ciclo_cultivo;
	}
	public String getZ_canal_distrib() {
		return z_canal_distrib;
	}
	public void setZ_canal_distrib(String z_canal_distrib) {
		this.z_canal_distrib = z_canal_distrib;
	}
	public String getZ_producto() {
		return z_producto;
	}
	public void setZ_producto(String z_producto) {
		this.z_producto = z_producto;
	}
	public String getZ_segmento_mercado() {
		return z_segmento_mercado;
	}
	public void setZ_segmento_mercado(String z_segmento_mercado) {
		this.z_segmento_mercado = z_segmento_mercado;
	}
	public String getZ_clave_agente() {
		return z_clave_agente;
	}
	public void setZ_clave_agente(String z_clave_agente) {
		this.z_clave_agente = z_clave_agente;
	}
	public String getZ_numero_salvamento() {
		return z_numero_salvamento;
	}
	public void setZ_numero_salvamento(String z_numero_salvamento) {
		this.z_numero_salvamento = z_numero_salvamento;
	}
	public String getTipo_endoso() {
		return tipo_endoso;
	}
	public void setTipo_endoso(String tipo_endoso) {
		this.tipo_endoso = tipo_endoso;
	}
	public Integer getGru_rea() {
		return gru_rea;
	}
	public void setGru_rea(Integer gru_rea) {
		this.gru_rea = gru_rea;
	}
	public Integer getRamo_poliza() {
		return ramo_poliza;
	}
	public void setRamo_poliza(Integer ramo_poliza) {
		this.ramo_poliza = ramo_poliza;
	}
	public Integer getRamo_puro() {
		return ramo_puro;
	}
	public void setRamo_puro(Integer ramo_puro) {
		this.ramo_puro = ramo_puro;
	}
	 
	 
	public String getTipo_proveedor() {
		return tipo_proveedor;
	}
	public void setTipo_proveedor(String tipo_proveedor) {
		this.tipo_proveedor = tipo_proveedor;
	}
	public String getRfc_proveedor() {
		return rfc_proveedor;
	}
	public void setRfc_proveedor(String rfc_proveedor) {
		this.rfc_proveedor = rfc_proveedor;
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
	public String getFisico_moral() {
		return fisico_moral;
	}
	public void setFisico_moral(String fisico_moral) {
		this.fisico_moral = fisico_moral;
	}
	@Override
	public String toString() {
		return "EnvioResultSP2 [col1:" + column1 + ", col2:" + column2 + ", col3:" + column3
				+ ", fechaOpe:" + fecha_ope_o_sisT + ", tSis:" + tiempo_sistema + ", sociedad:"
				+ id_sociedad + ", operacion:" + id_operacion + ", fecha:" + fecha_Hibernate_consumirWS-SAP_P3
				+ ", fechaC:" + fecha_Hibernate_consumirWS-SAP_P3_C + ", ejercicio:" + ejercicio_anio_f_e
				+ ", id_transaccion:" + id_transaccion + ", clave_moneda:" + clave_moneda + ", refer_encab_1_hd:"
				+ refer_encab_1_hd + ", numero_asignacion:" + numero_asignacion + ", concepto:" + concepto
				+ ", lf_importe:" + lf_importe + ", cuenta_l_m:" + cuenta_l_m + ", posicion_presup:" + posicion_presup
				+ ", centro_gestor:" + centro_gestor + ", fondos:" + fondos + ", area_funcional:" + area_funcional
				+ ", centro_coste:" + centro_coste + ", indicador_iva:" + indicador_iva + ", segmento:" + segmento
				+ ", clase_contrato:" + clase_contrato + ", lf_moneda:" + lf_moneda + ", lf_ramo:" + lf_ramo
				+ ", centro:" + centro + ", acreedor_bp:" + acreedor_bp + ", fecha_base:" + fecha_base
				+ ", clave_condi_pago:" + clave_condi_pago + ", s_uuid:" + s_uuid + ", z_segmento:" + z_segmento
				+ ", z_tipo_reserva:" + z_tipo_reserva + ", z_referencia_cobro:" + z_referencia_cobro
				+ ", z_numero_poliza:" + z_numero_poliza + ", z_numero_siniestro:" + z_numero_siniestro + ", z_region:"
				+ z_region + ", z_oficina:" + z_oficina + ", z_sistema:" + z_sistema + ", z_sucursal:" + z_sucursal
				+ ", z_pais_reasegurador:" + z_pais_reasegurador + ", z_ciclo_cultivo:" + z_ciclo_cultivo
				+ ", z_canal_distrib:" + z_canal_distrib + ", z_producto:" + z_producto + ", z_segmento_mercado:"
				+ z_segmento_mercado + ", z_clave_agente:" + z_clave_agente + ", z_numero_salvamento:"
				+ z_numero_salvamento + ", tipo_endoso:" + tipo_endoso + ", gru_rea:" + gru_rea + ", ramo_poliza:"
				+ ramo_poliza + ", ramo_puro:" + ramo_puro + ", fisico_moral:" + fisico_moral + ", tipo_proveedor:"
				+ tipo_proveedor + ", rfc_proveedor:" + rfc_proveedor + ", nombre_razon_social:" + nombre_razon_social
				+ ", apellido_paterno:" + apellido_paterno + ", apellido_materno:" + apellido_materno + ", name4:"
				+ name4 + ", cuenta_bancaria:" + cuenta_bancaria + ", clave_banco:" + clave_banco + ", pais_banco:"
				+ pais_banco + ", rfc_persona_fisica:" + rfc_persona_fisica + ", rfc_persona_moral:" + rfc_persona_moral
				+ ", persona_fisica:" + persona_fisica + ", correo_electronico:" + correo_electronico + "]";
	}
	 
	 
	


	
	
	 


	


	

}
