package com.epy.main.service;

import java.util.List;

import com.epy.main.dto.SolicitudUserDTO;
import com.epy.main.entity.Aplicacion;
import com.epy.main.entity.Solicitud;

public interface SolicitudService {
	
	
	public List<Solicitud> listarSolicitud();
	
	public List<Solicitud> listar();
	
	public int guardar(Solicitud solicitud);
	
	public abstract Solicitud insertaActualizaSolicitud(Solicitud solicitud);


}
   