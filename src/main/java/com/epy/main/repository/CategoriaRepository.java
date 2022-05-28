package com.epy.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epy.main.entity.Categoria;



@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

	
	public List<Categoria> findByDescripcion(String descripcion);
	public Categoria findByIdCategoria(int idCategoria);
	
}  
