/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.dao;

import com.bitlab.entidades.EstadoCivil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class EstadoCivilDAO extends AbstractDAO<EstadoCivil> {

    @Override
    protected String obtenerTablaDeBD() {
        return "SRH_EC_ESTADO_CIVIL";
    }

    @Override
    protected String[] obtenerCamposDeTabla() {
        String[] campos = {
            "EC_ID",
            "EC_NOMBRE",
            "A_USUARIO_MODIFICA",
            "A_FECHA_MODIFICACION",
            "A_USUARIO_CREA",
            "A_FECHA_CREACION"};
        return campos;
    }
    //int id, String nombre, int usuarioModifica, Date fechaModificacion, int usuarioCrea, Date fechaCreacion

    @Override
    protected EstadoCivil mapearEntidad(ResultSet rs) throws SQLException {
        return new EstadoCivil(
                rs.getInt("EC_ID"),
                rs.getString("EC_NOMBRE"),
                rs.getInt("A_USUARIO_MODIFICA"),
                rs.getDate("A_FECHA_MODIFICACION"),
                rs.getInt("A_USUARIO_CREA"),
                rs.getDate("A_FECHA_CREACION")
        );

    }

    @Override
    protected String campoClavePK() {
        return "EC_ID";
    }

    @Override
    protected int limiteDeBusquedaEstablecer() {
        return 25;
    }

    @Override
    protected boolean limiteDeBusquedaEncendido() {
        return false;
    }
    @Override
    protected void mapearPreparedStatementInsert(EstadoCivil entidad, PreparedStatement ps) throws SQLException {
        ps.setInt(      1, entidad.getId());
        ps.setString(   2, entidad.getNombre());
        ps.setInt(      3, entidad.getUsuarioModifica());
        ps.setDate(     4, entidad.getFechaModificacion());
        ps.setInt(      5, entidad.getUsuarioCrea());
        ps.setDate(     6, entidad.getFechaCreacion());
    }

    @Override
    protected void mapearPrepareStatementUpdate(EstadoCivil entidad, PreparedStatement ps) throws SQLException {
        ps.setInt(      1, entidad.getId());
        ps.setString(   2, entidad.getNombre());
        ps.setInt(      3, entidad.getUsuarioModifica());
        ps.setDate(     4, entidad.getFechaModificacion());
        ps.setInt(      5, entidad.getUsuarioCrea());
        ps.setDate(     6, entidad.getFechaCreacion());
        ps.setInt(      7, entidad.getId());
    }

}
