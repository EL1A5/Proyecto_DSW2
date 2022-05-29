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
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="aplicacion")
public class Aplicacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_aplicacion")
	private int idAplicacion;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@JsonIgnore
	@OneToMany(mappedBy = "aplicacion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Solicitud> listasolicitud;
	
	
	public Aplicacion() {
		
	}  

	public int getIdAplicacion() {
		return idAplicacion;
	}

	public void setIdAplicacion(int idAplicacion) {
		this.idAplicacion = idAplicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Solicitud> getListasolicitud() {
		return listasolicitud;
	}

	public void setListasolicitud(List<Solicitud> listasolicitud) {
		this.listasolicitud = listasolicitud;
	}
	

	
	
	
	
	

}
