package com.epy.main.dto;

import com.epy.main.entity.User;

public class UsuarioDTO {

	
	private Long id;
	private String username;
	private String password;
	
	public UsuarioDTO() {
		
	}
	
	public UsuarioDTO(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public UsuarioDTO(User user) {
		this.id= user.getId();
		this.username = user.getUsername();
		this.password = user.getPassword();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
