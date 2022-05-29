package com.epy.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.epy.main.entity.Aplicacion;
import com.epy.main.service.IAplicacion;

@RestController
@RequestMapping("/aplicacion")
@CrossOrigin(origins = "http://localhost:4200")
public class RestAplicacionController {
	
	
	@Autowired
	IAplicacion serviceAplicacion;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Aplicacion>> listadoUsuarios() {
		return ResponseEntity.ok(serviceAplicacion.listar());
	}
	
	
	
	
	

}
