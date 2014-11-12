package com.example.domain;

public class GenericResponse {
	private boolean exito;
	private String mensaje;
	private int codigo;
	private Object objeto;
	
	public GenericResponse(boolean exito, String mensaje, int codigo, Object objeto) {
		super();
		this.exito = exito;
		this.mensaje = mensaje;
		this.codigo = codigo;
		this.objeto = objeto;
	}
	public GenericResponse() {
		super();
	}
	public boolean isExito() {
		return exito;
	}
	public void setExito(boolean exito) {
		this.exito = exito;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Object getObjeto() {
		return objeto;
	}
	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}
}
