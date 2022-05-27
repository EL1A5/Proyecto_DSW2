package com.epy.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epy.main.entity.TipoSolicitud;

@Repository
public interface TipoSolicitudRepository extends JpaRepository<TipoSolicitud, Integer> {
  
}
