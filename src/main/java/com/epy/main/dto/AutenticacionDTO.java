package com.epy.main.dto;

public class AutenticacionDTO {
	
	
	private String username;
	private String password;
	
	public AutenticacionDTO() {
		
	}
	
	public AutenticacionDTO(String usuario, String password) {
		super();
		this.username = usuario;
		this.password = password;
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
