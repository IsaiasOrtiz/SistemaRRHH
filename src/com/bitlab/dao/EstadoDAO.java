/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.dao;

import com.bitlab.entidades.Estado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class EstadoDAO extends AbstractDAO<Estado> {

    @Override
    protected String obtenerTablaDeBD() {
        return "SRH_ES_ESTADO";
    }

    @Override
    protected String[] obtenerCamposDeTabla() {
        String[] campos = {
            "ES_ID",
            "ES_NOMBRE",
            "A_FECHA_CREACION",
            "A_FECHA_MODIFICACION",
            "A_USUARIO_MODIFICA",
            "A_USUARIO_CREA"};
        return campos;
    }

    @Override
    protected Estado mapearEntidad(ResultSet rs) throws SQLException {
        return new Estado(
        rs.getInt("ES_ID"),
        rs.getString("ES_NOMBRE"),
        rs.getDate("A_FECHA_CREACION"),
        rs.getDate("A_FECHA_MODIFICACION"),
        rs.getInt("A_USUARIO_MODIFICA"),
        rs.getInt("A_USUARIO_CREA")
        );
    }

    @Override
    protected String campoClavePK() {
        return "ES_ID";
    }

    @Override
    protected int limiteDeBusquedaEstablecer() {
        return 25;
    }

    @Override
    protected boolean limiteDeBusquedaEncendido() {
        return true;
    }
    //int id, String nombre, Date fechaCreacion, Date fechaModificacion, int usuarioModifica, int usuarioCrea
    @Override
    protected void mapearPreparedStatementInsert(Estado entidad, PreparedStatement ps) throws SQLException {
        ps.setInt(      1, entidad.getId());
        ps.setString(   2, entidad.getNombre());
        ps.setDate(     3, entidad.getFechaCreacion());
        ps.setDate(     4, entidad.getFechaModificacion());
        ps.setInt(      5, entidad.getUsuarioModifica());
        ps.setInt(      6, entidad.getUsuarioCrea());
    }

    @Override
    protected void mapearPrepareStatementUpdate(Estado entidad, PreparedStatement ps) throws SQLException {
        ps.setInt(      1, entidad.getId());
        ps.setString(   2, entidad.getNombre());
        ps.setDate(     3, entidad.getFechaCreacion());
        ps.setDate(     4, entidad.getFechaModificacion());
        ps.setInt(      5, entidad.getUsuarioModifica());
        ps.setInt(      6, entidad.getUsuarioCrea());
        ps.setInt(      7, entidad.getId());
    }

}
