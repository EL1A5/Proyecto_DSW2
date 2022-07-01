package com.epy.main.dto;

import java.util.List;

import com.epy.main.entity.TipoSolicitud;
import com.fasterxml.jackson.annotation.JsonManagedReference;


public class TipoSolicitudDTO {
	

	private int idTipoSolicitud;

	private String descripcion;
	 

	

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

	public TipoSolicitudDTO(int idTipoSolicitud, String descripcion) {
		super();
		this.idTipoSolicitud = idTipoSolicitud;
		this.descripcion = descripcion;
	}
	public TipoSolicitudDTO(TipoSolicitud obj) {
		super();
		this.idTipoSolicitud = obj.getIdTipoSolicitud();
		this.descripcion = obj.getDescripcion();
	}
	

	
	

	
	
	
	
	
}
