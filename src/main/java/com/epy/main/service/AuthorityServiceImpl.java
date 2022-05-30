package com.epy.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epy.main.entity.Authority;
import com.epy.main.repository.AuthorityRepository;

@Service
public class AuthorityServiceImpl implements AuthorityService {
	
	@Autowired
	AuthorityRepository repository;
	

	@Override
	public List<Authority> listar() {
		return repository.findAll();
	}

	@Override
	public int guardar(Authority authority) {
		int res=0;
		Authority auth =  repository.save(authority);
		if (!auth.equals(null)) {
			res=1;  
		}
		return res;	
	}
	
	

}
