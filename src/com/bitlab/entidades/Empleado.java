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
public class Empleado {
     private int id;
     private int dpArea;
     private int ecEstadoCivil;
     private int esEstado;
     private int slSalario;
     private int sxSexo;
     private String nombres;
     private String apellidos;
     private String direccion;
     private Date fechaNacimiento;
     private String dui;
     private Integer usuarioModifica;
     private Integer usuarioCrea;
     private Date fechaCreacion;
     private Date fechaModificacion;

    public Empleado() {
    }

    public Empleado(int id, int dpArea, int ecEstadoCivil, int esEstado, int slSalario, int sxSexo, String nombres, String apellidos, String direccion, Date fechaNacimiento, String dui, Integer usuarioModifica, Integer usuarioCrea, Date fechaCreacion, Date fechaModificacion) {
        this.id = id;
        this.dpArea = dpArea;
        this.ecEstadoCivil = ecEstadoCivil;
        this.esEstado = esEstado;
        this.slSalario = slSalario;
        this.sxSexo = sxSexo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.dui = dui;
        this.usuarioModifica = usuarioModifica;
        this.usuarioCrea = usuarioCrea;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDpArea() {
        return dpArea;
    }

    public void setDpArea(int dpArea) {
        this.dpArea = dpArea;
    }

    public int getEcEstadoCivil() {
        return ecEstadoCivil;
    }

    public void setEcEstadoCivil(int ecEstadoCivil) {
        this.ecEstadoCivil = ecEstadoCivil;
    }

    public int getEsEstado() {
        return esEstado;
    }

    public void setEsEstado(int esEstado) {
        this.esEstado = esEstado;
    }

    public int getSlSalario() {
        return slSalario;
    }

    public void setSlSalario(int slSalario) {
        this.slSalario = slSalario;
    }

    public int getSxSexo() {
        return sxSexo;
    }

    public void setSxSexo(int sxSexo) {
        this.sxSexo = sxSexo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public Integer getUsuarioModifica() {
        return usuarioModifica;
    }

    public void setUsuarioModifica(Integer usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
    }

    public Integer getUsuarioCrea() {
        return usuarioCrea;
    }

    public void setUsuarioCrea(Integer usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
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

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", dpArea=" + dpArea + ", ecEstadoCivil=" + ecEstadoCivil + ", esEstado=" + esEstado + ", slSalario=" + slSalario + ", sxSexo=" + sxSexo + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion + ", fechaNacimiento=" + fechaNacimiento + ", dui=" + dui + ", usuarioModifica=" + usuarioModifica + ", usuarioCrea=" + usuarioCrea + ", fechaCreacion=" + fechaCreacion + ", fechaModificacion=" + fechaModificacion + '}';
    }
    
    
 
}
