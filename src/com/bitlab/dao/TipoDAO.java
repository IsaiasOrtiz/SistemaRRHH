/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.dao;

import com.bitlab.entidades.Tipo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class TipoDAO extends AbstractDAO<Tipo> {

    @Override
    protected String obtenerTablaDeBD() {
        return "SRH_TP_TIPO";
    }

    @Override
    protected String[] obtenerCamposDeTabla() {
        String[] campos={
            "TP_ID",
            "TP_NOMBRE",
            "A_USUARIO_MODIFICA",
            "A_USUARIO_CREA",
            "A_FECHA_MODIFICACION",
            "A_FECHA_CREACION"};
        return campos;
    }
    //int id, String nombre, int usuarioModifica, int usuarioCrea, Date fechaModificacion, Date fechaCreacion
    @Override
    protected Tipo mapearEntidad(ResultSet rs) throws SQLException {
        return new Tipo(
                rs.getInt("TP_ID"),
                rs.getString("TP_NOMBRE"),
                rs.getInt("A_USUARIO_MODIFICA"),
                rs.getInt("A_USUARIO_CREA"),
                rs.getDate("A_FECHA_MODIFICACION"),
                rs.getDate("A_FECHA_CREACION"));
    }

    @Override
    protected String campoClavePK() {
        return "TP_ID";
    }

    @Override
    protected int limiteDeBusquedaEstablecer() {
        return 10;
    }

    @Override
    protected boolean limiteDeBusquedaEncendido() {
        return true;
    }
    /*
            "TP_ID",
            "TP_NOMBRE",
            "A_USUARIO_MODIFICA",
            "A_USUARIO_CREA",
            "A_FECHA_MODIFICACION",
            "A_FECHA_CREACION"
    */
    @Override
    protected void mapearPreparedStatementInsert(Tipo entidad, PreparedStatement ps) throws SQLException {
        ps.setInt(      1, entidad.getId());
        ps.setString(   2, entidad.getNombre());
        ps.setInt(      3, entidad.getUsuarioModifica());
        ps.setInt(      4, entidad.getUsuarioCrea());
        ps.setDate(     5,entidad.getFechaModificacion());
        ps.setDate(     6, entidad.getFechaCreacion());
    }

    @Override
    protected void mapearPrepareStatementUpdate(Tipo entidad, PreparedStatement ps) throws SQLException {
        ps.setInt(      1, entidad.getId());
        ps.setString(   2, entidad.getNombre());
        ps.setInt(      3, entidad.getUsuarioModifica());
        ps.setInt(      4, entidad.getUsuarioCrea());
        ps.setDate(     5,entidad.getFechaModificacion());
        ps.setDate(     6, entidad.getFechaCreacion());
        ps.setInt(      7, entidad.getId());
    }
    
}
