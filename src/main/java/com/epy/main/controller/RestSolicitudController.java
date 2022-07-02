package com.epy.main.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.epy.main.dto.ConsultarSolicitudesXEstadoFecha;
import com.epy.main.dto.RptaServerDTO;
import com.epy.main.dto.SolicitudUserDTO;
import com.epy.main.dto.SolicitudUsuarioDTO;
import com.epy.main.entity.Aplicacion;
import com.epy.main.entity.Categoria;
import com.epy.main.entity.Persona;
import com.epy.main.entity.Solicitud;
import com.epy.main.entity.TipoSolicitud;
import com.epy.main.service.SolicitudService;
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
	
	
	@PostMapping("/consultarSolicitud")
	@ResponseBody
	public ResponseEntity<SolicitudUserDTO>consultarSolicitudxID(@RequestBody RptaServerDTO rpta) {
		
		System.out.println("backend consultarSolicitudxID : " + rpta.getCodigo());
		SolicitudUserDTO obj = solicitudService.fetchSolicitudDetallexIDDTODataInnerJoin(rpta.getCodigo());
		return ResponseEntity.ok(obj);
	}
	
	@PostMapping("/consultarSolicitudxUsuarioFecha")
	@ResponseBody
	public ResponseEntity<List<SolicitudUserDTO>> consultarSolicitudxUsuarioFecha(@RequestBody ConsultarSolicitudesXEstadoFecha obj){
		
		System.out.println("backend - consultarSolicitudxUsuarioFecha - estado " + obj.getEstado());
		System.out.println("backend - consultarSolicitudxUsuarioFecha - inicio "+obj.getFechaInicio());
		System.out.println("backend - consultarSolicitudxUsuarioFecha - fin "+obj.getFechaFin());
		
		List<SolicitudUserDTO> lista = solicitudService.fetchSolicitudDTODataInnerJoin(obj.getEstado(), 
				obj.getFechaInicio(), obj.getFechaFin());
		
		return ResponseEntity.ok(lista);
	}
	
	

	@PostMapping("/consultarSolicitudes")
	@ResponseBody
	public ResponseEntity<List<SolicitudUserDTO>> consultarSolicitudes(@RequestBody ConsultarSolicitudesXEstadoFecha obj) {
		System.out.println(obj.getEstado());
		System.out.println(obj.getFecha());
		
		List<Solicitud> lst = solicitudService.findByEstadoAndFechaRegistro(obj.getEstado(), obj.getFecha());
		List<SolicitudUserDTO> lista = new ArrayList<>();
		for (Solicitud x : lst) {
			SolicitudUserDTO sol = new SolicitudUserDTO();
			sol.setCodigo(x.getIdSolicitud());
			sol.setEstado(x.getEstado());
			sol.setFechaInicio(x.getFechaRegistro());
			sol.setFechaFin(x.getFechaCierre());
			sol.setAplicacion(x.getAplicacion().getDescripcion());
			sol.setPrioridad(x.getPrioridad());
			sol.setTipoSolicitud(x.getTipoSolicitud().getDescripcion());
			sol.setCategoria(x.getCategoria().getDescripcion());
			sol.setSolicitud(x.getDescripcionSolicitud());
			sol.setSolucion(x.getDescripcionAtencion());
			sol.setReg_nombres(x.getPersona().getNombre());
			sol.setReg_apellidos(x.getPersona().getApellidos());
			lista.add(sol);
		}
		
		
		System.out.println("Fila Backend : " + lista.size() );
		
		return ResponseEntity.ok(lista);
	}
	
	
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
		per.setIdpersona(2); // modificar este valor
		
		
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
	
	
	
	@PostMapping("/solicitudActualizar")
	public ResponseEntity<RptaServerDTO> solicitud_actualizar(@RequestBody SolicitudUserDTO sol ) {
		RptaServerDTO rpta = new RptaServerDTO();
		Date fecha = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		solicitudService.updateSolicitud(sol.getCodigo(), formato.format(fecha), sol.getSolucion());
		rpta.setCodigo(1);
		rpta.setMensaje("");
		return ResponseEntity.ok(rpta);
	}
	
	
	
	

	

}
