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

import com.epy.main.entity.Persona;
import com.epy.main.entity.User;
import com.epy.main.service.IPersona;
import com.epy.main.service.IUser;
@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class RestUsuarioController {
	
	@Autowired
	private IUser serviceUsuario;
	@Autowired
	IPersona servicePersona;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Persona>> listadoUsuarios() {
		return ResponseEntity.ok(servicePersona.listar());
	}
	
	
	
	@PostMapping
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> insertaUser(@RequestBody User usuario){
		Map<String, Object> salida = new HashMap<>();
		/*
		 * System.out.println("OBJETO A GUARDAR : " + usuario); try {
		 * 
		 * 
		 * 
		 * 
		 * if (objSalida == null) { salida.put("mensaje",
		 * "No se registró, consulte con el administrador."); }else {
		 * salida.put("mensaje", "Se registró correctamente."); } } catch (Exception e)
		 * { e.printStackTrace(); salida.put("mensaje",
		 * "No se registró, consulte con el administrador."); }
		 */
		return ResponseEntity.ok(salida);
	}
}
