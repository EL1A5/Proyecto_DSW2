package com.epy.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.epy.main.dto.PersonaDTO;
import com.epy.main.entity.Persona;
import com.epy.main.entity.User;
import com.epy.main.repository.PersonaRepository;


@Service
public class PersonaService implements IPersona {

	@Autowired
	PersonaRepository personaRepository;
	
	@Override
	public List<Persona> listar(){
		return (List<Persona>)personaRepository.findAll();
	}

	@Override
	public int guardar(Persona persona) {
		int res=0;
		Persona per=personaRepository.save(persona);
		if (!per.equals(null)) {
			res=1;  
		}
		return res;
	}

	
	
	@Override
	public List<PersonaDTO> findByNombre(String nom) {
		List<PersonaDTO> lista = personaRepository.fetchPersonaDTODataInnerJoin("");
		return lista;
	}

	@Override
	public List<PersonaDTO> findConsultaUsuario(int tipoUsuario, String dni) {
		List<PersonaDTO> lista = personaRepository.fetchConsultaUsuarioDataInnerJoin(tipoUsuario, dni);
		return lista;
	}

	@Override
	public List<PersonaDTO> findConsultaUsuarioxApellido(String apellidos) {
		List<PersonaDTO> lista = personaRepository.fetchConsultaUsuariofindApellidoInnerJoin(apellidos);
		return lista;
	}

	@Override
	public List<Persona> buscarDni(String dni) {
		// TODO Auto-generated method stub
		return personaRepository.findByDni(dni);
	}

	
	
	
	
}
