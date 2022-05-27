package com.epy.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.epy.main.dto.SolicitudUserDTO;
import com.epy.main.entity.Aplicacion;
import com.epy.main.service.IAplicacion;
import com.epy.main.service.IPersona;
import com.epy.main.service.ISolicitud;
import com.epy.main.service.IUser;
import com.epy.main.util.AppSettings;

@RestController
@RequestMapping("/prueba")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class PruebaController {

	@Autowired
	IUser serviceUser;

	@Autowired
	IPersona servicePersona;

	@Autowired
	private IAplicacion serviceAplicacion;

	@Autowired
	ISolicitud serviceSolicitud;

	@GetMapping("/listar")
	@ResponseBody
	public ResponseEntity<List<Aplicacion>> listadoProducto() {
		return ResponseEntity.ok(serviceAplicacion.listar());
	}
	
	/*
	 * @GetMapping("/listar") public List<User> prueba() { return
	 * serviceUser.listar(); }
	 */

	/*
	 * @GetMapping("/listarPersonas") public List<SolicitudUserDTO> prueba2() {
	 * //return servicePersona.listar(); //return servicePersona.findByNombre("");
	 * return serviceSolicitud.listarSolicitudesxUsuario(3, "Registrado",
	 * "2021-05-01", "2021-07-01", 2); }
	 * 
	 * @GetMapping("/registrarPersona") public String guardar() {
	 * 
	 * BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
	 * 
	 * 
	 * List<Authority> listaPermiso= new ArrayList<Authority>();
	 * 
	 * Authority authority= new Authority(); authority.setId(4);
	 * 
	 * listaPermiso.add(authority);
	 * 
	 * 
	 * User user = new User(); user.setEnabled(true); user.setPassword("dsaf");
	 * user.setUsername("vtalia"); user.setAuthority(listaPermiso);
	 * 
	 * 
	 * 
	 * Persona persona = new Persona(); persona.setDni("99999999");
	 * persona.setCelular("956473754"); persona.setApellidos("YUCANOR");
	 * persona.setFechaRegistro("2021-05-15 22:00:00"); persona.setNombre("Romeo");
	 * persona.setTelefono("056789456");
	 * 
	 * 
	 * 
	 * 
	 * 
	 * persona.setUser(user); user.setPersona(persona);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * servicePersona.guardar(persona);
	 * 
	 * 
	 * 
	 * return ""; }
	 */

}
