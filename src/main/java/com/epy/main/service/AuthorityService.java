package com.epy.main.service;

import java.util.List;
import com.epy.main.entity.Authority;

public interface AuthorityService {
	
	public List<Authority> listar();
	public int guardar(Authority authority);
	

}
