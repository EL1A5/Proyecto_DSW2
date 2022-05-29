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

import com.epy.main.dto.CategoriaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="categoria")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_categoria")
	private int idCategoria;
	
	@Column(name="descripcion")
	private String descripcion;
	
	 
	@JsonIgnore
	@OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Solicitud> listasolicitud;

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
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
	public Categoria() {
		
	}
	
	
	
	
	public Categoria (CategoriaDTO obj) {
		this.idCategoria = obj.getIdCategoria();
		this.descripcion = obj.getDescripcion();
	}
	
	
	
}
