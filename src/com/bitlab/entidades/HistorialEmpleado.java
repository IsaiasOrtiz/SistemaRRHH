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
public class HistorialEmpleado {
     private int id;
     private int empleado;
     private String descripcion;
     private int usuarioModifica;
     private int usuarioCrea;
     private Date fechaModificacion;
     private Date fechaCreacion;

    public HistorialEmpleado() {
    }

    public HistorialEmpleado(int id, int empleado, String descripcion, int usuarioModifica, int usuarioCrea, Date fechaModificacion, Date fechaCreacion) {
        this.id = id;
        this.empleado = empleado;
        this.descripcion = descripcion;
        this.usuarioModifica = usuarioModifica;
        this.usuarioCrea = usuarioCrea;
        this.fechaModificacion = fechaModificacion;
        this.fechaCreacion = fechaCreacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpleado() {
        return empleado;
    }

    public void setEmpleado(int empleado) {
        this.empleado = empleado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
}
