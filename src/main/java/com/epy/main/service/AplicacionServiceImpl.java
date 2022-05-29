package com.epy.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epy.main.entity.Aplicacion;
import com.epy.main.repository.AplicacionRepository;

@Service
public class AplicacionServiceImpl implements AplicacionService {
	
	@Autowired
	AplicacionRepository aplicacionRepository;

	@Override
	public List<Aplicacion> listarAplicacion() {
		return aplicacionRepository.findAll();
	}  


	@Override
	public List<Aplicacion> listar() {
		return aplicacionRepository.findAll();
	}


	@Override
	public int guardar(Aplicacion aplicacion) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Aplicacion insertaActualizaAplicacion(Aplicacion aplicacion) {

		return aplicacionRepository.save(aplicacion);
	}
	
	

}
