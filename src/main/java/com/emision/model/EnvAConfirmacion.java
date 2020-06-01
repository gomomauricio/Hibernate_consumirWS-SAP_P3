package com.Hibernate_consumirWS-SAP_P3.model;

public class EnvAConfirmacion 
{
	private String idTransaccion; 
	private String polizaContable; 
	private String codigoError;
	private String mensaje; 
	
	private String estatus;
	private String fechaConf;
	private String horaConf;
	
	private String DatosEnvioWS;
	
//	private String idOperacion;
//	private String idOrigen;
//	private String idSociedad;
//	private String idInterfaz;
	
  
	public EnvAConfirmacion() {}
 
 

	public EnvAConfirmacion(String idTransaccion) 
	{
		super();
		this.idTransaccion = idTransaccion;
	}


 


	public String getIdTransaccion() {
		return idTransaccion;
	}



	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}



	public String getPolizaContable() {
		return polizaContable;
	}



	public void setPolizaContable(String polizaContable) {
		this.polizaContable = polizaContable;
	}



	public String getCodigoError() {
		return codigoError;
	}



	public void setCodigoError(String codigoError) {
		this.codigoError = codigoError;
	}



	public String getMensaje() {
		return mensaje;
	}



	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}



	public String getEstatus() {
		return estatus;
	}



	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}



	public String getFechaConf() {
		return fechaConf;
	}



	public void setFechaConf(String fechaConf) {
		this.fechaConf = fechaConf;
	}



	public String getHoraConf() {
		return horaConf;
	}



	public void setHoraConf(String horaConf) {
		this.horaConf = horaConf;
	}



	public String getDatosEnvioWS() {
		return DatosEnvioWS;
	}



	public void setDatosEnvioWS(String datosEnvioWS) {
		DatosEnvioWS = datosEnvioWS;
	}



	@Override
	public String toString() {
		return "EnvAConfirmacion [idTransaccion=" + idTransaccion + ", polizaContable=" + polizaContable
				+ ", codigoError=" + codigoError + ", mensaje=" + mensaje + ", estatus=" + estatus + ", fechaConf="
				+ fechaConf + ", horaConf=" + horaConf + ", DatosEnvioWS=" + DatosEnvioWS + "]";
	}






	 
  
	
	

}
