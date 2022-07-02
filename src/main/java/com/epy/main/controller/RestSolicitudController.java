package com.epy.main.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.epy.main.dto.PersonaDTO;
import com.epy.main.dto.RptaServerDTO;
import com.epy.main.dto.SolicitudUserDTO;
import com.epy.main.dto.SolicitudUsuarioDTO;
import com.epy.main.entity.Aplicacion;
import com.epy.main.entity.Categoria;
import com.epy.main.entity.Persona;
import com.epy.main.entity.Solicitud;
import com.epy.main.entity.TipoSolicitud;
import com.epy.main.service.SolicitudService;
import com.epy.main.service.SolicitudServiceImpl;
import com.epy.main.util.Constantes;

@RestController
@RequestMapping("/rest/solicitud")
@CrossOrigin(origins = "http://localhost:4200")
public class RestSolicitudController {
	
	@Autowired
	private SolicitudService solicitudService;
	
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
	
	@PostMapping("/registrarSolicitudNew")
	@ResponseBody
	public  ResponseEntity<RptaServerDTO> registrarSolicitudNew(@RequestBody SolicitudUsuarioDTO obj){
		RptaServerDTO rpta = new RptaServerDTO();
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
	
		Solicitud sol = new Solicitud();
		TipoSolicitud tip = new TipoSolicitud();
		tip.setIdTipoSolicitud(obj.getTipoSolicitud());
		
		Aplicacion app = new Aplicacion();
		app.setIdAplicacion(obj.getAplicacion());
		
		Categoria cat = new Categoria();
		cat.setIdCategoria(obj.getCategoria());
		
		sol.setDescripcionSolicitud(tip.getDescripcion());
		sol.setPrioridad(obj.getPrioridad());
		
		sol.setEstado("Registrado");
		sol.setDescripcionSolicitud(obj.getDescripcion());
		
		Persona per= new Persona();
		per.setIdpersona(1); // modificar este valor
		
		
		sol.setTipoSolicitud(tip);
		sol.setAplicacion(app);
		sol.setCategoria(cat);
		sol.setFechaRegistro(sdf.format(date));
		sol.setPersona(per);
		

		
		Solicitud objSalida = solicitudService.insertaActualizaSolicitud(sol);
		if (objSalida != null) {
			rpta.setCodigo(1);
			rpta.setMensaje("Se registro");
		} else {
			rpta.setCodigo(0);
			rpta.setMensaje("No se registro");
		}
		System.out.println(rpta.getCodigo());
		System.out.println(rpta.getMensaje());
		return ResponseEntity.ok(rpta);
	}
	
	
	
	
	
	
	
	

	
	
	

}
