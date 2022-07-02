package com.epy.main.dto;

public class TipoSolicitudDTO {
	
	
	private int idTipoSolicitud;
	private String descripcion;
	
	public TipoSolicitudDTO() {
		
	}

	public TipoSolicitudDTO(int idTipoSolicitud, String descripcion) {
		super();
		this.idTipoSolicitud = idTipoSolicitud;
		this.descripcion = descripcion;
	}
	public int getIdTipoSolicitud() {
		return idTipoSolicitud;
	}
	public void setIdTipoSolicitud(int idTipoSolicitud) {
		this.idTipoSolicitud = idTipoSolicitud;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	

}
