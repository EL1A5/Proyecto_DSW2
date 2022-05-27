package com.epy.main.service;

import java.util.List;

import com.epy.main.entity.Aplicacion;

public interface IAplicacion {
	
	
	public List<Aplicacion> listar();
	public int guardar(Aplicacion aplicacion);
	
	

}
   