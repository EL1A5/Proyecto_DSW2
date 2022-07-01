package com.epy.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.epy.main.dto.TipoSolicitudDTO;
import com.epy.main.entity.TipoSolicitud;
import com.epy.main.repository.TipoSolicitudRepository;
import com.epy.main.util.ConvertidorTipoSolicitud;


@Service
public class TipoSolicitudService implements ITipoSolicitud {

	@Autowired
	TipoSolicitudRepository tipoSolicitudRepository;
	@Autowired
	@Qualifier("convertidor")
	private ConvertidorTipoSolicitud convertidor;
	
	@Override
	public List<TipoSolicitudDTO> listar() {
		List<TipoSolicitud> list= tipoSolicitudRepository.findAll();
		return convertidor.convertirLista(list);
	}
	
	

}
  