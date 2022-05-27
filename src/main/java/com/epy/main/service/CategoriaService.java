package com.epy.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epy.main.entity.Categoria;
import com.epy.main.repository.CategoriaRepository;

@Service
public class CategoriaService implements ICategoria {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Override
	public List<Categoria> listar() {
		
		return categoriaRepository.findAll();
	}  

	@Override
	public int guardar(Categoria categoria) {
		int res=0;
		Categoria objCategoria =  categoriaRepository.save(categoria);
		if (!objCategoria.equals(null)) {
			res=1;
		}
		return res;
	}

}
