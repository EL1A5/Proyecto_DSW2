package com.epy.main.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.epy.main.entity.Authority;
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
	public  ResponseEntity<Map<String, Object>> insertaUser(@RequestBody Persona obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			System.out.println(obj.getIdpersona());
			System.out.println(obj.getDni());
			System.out.println(obj.getApellidos());
			Date date = new Date();
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
			
			List<Persona> listaPersona=servicePersona.buscarDni(obj.getDni());
			
			System.out.println("LISTA SIZE : " +listaPersona.size());
			if (listaPersona.size()  == 0) {
				System.out.println("INGRESA A REGISTRAR");
				BCryptPasswordEncoder encriptado = new BCryptPasswordEncoder(4);
				Persona persona = new Persona();
				//persona.setIdpersona(obj.getIdpersona());
				persona.setNombre(obj.getNombre());
				persona.setApellidos(obj.getApellidos());
				persona.setDni(obj.getDni());
				persona.setCelular(obj.getCelular());
				persona.setTelefono(obj.getTelefono());
				persona.setFechaRegistro(formato.format(date));
				
				Optional<User> usuarioBusqueda = serviceUsuario.buscarUsuario(obj.getDni());
				
				User user = new User();
				if (usuarioBusqueda.isPresent()) {
					user.setId(usuarioBusqueda.get().getId());
					user.setPassword(usuarioBusqueda.get().getPassword());
					user.setUsername(usuarioBusqueda.get().getPersona().getDni());
				} else {
					user.setPassword(encriptado.encode(obj.getDni()));
					user.setUsername(obj.getDni());
				}
				
				Authority objAuthority = new Authority();
				objAuthority.setId(1);
				user.setEnabled(true);
				user.setAuthority(objAuthority);
				user.setPersona(persona);
				persona.setUser(user);
				
				int rptaGuardar = servicePersona.guardar(persona);
				serviceUsuario.guardar(user);

				if (rptaGuardar > 0) {
					salida.put("mensaje", "REGISTRO EXITOSO");
				} else {
					salida.put("mensaje", "error en el registro");
				}
						
			}else {
				salida.put("mensaje", "EL USUARIO YA EXISTE DNI:"+ obj.getDni());
				
			}
			
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
			salida.put("mensaje", "error en el registro "+e.getMessage());
		}
		
		 
		return ResponseEntity.ok(salida);
	}
	
	
	
	
	
	
	
	
}
