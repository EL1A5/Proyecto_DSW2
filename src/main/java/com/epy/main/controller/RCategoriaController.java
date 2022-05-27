package com.epy.main.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epy.main.service.ICategoria;

@RestController
@RequestMapping("/categoria")
public class RCategoriaController {
	@Autowired
	ICategoria serviceCategoria;

	@GetMapping("/lista")
	public ResponseEntity<Map<String, Object>> lista_Categoria() {
		
		Map<String, Object> salida = new HashMap<>();
		
		salida.put("lista", serviceCategoria.listar());
		
		return ResponseEntity.ok(salida);
	}
	
	
	
}
