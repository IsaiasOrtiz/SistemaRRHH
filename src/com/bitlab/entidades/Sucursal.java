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
public class Sucursal {

    private int id;
    private String nombre;
    private Date fechaModificacion;
    private int usuarioModifica;
    private Date fechaCreacion;
    private int usuarioCrea;

    public Sucursal() {
    }

    public Sucursal(int id, String nombre, Date fechaModificacion, int usuarioModifica, Date fechaCreacion, int usuarioCrea) {
        this.id = id;
        this.nombre = nombre;
        this.fechaModificacion = fechaModificacion;
        this.usuarioModifica = usuarioModifica;
        this.fechaCreacion = fechaCreacion;
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getUsuarioCrea() {
        return usuarioCrea;
    }

    public void setUsuarioCrea(int usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
    }

    @Override
    public String toString() {
        return "Sucursal{" + "id=" + id + ", nombre=" + nombre + ", fechaModificacion=" + fechaModificacion + ", usuarioModifica=" + usuarioModifica + ", fechaCreacion=" + fechaCreacion + ", usuarioCrea=" + usuarioCrea + '}';
    }
    
    
}
