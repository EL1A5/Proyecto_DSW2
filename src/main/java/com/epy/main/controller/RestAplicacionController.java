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
import com.epy.main.service.AplicacionServiceImpl;
import com.epy.main.util.Constantes;

@RestController
@RequestMapping("/rest/aplication")
@CrossOrigin(origins = "http://localhost:4200")
public class RestAplicacionController {
	
	@Autowired
	private AplicacionServiceImpl aplicacionService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Aplicacion>>listarAplicacion() {
		List<Aplicacion> lst = aplicacionService.listarAplicacion();
		return ResponseEntity.ok(lst);
	}

	/*http://localhost:9010/rest/aplication/registraAplicacion*/
	@PostMapping("/registraAplicacion")
	@ResponseBody 
	public ResponseEntity<Map<String, Object>> registrarAplicacion(@RequestBody Aplicacion objAplicacion) {
		Map<String, Object> salida = new HashMap<>();
		try {
			objAplicacion.setIdAplicacion(0);
			Aplicacion objSalida = aplicacionService.insertaActualizaAplicacion(objAplicacion);
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
	@PutMapping("/actualizaAplicacion")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaAplicacion(@RequestBody Aplicacion objAplicacion) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Aplicacion objSalida =  aplicacionService.insertaActualizaAplicacion(objAplicacion);
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
