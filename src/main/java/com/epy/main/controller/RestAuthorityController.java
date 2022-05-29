package com.epy.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.epy.main.entity.Authority;
import com.epy.main.service.AuthorityService;


@RestController
@RequestMapping("/authority")
@CrossOrigin(origins = "http://localhost:4200")
public class RestAuthorityController {
	
	 
	@Autowired
	AuthorityService authorityService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Authority>> listadoUsuarios() {
		return ResponseEntity.ok(authorityService.listar());
	}
	
	@PostMapping
	@ResponseBody 
	public ResponseEntity<Map<String, Object>> registrarAplicacion(@RequestBody Authority obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			int inserto = authorityService.guardar(obj);
			if (inserto == 1) {
				salida.put("mensaje", "Se proceso la solicitud.");
			} else {
				salida.put("mensaje", "Inconveniente al procesar la solicitud.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error : " +e.getMessage());
		}
		return ResponseEntity.ok(salida);
	}
	
}
