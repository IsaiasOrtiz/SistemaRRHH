/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.entidades;

import java.sql.Date;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class Usuario {
    
     private int id;
     private int epEmpleado;
     private int tpTipo;
     private String usuario;
     private String clave;
     private Date fechaModificacion;
     private int usuarioCrea;
     private int usuarioModifica;
     private Date fechaCreacion;

    public Usuario() {
    }

    public Usuario(int id, int epEmpleado, int tpTipo, String usuario, String clave, Date fechaModificacion, int usuarioCrea, int usuarioModifica, Date fechaCreacion) {
        this.id = id;
        this.epEmpleado = epEmpleado;
        this.tpTipo = tpTipo;
        this.usuario = usuario;
        this.clave = clave;
        this.fechaModificacion = fechaModificacion;
        this.usuarioCrea = usuarioCrea;
        this.usuarioModifica = usuarioModifica;
        this.fechaCreacion = fechaCreacion;
    }
     

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEpEmpleado() {
        return epEmpleado;
    }

    public void setEpEmpleado(int epEmpleado) {
        this.epEmpleado = epEmpleado;
    }

    public int getTpTipo() {
        return tpTipo;
    }

    public void setTpTipo(int tpTipo) {
        this.tpTipo = tpTipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public int getUsuarioCrea() {
        return usuarioCrea;
    }

    public void setUsuarioCrea(int usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
    }

    public int getUsuarioModifica() {
        return usuarioModifica;
    }

    public void setUsuarioModifica(int usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", epEmpleado=" + epEmpleado + ", tpTipo=" + tpTipo + ", usuario=" + usuario + ", clave=" + clave + ", fechaModificacion=" + fechaModificacion + ", usuarioCrea=" + usuarioCrea + ", usuarioModifica=" + usuarioModifica + ", fechaCreacion=" + fechaCreacion + '}';
    }
     
     
}
