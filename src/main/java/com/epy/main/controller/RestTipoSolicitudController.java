package com.epy.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.epy.main.dto.TipoSolicitudDTO;
import com.epy.main.service.TipoSolicitudService;

@RestController
@RequestMapping("/rest/tiposolicitud")
public class RestTipoSolicitudController {
	
	@Autowired
	private TipoSolicitudService tipoSolicitudService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<TipoSolicitudDTO>>listarSolicitud() {
		List<TipoSolicitudDTO> lst = tipoSolicitudService.lista();
		return ResponseEntity.ok(lst);
	}
	
}
