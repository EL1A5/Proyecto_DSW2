package com.epy.main.dto;

import java.io.Serializable;

public class RptaServerDTO implements Serializable{
	
	private int codigo;
	private String mensaje;
	public RptaServerDTO(int codigo, String mensaje) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
	}
	
	public RptaServerDTO() {
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
	
	
	

}
