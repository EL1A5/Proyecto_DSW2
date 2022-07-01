package com.epy.main.service;

import java.util.List;

import com.epy.main.dto.PersonaDTO;
import com.epy.main.entity.Persona;

public interface PersonaService {

	
	public List<Persona> listar();
	public int guardar(Persona persona);
	public List<PersonaDTO> findByNombre(String nombre);
	public List<PersonaDTO> findConsultaUsuario(int tipoUsuario, String dni);
	public List<PersonaDTO> findConsultaUsuarioxApellido(String apellidos);
	public List<Persona> buscarDni(String dni);
	public List<PersonaDTO> busquedaPersonas(int tipoUsuario, String dni, String apellidos);
	public List<PersonaDTO> listadoPersona();
}
  