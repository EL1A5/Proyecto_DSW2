package com.epy.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epy.main.dto.SolicitudUserDTO;
import com.epy.main.entity.Solicitud;
import com.epy.main.repository.SolicitudRepository;

@Service
public class SolicitudServiceImpl implements SolicitudService {
	
	@Autowired
	SolicitudRepository solicitudRepository;
	
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

	@Override
	public List<Solicitud> listarSolicitud() {
		return solicitudRepository.findAll();
	}

	@Override
	public List<Solicitud> listar() {
		return solicitudRepository.findAll();
	}

	@Override
	public int guardar(Solicitud solicitud) {
		int inserto =0;
		Solicitud sol= solicitudRepository.save(solicitud);
		if (sol != null) {
			inserto =1;
		}
		return inserto; 
	}

	@Override
	public Solicitud insertaActualizaSolicitud(Solicitud solicitud) {
		return solicitudRepository.save(solicitud);
	}
	

}
