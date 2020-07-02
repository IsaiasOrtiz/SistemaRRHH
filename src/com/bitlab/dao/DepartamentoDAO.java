/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.dao;

import com.bitlab.entidades.Departamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class DepartamentoDAO extends AbstractDAO<Departamento>{

    @Override
    protected String obtenerTablaDeBD() {
        return "SRH_DP_AREA";
    }

    @Override
    protected String[] obtenerCamposDeTabla() {
       String[] campos={"DP_ID","DP_NOMBRE","SC_ID","A_USUARIO_CREA","A_FECHA_MODIFICACION","A_FECHA_CREACION","A_USUARIO_MODIFICA"};
       return campos; 
    }
    //int id, int scID, String nombre, Integer usuarioCrea, Date fechaModificacion, Date fechaCreacion, Integer usuarioModifica
    @Override
    protected Departamento mapearEntidad(ResultSet rs) throws SQLException {
       return new Departamento(
               rs.getInt("DP_ID"),
               rs.getInt("SC_ID"),
               rs.getString("DP_NOMBRE"),
               rs.getInt("A_USUARIO_CREA"),
               rs.getDate("A_FECHA_MODIFICACION"),
               rs.getDate("A_FECHA_CREACION"),
               rs.getInt("A_USUARIO_MODIFICA"));
    }

    @Override
    protected String campoClavePK() {
        return "DP_ID"; 
    }

    @Override
    protected int limiteDeBusquedaEstablecer() {
        return 25;
    }

    @Override
    protected boolean limiteDeBusquedaEncendido() {
        return true;
    }
    //"DP_ID","DP_NOMBRE","SC_ID","A_USUARIO_CREA","A_FECHA_MODIFICACION","A_FECHA_CREACION","A_USUARIO_MODIFICA"
    @Override
    protected void mapearPreparedStatementInsert(Departamento entidad, PreparedStatement ps) throws SQLException {
       ps.setInt(       1, entidad.getId());
       ps.setString(    2,entidad.getNombre());
       ps.setInt(       3, entidad.getScID());
       ps.setInt(       4, entidad.getUsuarioCrea());
       ps.setDate(      5, entidad.getFechaModificacion());
       ps.setDate(      6, entidad.getFechaCreacion());
       ps.setInt(       7, entidad.getUsuarioModifica());
    }

    @Override
    protected void mapearPrepareStatementUpdate(Departamento entidad, PreparedStatement ps) throws SQLException {
       ps.setInt(       1, entidad.getId());
       ps.setString(    2,entidad.getNombre());
       ps.setInt(       3, entidad.getScID());
       ps.setInt(       4, entidad.getUsuarioCrea());
       ps.setDate(      5, entidad.getFechaModificacion());
       ps.setDate(      6, entidad.getFechaCreacion());
       ps.setInt(       7, entidad.getUsuarioModifica());
       ps.setInt(       8, entidad.getId());
    }
    
}
