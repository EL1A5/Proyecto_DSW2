package com.epy.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.epy.main.entity.Aplicacion;
import com.epy.main.entity.Solicitud;
import com.epy.main.service.AplicacionServiceImpl;
import com.epy.main.service.SolicitudServiceImpl;
import com.epy.main.util.Constantes;

@RestController
@RequestMapping("/rest/solicitud")
@CrossOrigin(origins = "http://localhost:4200")
public class RestSolicitudController {
	@Autowired
	private SolicitudServiceImpl solicitudService;
	
	
	/*http://localhost:9010/rest/aplication/registraAplicacion*/
	@PostMapping("/registraSolicitud")
	@ResponseBody 
	public ResponseEntity<Map<String, Object>> registrarSolicitud(@RequestBody Solicitud obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setIdSolicitud(0);
			
			Solicitud objSalida = solicitudService.insertaActualizaSolicitud(obj);
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
	
	/*http://localhost:9010/rest/aplication/actualizaAplicacion*/
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
	

}
