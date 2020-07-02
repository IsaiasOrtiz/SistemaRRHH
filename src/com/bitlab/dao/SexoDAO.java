/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.dao;

import com.bitlab.entidades.Sexo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class SexoDAO extends AbstractDAO<Sexo>{

    @Override
    protected String obtenerTablaDeBD() {
        return "SRH_SX_SEXO";
    }

    @Override
    protected String[] obtenerCamposDeTabla() {
        String[] campos={
            "SX_ID",
            "SX_NOMBRE",
            "A_USUARIO_MODIFICA",
            "A_FECHA_MODIFICACION",
            "A_USUARIO_CREA",
            "A_FECHA_CREACION"};
       return campos;
    }
    
    @Override
    protected Sexo mapearEntidad(ResultSet rs) throws SQLException {
        return new Sexo(
                rs.getInt("SX_ID"),
                rs.getString("SX_NOMBRE"),
                rs.getInt("A_USUARIO_MODIFICA"),
                rs.getDate("A_FECHA_MODIFICACION"),
                rs.getInt("A_USUARIO_CREA"),
                rs.getDate("A_FECHA_CREACION"));
    }

    @Override
    protected String campoClavePK() {
        return "SX_ID";
    }

    @Override
    protected int limiteDeBusquedaEstablecer() {
        return 10;
    }

    @Override
    protected boolean limiteDeBusquedaEncendido() {
        return true;
    }
    @Override
    protected void mapearPreparedStatementInsert(Sexo entidad, PreparedStatement ps) throws SQLException {
        ps.setInt(      1, entidad.getId());
        ps.setString(   2, entidad.getNombre());
        ps.setInt(      3, entidad.getUsuarioModifica());
        ps.setDate(     4, entidad.getFechaModificacion());
        ps.setInt(      5, entidad.getUsuarioCrea());
        ps.setDate(     6, entidad.getFechaCreacion());
    }

    @Override
    protected void mapearPrepareStatementUpdate(Sexo entidad, PreparedStatement ps) throws SQLException {
        ps.setInt(      1, entidad.getId());
        ps.setString(   2, entidad.getNombre());
        ps.setInt(      3, entidad.getUsuarioModifica());
        ps.setDate(     4, entidad.getFechaModificacion());
        ps.setInt(      5, entidad.getUsuarioCrea());
        ps.setDate(     6, entidad.getFechaCreacion());
        ps.setInt(      7, entidad.getId());
    }
    
}
