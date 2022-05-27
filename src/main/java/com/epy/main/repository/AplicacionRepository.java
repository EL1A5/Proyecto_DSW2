package com.epy.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epy.main.entity.Aplicacion;


@Repository
public interface AplicacionRepository extends JpaRepository<Aplicacion, Integer> {

		
}
