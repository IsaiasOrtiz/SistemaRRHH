/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.dao;

import com.bitlab.entidades.Pagos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class PagosDAO extends AbstractDAO<Pagos> {

    @Override
    protected String obtenerTablaDeBD() {
        return "SRH_PG_PAGOS";
    }

    @Override
    protected String[] obtenerCamposDeTabla() {
       String[] str={
           "PG_ID",
           "PG_FECHA",
           "EP_ID",
           "PG_MONTO",
           "A_FECHA_CREACION",
           "A_USUARIO_MODIFICA",
           "A_FECHA_MODIFICACION",
           "A_USUARIO_CREA"}; 
       return str;
    }

    @Override
    protected Pagos mapearEntidad(ResultSet rs) throws SQLException {
       return new Pagos(
               rs.getInt("PG_ID"),
               rs.getDate("PG_FECHA"),
               rs.getInt("EP_ID"),
               rs.getDouble("PG_MONTO"),
               rs.getInt("A_USUARIO_MODIFICA"),
               rs.getDate("A_FECHA_MODIFICACION"),
               rs.getInt("A_USUARIO_CREA"),
               rs.getDate("A_FECHA_CREACION"));
    }
    

    @Override
    protected String campoClavePK() {
        return "PG_ID";
    }

    @Override
    protected int limiteDeBusquedaEstablecer() {
        return 1000;
    }

    @Override
    protected boolean limiteDeBusquedaEncendido() {
    return true;
    }
/*
           "PG_ID",
           "PG_FECHA",
           "EP_ID",
           "PG_MONTO",
           "A_FECHA_CREACION",
           "A_USUARIO_MODIFICA",
           "A_FECHA_MODIFICACION",
           "A_USUARIO_CREA"
    */
    @Override
    protected void mapearPreparedStatementInsert(Pagos entidad, PreparedStatement ps) throws SQLException {
        ps.setNull(     1, java.sql.Types.INTEGER);
        ps.setDate(     2, entidad.getFechaPago());
        ps.setInt(      3, entidad.getIdEmpleado());
        ps.setDouble(   4, entidad.getMonto());
        ps.setDate(     5, entidad.getFechaCreacion());
        ps.setInt(      6, entidad.getUsuarioModifica());
        ps.setDate(     7, entidad.getFechaCreacion());
        ps.setInt(      8, entidad.getUsuarioCrea());
    }

    @Override
    protected void mapearPrepareStatementUpdate(Pagos entidad, PreparedStatement ps) throws SQLException {
        ps.setInt(     1, entidad.getId());
        ps.setDate(     2, entidad.getFechaPago());
        ps.setInt(      3, entidad.getIdEmpleado());
        ps.setDouble(   4, entidad.getMonto());
        ps.setDate(     5, entidad.getFechaCreacion());
        ps.setInt(      6, entidad.getUsuarioModifica());
        ps.setDate(     7, entidad.getFechaCreacion());
        ps.setInt(      8, entidad.getUsuarioCrea());
        ps.setInt(     9, entidad.getId());
    }
    
}
