package com.epy.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epy.main.dto.TipoSolicitudDTO;
import com.epy.main.entity.TipoSolicitud;
import com.epy.main.repository.TipoSolicitudRepository;

@Service
public class TipoSolicitudServiceImpl implements TipoSolicitudService {

	@Autowired
	TipoSolicitudRepository tipoSolicitudRepository;
	
	@Override
	public List<TipoSolicitud> listar() {
		return tipoSolicitudRepository.findAll();
	}
	
	@Override
	public List<TipoSolicitudDTO> lista() {
		return tipoSolicitudRepository.lista();
	}
	
	

}
  