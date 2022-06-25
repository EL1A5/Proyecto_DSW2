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
		int res=0;
		Aplicacion obj = aplicacionRepository.save(aplicacion);

		if (!obj.equals(null)) {
			res=1;
		}

		return res;
	}


	@Override
	public Aplicacion insertaActualizaAplicacion(Aplicacion aplicacion) {

		return aplicacionRepository.save(aplicacion);
	}


	@Override
	public List<Aplicacion> findByDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		return aplicacionRepository.findByDescripcion(descripcion);
	}


	@Override
	public Aplicacion findByIdAplicacion(int idCategoria) {
		// TODO Auto-generated method stub
		return aplicacionRepository.findByIdAplicacion(idCategoria);
	}
	
	

}
