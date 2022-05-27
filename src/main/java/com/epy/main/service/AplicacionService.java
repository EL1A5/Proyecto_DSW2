package com.epy.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epy.main.entity.Aplicacion;
import com.epy.main.repository.AplicacionRepository;

@Service
public class AplicacionService implements IAplicacion {
	
	@Autowired
	AplicacionRepository aplicacionRepository;

	@Override
	public List<Aplicacion> listar() {
		return aplicacionRepository.findAll();
	}  

	@Override
	public int guardar(Aplicacion aplicacion) {
		
		int res=0;
		Aplicacion obj = aplicacionRepository.save(aplicacion);
		
		if (!obj.equals(null)) {
			res=1;
		}
		
		return res;
	}
	
	
	
	
	

}
