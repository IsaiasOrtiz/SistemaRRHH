/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.dao;

import com.bitlab.entidades.HistorialEmpleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class HistorialEmpleadoDAO extends AbstractDAO<HistorialEmpleado>{

    @Override
    protected String obtenerTablaDeBD() {
        return "SRH_HTP_HISTORIAL_EMPLEADO";
    }

    @Override
    protected String[] obtenerCamposDeTabla() {
        String [] campos={"HTP_ID","HTP_DESCRIPCION","EP_ID","A_USUARIO_MODIFICA","A_USUARIO_CREA","A_FECHA_MODIFICACION","A_FECHA_CREACION"};
       return campos;
    }
    //int id, int empleado, String descripcion, int usuarioModifica, int usuarioCrea, 
    //Date fechaModificacion, Date fechaCreacion
    @Override
    protected HistorialEmpleado mapearEntidad(ResultSet rs) throws SQLException {
       return new HistorialEmpleado(
               rs.getInt("HTP_ID"),
               rs.getInt("EP_ID"),
               rs.getString("HTP_DESCRIPCION"),
               rs.getInt("A_USUARIO_MODIFICA"),
               rs.getInt("A_USUARIO_CREA"),
               rs.getDate("A_FECHA_MODIFICACION"),
               rs.getDate("A_FECHA_CREACION")
       );
    }

    @Override
    protected String campoClavePK() {
       return "HTP_ID";
    }

    @Override
    protected int limiteDeBusquedaEstablecer() {
       return 25;
    }

    @Override
    protected boolean limiteDeBusquedaEncendido() {
        return false;
    }
 //{"HTP_ID","HTP_DESCRIPCION","EP_ID","A_USUARIO_MODIFICA","A_USUARIO_CREA","A_FECHA_MODIFICACION","A_FECHA_CREACION"}
    @Override
    protected void mapearPreparedStatementInsert(HistorialEmpleado entidad, PreparedStatement ps) throws SQLException {
        ps.setInt(      1, entidad.getId());
        ps.setString(   2, entidad.getDescripcion());
        ps.setInt(      3, entidad.getEmpleado());
        ps.setInt(      4, entidad.getUsuarioModifica());
        ps.setInt(      5, entidad.getUsuarioCrea());
        ps.setDate(     6, entidad.getFechaModificacion());
        ps.setDate(     7, entidad.getFechaCreacion());
    }

    @Override
    protected void mapearPrepareStatementUpdate(HistorialEmpleado entidad, PreparedStatement ps) throws SQLException {
        ps.setInt(      1, entidad.getId());
        ps.setString(   2, entidad.getDescripcion());
        ps.setInt(      3, entidad.getEmpleado());
        ps.setInt(      4, entidad.getUsuarioModifica());
        ps.setInt(      5, entidad.getUsuarioCrea());
        ps.setDate(     6, entidad.getFechaModificacion());
        ps.setDate(     7, entidad.getFechaCreacion());
        ps.setInt(      8, entidad.getId());
    }
    
}
