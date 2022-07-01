package com.epy.main.service;
import java.util.List;
import java.util.Optional;

import com.epy.main.dto.UsuarioDTO;
import com.epy.main.entity.User;

public interface UserService {
	public List<User> listar();
	public Optional<User> buscarUsuario(String nombreUsuario);
	public int guardar(User usuario);
	public UsuarioDTO findByUsernameAndPassword(String usuario, String password);

}
  