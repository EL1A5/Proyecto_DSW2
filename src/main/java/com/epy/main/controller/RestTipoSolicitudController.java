package com.epy.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.epy.main.dto.TipoSolicitudDTO;
import com.epy.main.entity.Aplicacion;
import com.epy.main.entity.TipoSolicitud;
import com.epy.main.service.AplicacionServiceImpl;
import com.epy.main.service.TipoSolicitudService;

@RestController
@RequestMapping("/rest/tipoSolicitud")
@CrossOrigin(origins = "http://localhost:4200")
public class RestTipoSolicitudController {

	@Autowired
	private TipoSolicitudService tiposolicitudservice;
	
	/*http://localhost:9010/rest/tipoSolicitud/*/
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<TipoSolicitudDTO>>listarTipoSolicitud() {
		List<TipoSolicitudDTO> lst = tiposolicitudservice.listar();
		return ResponseEntity.ok(lst);
	}

	
}
