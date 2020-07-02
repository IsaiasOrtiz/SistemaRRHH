/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.dao;

import com.bitlab.entidades.Sucursal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class SucursalDAO extends AbstractDAO<Sucursal>{

    @Override
    protected String obtenerTablaDeBD() {
        return "SRH_SC_SUCURSAL";
    }

    @Override
    protected String[] obtenerCamposDeTabla() {
       String[] campos={
           "SC_ID",
           "SC_NOMBRE",
           "A_FECHA_MODIFICACION",
           "A_USUARIO_MODIFICA",
           "A_FECHA_CREACION",
           "A_USUARIO_CREA"};
       return campos;
    }
    //int id, String nombre, Date fechaModificacion, int usuarioModifica, Date fechaCreacion, int usuarioCrea
    @Override
    protected Sucursal mapearEntidad(ResultSet rs) throws SQLException {
        return new Sucursal(
                rs.getInt("SC_ID"),
                rs.getString("SC_NOMBRE"),
                rs.getDate("A_FECHA_MODIFICACION"),
                rs.getInt("A_USUARIO_MODIFICA"),
                rs.getDate("A_FECHA_CREACION"),
                rs.getInt("A_USUARIO_CREA"));
    }
    @Override
    protected String campoClavePK() {
        return "SC_ID";
    }

    @Override
    protected int limiteDeBusquedaEstablecer() {
       return 20;
    }

    @Override
    protected boolean limiteDeBusquedaEncendido() {
        return true;
    }
    @Override
    protected void mapearPreparedStatementInsert(Sucursal entidad, PreparedStatement ps) throws SQLException {
       ps.setInt(       1, entidad.getId());
       ps.setString(    2, entidad.getNombre());
       ps.setDate(      3, entidad.getFechaModificacion());
       ps.setInt(       4, entidad.getUsuarioModifica());
       ps.setDate(      5, entidad.getFechaCreacion());
       ps.setInt(       6, entidad.getUsuarioCrea());
    }

    @Override
    protected void mapearPrepareStatementUpdate(Sucursal entidad, PreparedStatement ps) throws SQLException {
       ps.setInt(       1, entidad.getId());
       ps.setString(    2, entidad.getNombre());
       ps.setDate(      3, entidad.getFechaModificacion());
       ps.setInt(       4, entidad.getUsuarioModifica());
       ps.setDate(      5, entidad.getFechaCreacion());
       ps.setInt(       6, entidad.getUsuarioCrea());
       ps.setInt(       7, entidad.getId());
    }
    
}
