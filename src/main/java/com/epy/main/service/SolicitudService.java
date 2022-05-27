package com.epy.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epy.main.dto.SolicitudUserDTO;
import com.epy.main.entity.Solicitud;
import com.epy.main.repository.SolicitudRepository;

@Service
public class SolicitudService implements ISolicitud {

	@Autowired
	SolicitudRepository solicitudRepository;
	
	
	@Override
	public void guardar(Solicitud solicitud) {
		solicitudRepository.save(solicitud);
	}

	@Override
	public List<SolicitudUserDTO> listarSolicitudesxUsuario(int persona, String estado, String fechaInicio, String fechaFin,
			int aplicativo) {
		return solicitudRepository.fetchSolicitudUserDTODataInnerJoin(persona, estado, fechaInicio, fechaFin, aplicativo);
	}  

	@Override
	public SolicitudUserDTO fetchSolicitudDetallexIDDTODataInnerJoin(int codigoSolicitud) {
		return solicitudRepository.fetchSolicitudDetallexIDDTODataInnerJoin(codigoSolicitud);
	}

	@Override
	public List<SolicitudUserDTO> fetchSolicitudDTODataInnerJoin(String estado, String fechaInicio, String fechaFin) {
		return solicitudRepository.fetchSolicitudDTODataInnerJoin(estado, fechaInicio, fechaFin);
	}

	@Override
	public int updateSolicitud(int codigo, String fecha, String solucion) {

		int guardar = solicitudRepository.updateSolicitud(codigo, fecha, solucion);
		
		return guardar;
	}
	
	
	
	

}
