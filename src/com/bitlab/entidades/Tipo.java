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
public class Tipo {
     private int id;
     private String nombre;
     private int usuarioModifica;
     private int usuarioCrea;
     private Date fechaModificacion;
     private Date fechaCreacion;

    public Tipo(int id, String nombre, int usuarioModifica, int usuarioCrea, Date fechaModificacion, Date fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.usuarioModifica = usuarioModifica;
        this.usuarioCrea = usuarioCrea;
        this.fechaModificacion = fechaModificacion;
        this.fechaCreacion = fechaCreacion;
    }

    public Tipo() {
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

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "Tipo{" + "id=" + id + ", nombre=" + nombre + ", usuarioModifica=" + usuarioModifica + ", usuarioCrea=" + usuarioCrea + ", fechaModificacion=" + fechaModificacion + ", fechaCreacion=" + fechaCreacion + '}';
    }
     
     
}
