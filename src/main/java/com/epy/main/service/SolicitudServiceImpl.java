package com.epy.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epy.main.dto.SolicitudUserDTO;
import com.epy.main.entity.Aplicacion;
import com.epy.main.entity.Solicitud;
import com.epy.main.repository.SolicitudRepository;

@Service
public class SolicitudServiceImpl implements SolicitudService {

	@Autowired
	SolicitudRepository solicitudRepository;

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Solicitud insertaActualizaSolicitud(Solicitud solicitud) {
		return solicitudRepository.save(solicitud);
		}
		
	
	

}
