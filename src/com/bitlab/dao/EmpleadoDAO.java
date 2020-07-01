/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.dao;

import com.bitlab.entidades.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class EmpleadoDAO extends AbstractDAO<Empleado> {

    @Override
    protected String obtenerTablaDeBD() {
        return "SRH_EP_EMPLEADO";
    }

    @Override
    protected String[] obtenerCamposDeTabla() {
        String[] campos = {
            "EP_ID",
            "EP_NOMBRES",
            "EP_APELLIDOS",
            "EP_DIRECCION",
            "EP_FECHA_NACIMIENTO",
            "EP_DUI",
            "EC_ID",
            "SX_ID",
            "DP_ID",
            "SL_ID",
            "ES_ID",
            "A_USUARIO_MODIFICA",
            "A_USUARIO_CREA",
            "A_FECHA_CREACION",
            "A_FECHA_MODIFICACION"};
        return campos;
    }

    @Override
    protected Empleado mapearEntidad(ResultSet rs) throws SQLException {
        return new Empleado(
                rs.getInt("EP_ID"),
                rs.getInt("DP_ID"),
                rs.getInt("EC_ID"),
                rs.getInt("ES_ID"),
                rs.getInt("SL_ID"),
                rs.getInt("SX_ID"),
                rs.getString("EP_NOMBRES"),
                rs.getString("EP_APELLIDOS"),
                rs.getString("EP_DIRECCION"),
                rs.getDate("EP_FECHA_NACIMIENTO"),
                rs.getString("EP_DUI"),
                rs.getInt("A_USUARIO_MODIFICA"),
                rs.getInt("A_USUARIO_CREA"),
                rs.getDate("A_FECHA_CREACION"),
                rs.getDate("A_FECHA_MODIFICACION"));
    }

    @Override
    protected String campoClavePK() {
        return "EP_ID";
    }

    @Override
    protected int limiteDeBusquedaEstablecer() {
        return 25;
    }

    @Override
    protected boolean limiteDeBusquedaEncendido() {
        return true;
    }
    @Override
    protected void mapearPreparedStatementInsert(Empleado entidad, PreparedStatement ps) throws SQLException {
       ps.setInt(           1, entidad.getId());
       ps.setString(        2, entidad.getNombres());
       ps.setString(        3, entidad.getApellidos());
       ps.setString(        4, entidad.getDireccion());
       ps.setDate(          5, entidad.getFechaNacimiento());
       ps.setString(        6, entidad.getDui());
       ps.setInt(           7, entidad.getEcEstadoCivil());
       ps.setInt(           8, entidad.getSxSexo());
       ps.setInt(           9, entidad.getDpArea());
       ps.setInt(           10, entidad.getSlSalario());
       ps.setInt(           11,entidad.getEsEstado());
       ps.setInt(           12, entidad.getUsuarioModifica());
       ps.setInt(           13, entidad.getUsuarioCrea());
       ps.setDate(          14, entidad.getFechaCreacion());
       ps.setDate(          15, entidad.getFechaModificacion());
    }

    @Override
    protected void mapearPrepareStatementUpdate(Empleado entidad, PreparedStatement ps) throws SQLException {
       ps.setInt(           1, entidad.getId());
       ps.setString(        2, entidad.getNombres());
       ps.setString(        3, entidad.getApellidos());
       ps.setString(        4, entidad.getDireccion());
       ps.setDate(          5, entidad.getFechaNacimiento());
       ps.setString(        6, entidad.getDui());
       ps.setInt(           7, entidad.getEcEstadoCivil());
       ps.setInt(           8, entidad.getSxSexo());
       ps.setInt(           9, entidad.getDpArea());
       ps.setInt(           10, entidad.getSlSalario());
       ps.setInt(           11,entidad.getEsEstado());
       ps.setInt(           12, entidad.getUsuarioModifica());
       ps.setInt(           13, entidad.getUsuarioCrea());
       ps.setDate(          14, entidad.getFechaCreacion());
       ps.setDate(          15, entidad.getFechaModificacion());
       ps.setInt(           16, entidad.getId());
    }

}
