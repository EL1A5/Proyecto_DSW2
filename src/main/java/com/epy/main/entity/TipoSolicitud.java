package com.epy.main.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity(name="entity_tipo_solicitud")
@Table(name="tipo_solicitud")
public class TipoSolicitud {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tipo_solicitud")
	private int idTipoSolicitud;
	
	@Column(name="descripcion")
	private String descripcion;
	 

	@OneToMany(mappedBy = "tipoSolicitud", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Solicitud> listaSolicitud;

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

	public List<Solicitud> getListaSolicitud() {
		return listaSolicitud;
	}

	public void setListaSolicitud(List<Solicitud> listaSolicitud) {
		this.listaSolicitud = listaSolicitud;
	}

	
	

	
	
	
	
	
}
