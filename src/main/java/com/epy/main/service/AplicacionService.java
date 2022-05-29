package com.epy.main.service;

import java.util.List;

import com.epy.main.entity.Aplicacion;

public interface AplicacionService {
	
	
	public List<Aplicacion> listarAplicacion();
	
	public List<Aplicacion> listar();
	
	public int guardar(Aplicacion aplicacion);
	
	public abstract Aplicacion insertaActualizaAplicacion(Aplicacion aplicacion);

}
   