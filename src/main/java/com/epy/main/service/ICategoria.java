package com.epy.main.service;

import java.util.List;

import com.epy.main.entity.Categoria;

public interface ICategoria {
	
	public List<Categoria> listar();
	public int guardar(Categoria categoria);
	public List<Categoria> findByDescripcion(String descripcion);
	public Categoria findByIdCategoria(int idCategoria);
	

	
}
  