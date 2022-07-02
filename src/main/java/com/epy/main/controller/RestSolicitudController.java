package com.epy.main.controller;

import com.epy.main.dto.SolicitudUserDTO;
import com.epy.main.entity.Solicitud;
import com.epy.main.dto.SolicitudDTO;
import com.epy.main.service.SolicitudService;
import com.epy.main.service.SolicitudServiceImpl;
import com.epy.main.util.Constantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;


import java.time.Clock;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/solicitud")
@CrossOrigin(origins = "http://localhost:4200")
public class RestSolicitudController {

	@Autowired
	private SolicitudService solicitudService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Solicitud>>listarSolicitud() {
		System.out.println("entra AQUI");
		List<Solicitud> lst = solicitudService.listarSolicitud();
		System.out.println("LA lista:   "+lst);
		return ResponseEntity.ok(lst);
	}
	
	// http://localhost:9010/rest/solicitud/registraSolicitud
	@PostMapping("/registraSolicitud")
	@ResponseBody 
	public ResponseEntity<Map<String, Object>> registrarSolicitud(@RequestBody SolicitudDTO objSolicitud) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Solicitud solicitud = new Solicitud(objSolicitud);
			
			Solicitud objSalida = solicitudService.insertaActualizaSolicitud(solicitud);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	

	// http://localhost:9010/rest/solicitud/actualizaSolicitud

	@PutMapping("/actualizaSolicitud")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaSolicitud(@RequestBody Solicitud obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Solicitud objSalida =  solicitudService.insertaActualizaSolicitud(obj);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_ACT_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

	// http://localhost:9010/rest/solicitud/listaSolicitudConParametros
	@GetMapping("/listaSolicitudConParametros")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listarSolicitudesxUsuario(

			@RequestParam(name = "id_persona", required = false, defaultValue = "-1") int persona,
			@RequestParam(name = "estado", required = false, defaultValue = "") String estado,
			@RequestParam(name = "id_aplicacion", required = false, defaultValue = "") String fechaInicio,
			@RequestParam(name = "fechaInicio", required = false, defaultValue = "") String fechaFin,
			@RequestParam(name = "fechaFin", required = false, defaultValue = "-1") int aplicativo
	) {
		Map<String, Object> salida = new HashMap<>();

		try {
			List<SolicitudUserDTO> lista = solicitudService.listarSolicitudesxUsuario(persona,"%"+estado+"%", fechaInicio, fechaFin, aplicativo);
			if (CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "No existen datos para mostrar");
			}else {
				salida.put("lista", lista);
				salida.put("mensaje", "Existen " + lista.size() + " elementos para mostrar");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", com.epy.main.util.Constantes.MENSAJE_CONSULTA_ERROR);
		}
		return ResponseEntity.ok(salida);
	}


}
