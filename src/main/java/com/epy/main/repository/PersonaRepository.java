package com.epy.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.epy.main.dto.PersonaDTO;
import com.epy.main.entity.Persona;

@Repository// Se agrego ultimo
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
	
	@Query(
			value = "select new com.epy.main.dto.PersonaDTO"
					+ "(per.idpersona, per.nombre, per.apellidos, per.dni, per.celular, per.telefono, usu.authority.authority) "
					+ "from entidad_persona per inner join per.user usu  "
			)
	public List<PersonaDTO> fetchPersonaDTODataInnerJoin(String nombre);
	
	@Query(
			value = "select new com.epy.main.dto.PersonaDTO"
					+ "(per.idpersona, per.nombre, per.apellidos, per.dni, per.celular, per.telefono, usu.authority.authority) "
					+ " from entidad_persona per inner join per.user usu where usu.authority.id=?1 or per.dni=?2"
			)
	public List<PersonaDTO> fetchConsultaUsuarioDataInnerJoin(int tipoUsuario, String dni);

	@Query(
			value = "select new com.epy.main.dto.PersonaDTO"
					+ "(per.idpersona, per.nombre, per.apellidos, per.dni, per.celular, per.telefono, usu.authority.authority) "
					+ " from entidad_persona per inner join per.user usu where per.apellidos like ?1"
			)
	public List<PersonaDTO> fetchConsultaUsuariofindApellidoInnerJoin(String apellido);
	
	public List<Persona>findByDni(String dni);
	
	@Query( value = "select new com.epy.main.dto.PersonaDTO(per.idpersona, per.nombre, per.apellidos, per.dni, per.celular, per.telefono, usu.authority.authority) "+
			"from entidad_persona per inner join per.user usu where "+
			"(?1 is 0 or usu.authority.id =?1) and" +
			"(?2 is '' or per.dni=?2) and" +
			"(?3 is '' or per.apellidos like ?3)"
			)
	public List<PersonaDTO> busquedaPersonas(int tipoUsuario, String dni, String apellidos);
	
	
	
	
	@Query(
			value = "select new com.epy.main.dto.PersonaDTO"
					+ "(per.idpersona, per.nombre, per.apellidos, per.dni, per.celular, per.telefono, usu.authority.authority) "
					+ "from entidad_persona per inner join per.user usu  "
			)
	public List<PersonaDTO> listadoPersona();
	
	
	
	
	
}
