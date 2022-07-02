package com.epy.main.dto;

import com.epy.main.entity.Aplicacion;
import com.epy.main.entity.Categoria;
import com.epy.main.entity.Persona;
import com.epy.main.entity.TipoSolicitud;

import java.io.Serializable;

public class SolicitudDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private int id_solicitud;
    private String des_atencion;
    private String des_solicitud;
    private String estado;
    private String fec_cierre;
    private String fec_reg;
    private String prioridad;
    private Aplicacion aplicacion;
    private Categoria categoria;
    private Persona persona;
    private TipoSolicitud tipoSolicitud;


    public SolicitudDTO(int id_solicitud, String des_atencion, String des_solicitud, String estado, String fec_cierre, String fec_reg, String prioridad, Aplicacion aplicacion, Categoria categoria, Persona persona, TipoSolicitud tipoSolicitud) {
        super();
        this.id_solicitud = id_solicitud;
        this.des_atencion = des_atencion;
        this.des_solicitud = des_solicitud;
        this.estado = estado;
        this.fec_cierre = fec_cierre;
        this.fec_reg = fec_reg;
        this.prioridad = prioridad;
        this.aplicacion = aplicacion;
        this.categoria = categoria;
        this.persona = persona;
        this.tipoSolicitud = tipoSolicitud;
    }

    public int getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(int id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    public String getDes_atencion() {
        return des_atencion;
    }

    public void setDes_atencion(String des_atencion) {
        this.des_atencion = des_atencion;
    }

    public String getDes_solicitud() {
        return des_solicitud;
    }

    public void setDes_solicitud(String des_solicitud) {
        this.des_solicitud = des_solicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFec_cierre() {
        return fec_cierre;
    }

    public void setFec_cierre(String fec_cierre) {
        this.fec_cierre = fec_cierre;
    }

    public String getFec_reg() {
        return fec_reg;
    }

    public void setFec_reg(String fec_reg) {
        this.fec_reg = fec_reg;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Aplicacion getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public TipoSolicitud getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }
}
