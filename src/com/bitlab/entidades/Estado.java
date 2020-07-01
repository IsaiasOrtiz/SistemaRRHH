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
public class Estado {
     private int id;
     private String nombre;
     private Date fechaCreacion;
     private Date fechaModificacion;
     private int usuarioModifica;
     private int usuarioCrea;

    public Estado() {
    }

    public Estado(int id, String nombre, Date fechaCreacion, Date fechaModificacion, int usuarioModifica, int usuarioCrea) {
        this.id = id;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuarioModifica = usuarioModifica;
        this.usuarioCrea = usuarioCrea;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public int getUsuarioModifica() {
        return usuarioModifica;
    }

    public void setUsuarioModifica(int usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
    }

    public int getUsuarioCrea() {
        return usuarioCrea;
    }

    public void setUsuarioCrea(int usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
    }

    @Override
    public String toString() {
        return "Estado{" + "id=" + id + ", nombre=" + nombre + ", fechaCreacion=" + fechaCreacion + ", fechaModificacion=" + fechaModificacion + ", usuarioModifica=" + usuarioModifica + ", usuarioCrea=" + usuarioCrea + '}';
    }
    
     
     
}
