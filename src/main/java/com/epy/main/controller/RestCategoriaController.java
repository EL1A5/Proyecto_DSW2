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
import com.epy.main.dto.CategoriaDTO;
import com.epy.main.entity.Categoria;
import com.epy.main.service.*;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "http://localhost:4200")
public class RestCategoriaController {
	
	
	@Autowired
	private ICategoria serviceCategoria;
	
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Categoria>> listadoUsuarios() {
		return ResponseEntity.ok(serviceCategoria.listar());
	}
	
	
	
	@PostMapping
	public  ResponseEntity<Map<String, Object>> insertaCategoria(@RequestBody CategoriaDTO obj){
		Map<String, Object> salida = new HashMap<>();
	
		try {
			Categoria cat = new Categoria(obj);
			List<Categoria> lista = serviceCategoria.findByDescripcion(obj.getDescripcion());
			int guardar =0;
			if (lista.size() ==0) {
				guardar = serviceCategoria.guardar(cat);
				
				if (guardar == 1) {
					salida.put("mensaje", "Se proceso la solicitud");
				}else {
					salida.put("mensaje", "Se produjo un inconveniente al procesar la solicitud");
				}
			
			}else {
				salida.put("mensaje", "Categoria Existe");
			}
			salida.put("codigo", guardar);
		}catch(Exception ex) {
			salida.put("codigo", -1);
			salida.put("mensaje", "error en el registro "+ex.getMessage());
		}	
		return ResponseEntity.ok(salida);
	}
	
	
	@PutMapping
	public  ResponseEntity<Map<String, Object>> actualizaCategoria(@RequestBody CategoriaDTO obj){
		Map<String, Object> salida = new HashMap<>();
	
		try {
			Categoria categoria = new Categoria(obj);
			System.out.println("a");
			Categoria cat = serviceCategoria.findByIdCategoria(obj.getIdCategoria());
			System.out.println("b");
			int actualizar =0;
			if (cat != null) {
				System.out.println("c");
				
				List<Categoria> lista = serviceCategoria.findByDescripcion(obj.getDescripcion());
				if (lista.size() ==0) {
					actualizar = serviceCategoria.guardar(categoria);
					if (actualizar == 1) {
						salida.put("mensaje", "Se proceso la solicitud");
					}else {
						salida.put("mensaje", "Se produjo un inconveniente al procesar la solicitud");
					}
				}else {
					salida.put("mensaje", "Descripcion existe. Actualize por otra descripcion.");
				}
				salida.put("codigo", actualizar);
			}else {
				salida.put("mensaje", "Categoria No Existe");
			}
		}catch(Exception ex) {
			salida.put("codigo", -1);
			salida.put("mensaje", "error en el registro "+ex.getMessage());
		}	
		return ResponseEntity.ok(salida);
	}
	

}
