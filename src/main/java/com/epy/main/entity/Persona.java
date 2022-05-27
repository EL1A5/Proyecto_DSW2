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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

@Entity(name="entidad_persona")
@Table(name="personas")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_persona")
	private int idpersona;
	 
	@NotNull
	@Column
	private String nombre;
	
	@NotNull
	@Column
	private String apellidos;
	
	@NotNull
	@Column
	private String dni;
	
	@NotNull
	@Column
	private String celular;
	
	@NotNull
	@Column
	private String telefono;
	
	
	@NotNull
	@Column(name="fecha_registro")
	private String fechaRegistro;
	
	
	@JsonIgnore
	//@OneToOne( mappedBy = "persona", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true )//opremal =True
	@OneToOne( mappedBy = "persona", fetch = FetchType.LAZY, cascade =  CascadeType.PERSIST)
	private User user;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Solicitud> listaSolicitud;
	

	public Persona() {
		super();
	}
	
	




	public int getIdpersona() {
		return idpersona;
	}




	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getApellidos() {
		return apellidos;
	}




	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}




	public String getDni() {
		return dni;
	}




	public void setDni(String dni) {
		this.dni = dni;
	}




	public String getCelular() {
		return celular;
	}




	public void setCelular(String celular) {
		this.celular = celular;
	}




	public String getTelefono() {
		return telefono;
	}




	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}




	public String getFechaRegistro() {
		return fechaRegistro;
	}




	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public List<Solicitud> getListaSolicitud() {
		return listaSolicitud;
	}




	public void setListaSolicitud(List<Solicitud> listaSolicitud) {
		this.listaSolicitud = listaSolicitud;
	}



	

}
