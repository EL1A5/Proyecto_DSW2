package com.epy.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.epy.main.entity.TipoSolicitud;

import com.epy.main.dto.*;
import java.util.List;;
@Repository
public interface TipoSolicitudRepository extends JpaRepository<TipoSolicitud, Integer> {
	
	
	@Query(
			value = "select new com.epy.main.dto.TipoSolicitudDTO(sol.idTipoSolicitud, sol.descripcion) "
					+ " from entity_tipo_solicitud sol"
			)
	
	public List<TipoSolicitudDTO> lista();
  
}
