package com.epy.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.epy.main.dto.SolicitudUserDTO;
import com.epy.main.entity.Solicitud;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {
	
	 
	/*@Query(
			value = "select new com.epy.main.dto.SolicitudUserDTO"
					+ "(sol.idSolicitud, sol.estado, sol.fechaRegistro, sol.fechaCierre, "
					+ "sol.prioridad, app.descripcion,tip.descripcion, cat.descripcion) "
					+ " from entity_solicitud sol inner join sol.aplicacion app "
					+ " inner join sol.tipoSolicitud tip "
					+ " inner join sol.categoria cat"
					+ " inner join sol.persona per where per.idpersona=?1 and sol.estado=?2 and "
					+ " sol.fechaRegistro between ?3 and ?4 and app.idAplicacion=?5 "
			)
	public List<SolicitudUserDTO> fetchSolicitudUserDTODataInnerJoin(int persona, String estado, 
			String fechaInicio, String fechaFin, int aplicativo);*/
	
	/*@Query(
			value = "select new com.epy.main.dto.SolicitudUserDTO"
					+ "(sol.idSolicitud, sol.estado, sol.fechaRegistro, sol.fechaCierre, "
					+ "sol.prioridad, app.descripcion,tip.descripcion, cat.descripcion,sol.descripcionSolicitud, "
					+ " sol.descripcionAtencion, per.nombre, per.apellidos ) "
					+ " from entity_solicitud sol inner join sol.aplicacion app "
					+ " inner join sol.tipoSolicitud tip "
					+ " inner join sol.categoria cat"
					+ " inner join sol.persona per where sol.estado=?1 and "
					+ " sol.fechaRegistro between ?2 and ?3"
			)
	public List<SolicitudUserDTO> fetchSolicitudDTODataInnerJoin( String estado, 
			String fechaInicio, String fechaFin);*/
	
	
	/*@Query(
			value = "select new com.epy.main.dto.SolicitudUserDTO"
					+ "(sol.idSolicitud, sol.estado, sol.fechaRegistro, sol.fechaCierre, "
					+ "sol.prioridad, app.descripcion,tip.descripcion, cat.descripcion,sol.descripcionSolicitud, sol.descripcionAtencion ) "
					+ " from entity_solicitud sol inner join sol.aplicacion app "
					+ " inner join sol.tipoSolicitud tip "
					+ " inner join sol.categoria cat"
					+ " inner join sol.persona per where sol.idSolicitud=?1 "
			)
	public SolicitudUserDTO fetchSolicitudDetallexIDDTODataInnerJoin(int codigoSolicitud);*/
	
	
	
	
	/*@Transactional
	@Modifying
	@Query(
			value = "update entity_solicitud sol"
					+ " set sol.fechaCierre=?2 , sol.descripcionAtencion=?3, sol.estado='Atendido'"
					+ " where sol.idSolicitud=?1 "
			)
	public int updateSolicitud(int codigo, String fecha, String solucion);*/

	
    @Query("SELECT r FROM Solicitud r JOIN Aplicacion v ON v.id_aplicacion = r.id_aplicacion " +
            "WHERE (?1 is '' or r.estado LIKE ?1) and (?2 is -1 or v.id_aplicacion = ?2) and (?3 is '' or r.fechaRegistro LIKE ?3)")
	public List<Solicitud> listaSolicitudPorEstadoAplicativoFecha(String estado, int id_aplicacion, String fechaRegistro);
	
    
	

}
