package com.epy.main.service;
import java.util.List;

import com.epy.main.dto.TipoSolicitudDTO;
import com.epy.main.entity.TipoSolicitud;

public interface TipoSolicitudService {
	
	public List<TipoSolicitud> listar();
	
	public List<TipoSolicitudDTO> lista();

	

}
  