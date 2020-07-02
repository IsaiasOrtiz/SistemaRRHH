/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.dao;

import com.bitlab.entidades.Salario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class SalarioDAO extends AbstractDAO<Salario>{

    @Override
    protected String obtenerTablaDeBD() {
        return "SRH_SL_SALARIO";
    }

    @Override
    protected String[] obtenerCamposDeTabla() {
        String[] campos={"SL_ID","SL_SALARIO","A_USUARIO_MODIFICA","A_FECHA_MODIFICACION","A_USUARIO_CREA","A_FECHA_CREACION"};
        return campos;
    }
    
    @Override
    protected Salario mapearEntidad(ResultSet rs) throws SQLException {
        return new Salario(
                rs.getInt(      "SL_ID"),
                rs.getDouble(   "SL_SALARIO"),
                rs.getInt(      "A_USUARIO_MODIFICA"),
                rs.getDate(     "A_FECHA_MODIFICACION"),
                rs.getInt(      "A_USUARIO_CREA"),
                rs.getDate(     "A_FECHA_CREACION"));
    }

    @Override
    protected String campoClavePK() {
        return "SL_ID";
    }

    @Override
    protected int limiteDeBusquedaEstablecer() {
        return 25;
    }

    @Override
    protected boolean limiteDeBusquedaEncendido() {
       return true;
    }
    //"SL_ID","SL_SALARIO","A_USUARIO_MODIFICA","A_FECHA_MODIFICACION","A_USUARIO_CREA","A_FECHA_CREACION"
    @Override
    protected void mapearPreparedStatementInsert(Salario entidad, PreparedStatement ps) throws SQLException {
       ps.setInt(       1, entidad.getId());
       ps.setDouble(    2, entidad.getSalario());
       ps.setInt(       3, entidad.getUsuarioModifica());
       ps.setDate(      4, entidad.getFechaModificacion());
       ps.setInt(       5, entidad.getUsuarioCrea());
       ps.setDate(      6, entidad.getFechaCreacion());
    }

    @Override
    protected void mapearPrepareStatementUpdate(Salario entidad, PreparedStatement ps) throws SQLException {
       ps.setInt(       1, entidad.getId());
       ps.setDouble(    2, entidad.getSalario());
       ps.setInt(       3, entidad.getUsuarioModifica());
       ps.setDate(      4, entidad.getFechaModificacion());
       ps.setInt(       5, entidad.getUsuarioCrea());
       ps.setDate(      6, entidad.getFechaCreacion());
       ps.setInt(       7, entidad.getId());
    }
    
}
