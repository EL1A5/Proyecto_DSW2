package com.epy.main.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.epy.main.dto.SolicitudUserDTO;
import com.epy.main.entity.Aplicacion;
import com.epy.main.entity.Authority;
import com.epy.main.entity.Categoria;
import com.epy.main.entity.Persona;
import com.epy.main.entity.Solicitud;
import com.epy.main.entity.User;
import com.epy.main.service.AplicacionService;
import com.epy.main.service.ICategoria;
import com.epy.main.service.IPersona;
import com.epy.main.service.SolicitudService;
import com.epy.main.service.ITipoSolicitud;
import com.epy.main.service.IUser;

@Controller
public class HomeController {
  
	@Autowired
	AplicacionService serviceAplicacion;

	@Autowired
	ITipoSolicitud serviceTipoSolicitud;

	@Autowired
	ICategoria serviceCategoria;

	@Autowired
	SolicitudService serviceSolicitud;

	@Autowired
	IUser serviceUsuario;

	@Autowired
	IPersona servicePersona;

	@GetMapping({ "/", "/login" })
	public String home() {
		return "login";
	}

	@GetMapping("/menu")
	public String configuracionUsuario(Model model) {
		model.addAttribute("listaAplicativos", serviceAplicacion.listar());
		return "principal";
	}

	@GetMapping("/logout")
	public String salir() {
		return "logout";
	}

	@GetMapping("/configusuario")
	public String nav_usuario(Model model) {
		model.addAttribute("persona", new Persona());
		model.addAttribute("authority", new Authority());
		model.addAttribute("listaPersonas", servicePersona.findByNombre(""));
		return "/configuracion/usuario";
	}

	@GetMapping("/configcategoria")
	public String nav_categoria(Model model) {

		model.addAttribute("listaCategorias", serviceCategoria.listar());
		model.addAttribute("categoria", new Categoria());
		return "/configuracion/categoria";
	}

	@GetMapping("/configaplicacion")
	public String nav_aplcacion(Model model) {
		model.addAttribute("listaAplicaciones", serviceAplicacion.listar());
		model.addAttribute("aplicacion", new Aplicacion());
		return "/configuracion/aplicacion";
	}

	@GetMapping("/repsolicitudes")
	public String rep_solicitudes(Model model) {
		model.addAttribute("listaAplicativos", serviceAplicacion.listar());
		return "/reportes/consultaSolicitudes";
	}

	@GetMapping("/repusuarios")
	public String rep_usuarios() {
		return "/reportes/consultaUsuarios";
	}

	@GetMapping("/regsolicitudes")
	public String reg_solicitudes(Model model) {
		model.addAttribute("listaAplicativos", serviceAplicacion.listar());
		model.addAttribute("listaTipoSolicitudes", serviceTipoSolicitud.listar());
		model.addAttribute("listaCategoria", serviceCategoria.listar());
		model.addAttribute("solicitud", new Solicitud());
		return "/core/registroSolicitud";
	}

