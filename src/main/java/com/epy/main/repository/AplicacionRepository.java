package com.epy.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epy.main.entity.Aplicacion;
import com.epy.main.entity.Categoria;


@Repository
public interface AplicacionRepository extends JpaRepository<Aplicacion, Integer> {

	public List<Aplicacion> findByDescripcion(String descripcion);
	public Aplicacion findByIdAplicacion(int idCategoria);
}
