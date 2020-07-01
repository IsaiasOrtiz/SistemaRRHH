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
public class Salario {
    
     private int id;
     private Double salario;
     private int usuarioModifica;
     private Date fechaModificacion;
     private int usuarioCrea;
     private Date fechaCreacion;

    public Salario() {
    }

    public Salario(int id, Double salario, int usuarioModifica, Date fechaModificacion, int usuarioCrea, Date fechaCreacion) {
        this.id = id;
        this.salario = salario;
        this.usuarioModifica = usuarioModifica;
        this.fechaModificacion = fechaModificacion;
        this.usuarioCrea = usuarioCrea;
        this.fechaCreacion = fechaCreacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public int getUsuarioModifica() {
        return usuarioModifica;
    }

    public void setUsuarioModifica(int usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "Salario{" + "id=" + id + ", salario=" + salario + ", usuarioModifica=" + usuarioModifica + ", fechaModificacion=" + fechaModificacion + ", usuarioCrea=" + usuarioCrea + ", fechaCreacion=" + fechaCreacion + '}';
    }
     
     
}