	@PostMapping("/registrarAtencion")
	public String registrarAtencion(@ModelAttribute Solicitud objSolicitud) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		Solicitud solicitud = new Solicitud();
		solicitud.setTipoSolicitud(objSolicitud.getTipoSolicitud());
		solicitud.setAplicacion(objSolicitud.getAplicacion());
		solicitud.setCategoria(objSolicitud.getCategoria());
		solicitud.setDescripcionSolicitud(objSolicitud.getDescripcionSolicitud());
		solicitud.setFechaRegistro(formatoFecha.format(date));
		solicitud.setPrioridad(objSolicitud.getPrioridad());
		solicitud.setEstado("Registrado");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		Optional<User> usuario = serviceUsuario.buscarUsuario(userDetails.getUsername());
		solicitud.setPersona(usuario.get().getPersona());
		serviceSolicitud.guardar(solicitud);
		return "redirect:/regsolicitudes?success=true";
	}

	@PostMapping("/configAplicacionRegistrar")
	public String registrarAplicacion(@ModelAttribute Aplicacion objAplicacion) {
		String url = "";
		int insertar = serviceAplicacion.guardar(objAplicacion);
		if (insertar > 0) {
			url = "redirect:/configaplicacion?success=true";
		} else {
			url = "redirect:/configaplicacion?success=false";
		}
		return url;
	}

	@PostMapping("/configCategoriaRegistrar")
	public String registrarCategoria(@ModelAttribute Categoria obj) {
		String url = "";
		int insertar = serviceCategoria.guardar(obj);
		if (insertar > 0) {
			url = "redirect:/configcategoria?success=true";
		} else {
			url = "redirect:/configcategoria?success=false";
		}
		return url;
	}

	@PostMapping("/configPersonaRegistrar")
	public String registrarPersona(@ModelAttribute Persona obj, @ModelAttribute Authority obj2) {
		String url = "";

		Date date = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Authority objAuthority = new Authority();
		objAuthority.setId(obj2.getId());
		// Contraseña

		BCryptPasswordEncoder encriptado = new BCryptPasswordEncoder(4);

		// Datos Persona

		Persona persona = new Persona();
		persona.setIdpersona(obj.getIdpersona());
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
		user.setEnabled(true);
		user.setAuthority(objAuthority);
		user.setPersona(persona);

		int rptaGuardar = servicePersona.guardar(persona);
		serviceUsuario.guardar(user);

		if (rptaGuardar > 0) {
			url = "redirect:/configusuario?success=true";
		} else {
			url = "redirect:/configusuario?success=false";
		}

		return url;
	}

	@PostMapping("/repConsultaUsuarios")
	public String consultar_usuarios(HttpServletRequest request, Model model) {
		String url = "/reportes/consultaUsuarios";

		int tipoUsuario = Integer.parseInt(request.getParameter("cboTipoUsuario"));
		String dni = request.getParameter("txtDNI");
		String apellidos = request.getParameter("txtApellidos");

		if (tipoUsuario == 0 && dni.equals("")) {
			model.addAttribute("listaPersonas", servicePersona.findConsultaUsuarioxApellido("%" + apellidos + "%"));
		} else {
			model.addAttribute("listaPersonas", servicePersona.findConsultaUsuario(tipoUsuario, dni));
		}
		return url;
	}

	@PostMapping("/missolicitudes")
	public String consultar_misSolicitudes(HttpServletRequest request, Model model) {
		String url = "principal";

		String estado = request.getParameter("cboEstado");
		int aplicativo = Integer.parseInt(request.getParameter("cboAplicacion"));
		String fecha = request.getParameter("fecha");

		int buscarSeparador = fecha.indexOf("/");
		String fechaInicio = fecha.substring(0, buscarSeparador).trim() + " 00:00:00";
		String fechaFin = fecha.substring(buscarSeparador + 2).trim() + " 23:59:59";

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		Optional<User> usuario = serviceUsuario.buscarUsuario(userDetails.getUsername());
		Persona persona = usuario.get().getPersona();

		model.addAttribute("listaAplicativos", serviceAplicacion.listar());
		model.addAttribute("listaSolicitudes", serviceSolicitud.listarSolicitudesxUsuario(persona.getIdpersona(),
				estado, fechaInicio, fechaFin, aplicativo));

		return url;
	}
	
	
	
	@GetMapping("/verSolicitud/{codigo}")
	public String verSolicitud(@PathVariable int codigo, Model model) {
		SolicitudUserDTO objSol  = serviceSolicitud.fetchSolicitudDetallexIDDTODataInnerJoin(codigo);
		model.addAttribute("solicitud", objSol);
		return "detalle";
	}
	
	@PostMapping("/consultarSolicitudes")
	public String consultar_Solicitudes(HttpServletRequest request, Model model) {

		String estado = request.getParameter("cboEstado");
		String fecha = request.getParameter("fecha");
		int buscarSeparador = fecha.indexOf("/");
		String fechaInicio = fecha.substring(0, buscarSeparador).trim() + " 00:00:00";
		String fechaFin = fecha.substring(buscarSeparador + 2).trim() + " 23:59:59";

		model.addAttribute("listaAplicativos", serviceAplicacion.listar());
		model.addAttribute("listaSolicitudes", serviceSolicitud.fetchSolicitudDTODataInnerJoin(estado, fechaInicio, fechaFin));

		return "/reportes/consultaSolicitudes";
	}
	
	@GetMapping("/verSolicitudDetalle/{codigo}")
	public String verSolicitudDetalle(@PathVariable int codigo, Model model) {
		SolicitudUserDTO objSol  = serviceSolicitud.fetchSolicitudDetallexIDDTODataInnerJoin(codigo);
		model.addAttribute("solicitud", objSol);
		return "detalleOperador";
	}
	
	
	@PostMapping("/solicitudActualizar")
	public String solicitud_actualizar(@ModelAttribute SolicitudUserDTO sol ) {
		Date fecha = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Solicitud solicitud = new Solicitud();
		//sol.getCodigo(), formato.format(fecha), sol.getSolucion()
		Solicitud inserto = serviceSolicitud.insertaActualizaSolicitud(solicitud);
		return "redirect:/repsolicitudes";
	}
	
	
	
	
	
	
	
	
	
	

}
