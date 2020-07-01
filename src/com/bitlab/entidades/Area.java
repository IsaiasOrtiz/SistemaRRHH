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
public class Area {
    
     private int id;
     private int scID;
     private String nombre;
     private int usuarioCrea;
     private Date fechaModificacion;
     private Date fechaCreacion;
     private int usuarioModifica;

    public Area() {
    }

    public Area(int id, int scID, String nombre, int usuarioCrea, Date fechaModificacion, Date fechaCreacion, int usuarioModifica) {
        this.id = id;
        this.scID = scID;
        this.nombre = nombre;
        this.usuarioCrea = usuarioCrea;
        this.fechaModificacion = fechaModificacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModifica = usuarioModifica;
    }
     
     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScID() {
        return scID;
    }

    public void setScID(int scID) {
        this.scID = scID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getUsuarioModifica() {
        return usuarioModifica;
    }

    public void setUsuarioModifica(int usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
    }

    @Override
    public String toString() {
        return "Area{" + "id=" + id + ", scID=" + scID + ", nombre=" + nombre + ", usuarioCrea=" + usuarioCrea + ", fechaModificacion=" + fechaModificacion + ", fechaCreacion=" + fechaCreacion + ", usuarioModifica=" + usuarioModifica + '}';
    }


   
 
}
