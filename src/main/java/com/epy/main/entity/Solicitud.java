package com.epy.main.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name="entity_solicitud")
@Table(name="solicitud")

public class Solicitud {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_solicitud")
	private int idSolicitud;
	  
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name="id_tipo_solicitud")
	private TipoSolicitud tipoSolicitud;
	
	@Column(name="descripcion_solicitud")
	private String descripcionSolicitud;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY,  cascade = CascadeType.MERGE)
	@JoinColumn(name="id_aplicacion")
	private Aplicacion aplicacion;
	
	@ManyToOne(fetch = FetchType.LAZY,  cascade = CascadeType.MERGE)
	@JoinColumn(name="id_categoria")
	private Categoria categoria;
	
	@Column(name="prioridad")
	private String prioridad;
	
	@Column(name="fecha_registro")
	private String fechaRegistro;
	
	@Column(name="fecha_cierre")
	private String fechaCierre;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="descripcion_atencion")
	private String descripcionAtencion;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name="id_persona")
	private Persona persona;

	public int getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public TipoSolicitud getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

	public String getDescripcionSolicitud() {
		return descripcionSolicitud;
	}

	public void setDescripcionSolicitud(String descripcionSolicitud) {
		this.descripcionSolicitud = descripcionSolicitud;
	}

	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(String fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescripcionAtencion() {
		return descripcionAtencion;
	}

	public void setDescripcionAtencion(String descripcionAtencion) {
		this.descripcionAtencion = descripcionAtencion;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
	
	
	
	
	
}
