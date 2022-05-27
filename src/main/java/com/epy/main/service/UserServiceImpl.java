package com.epy.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epy.main.entity.User;
import com.epy.main.repository.UserRepository;

@Service
public class UserServiceImpl implements IUser {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> listar() {
		
		return (List<User>)userRepository.findAll();
	}

	@Override
	public Optional<User> buscarUsuario(String nombreUsuario) {
		return  userRepository.findByUsername(nombreUsuario);
	}
   
	@Override
	public int guardar(User usuario) {
		int res=0;
		User obj = userRepository.save(usuario);
		if (!obj.equals(null)) {
			res=1;
		}
		return res;
	}

}
