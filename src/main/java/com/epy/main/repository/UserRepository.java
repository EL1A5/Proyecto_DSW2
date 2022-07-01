package com.epy.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epy.main.dto.UsuarioDTO;
import com.epy.main.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	public Optional<User> findByUsername(String username);
	
	
	@Query(
			value= "select new com.epy.main.dto.UsuarioDTO(u.id, u.username, u.password) from entidad_user u where u.username=?1 and u.password=?2"
			)
	public UsuarioDTO findByUsernameAndPassword(String username, String password);
	
	

	
}
