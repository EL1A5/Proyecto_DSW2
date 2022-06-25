package com.epy.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.epy.main.entity.Aplicacion;
import com.epy.main.entity.Solicitud;
import com.epy.main.service.SolicitudServiceImpl;
import com.epy.main.util.Constantes;

@RestController
@RequestMapping("/rest/solicitud")
@CrossOrigin(origins = "http://localhost:4200")
public class RestSolicitudController {
	
	@Autowired
	private SolicitudServiceImpl solicitudService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Solicitud>>listarSolicitud() {
		List<Solicitud> lst = solicitudService.listarSolicitud();
		return ResponseEntity.ok(lst);
	}
	
	// http://localhost:9010/rest/solicitud/registraSolicitud
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
		public ResponseEntity<Map<String, Object>> listaSolicitudPorEstadoAplicativoFecha(

				@RequestParam(name = "estado", required = false, defaultValue = "") String estado,
				@RequestParam(name = "aplicativo", required = false, defaultValue = "-1") int id_aplicacion,
				@RequestParam(name = "fechaRegistro", required = false, defaultValue = "") String fechaRegistro
		) {
			Map<String, Object> salida = new HashMap<>();
			
			try {
				List<Solicitud> lista = solicitudService.listaSolicitudPorEstadoAplicativoFecha("%"+estado+"%", id_aplicacion,fechaRegistro);
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
