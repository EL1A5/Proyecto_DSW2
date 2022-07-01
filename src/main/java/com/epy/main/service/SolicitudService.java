package com.epy.main.service;

import java.util.List;

import com.epy.main.dto.SolicitudUserDTO;
import com.epy.main.entity.Solicitud;

public interface SolicitudService {
	
	
	public List<SolicitudUserDTO> fetchSolicitudDTODataInnerJoin(String estado, String fechaInicio, String fechaFin) ;
	
	public int updateSolicitud(int codigo, String fecha, String solucion);
	
	public List<SolicitudUserDTO> listarSolicitudesxUsuario(int persona, String estado, String fechaInicio, String fechaFin,
			int aplicativo);
	
	public SolicitudUserDTO fetchSolicitudDetallexIDDTODataInnerJoin(int codigoSolicitud);
	
	public List<Solicitud> listarSolicitud();
	
	public List<Solicitud> listar();
	
	public int guardar(Solicitud solicitud);
	
	public abstract Solicitud insertaActualizaSolicitud(Solicitud solicitud);
	
	
}
   