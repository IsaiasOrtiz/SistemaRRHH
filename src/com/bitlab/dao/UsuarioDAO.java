/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.dao;

import com.bitlab.entidades.Usuario;
import com.bitlab.utilidades.Encryptacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class UsuarioDAO extends AbstractDAO<Usuario> {

    @Override
    protected String obtenerTablaDeBD() {
        return "SRH_US_USUARIO";
    }

    @Override
    protected String[] obtenerCamposDeTabla() {
        String[] campos={
            "US_ID",
            "US_USUARIO",
            "US_CLAVE",
            "A_FECHA_MODIFICACION",
            "A_USUARIO_CREA",
            "A_USUARIO_MODIFICA",
            "A_FECHA_CREACION",
            "EP_ID",
            "TP_ID"};
        return campos;
    }
    //int id, int epEmpleado, int tpTipo, String usuario, String clave, Date fechaModificacion, 
    //int usuarioCrea, int usuarioModifica, Date fechaCreacion
    @Override
    protected Usuario mapearEntidad(ResultSet rs) throws SQLException {
        return new Usuario(
                rs.getInt("US_ID"),
                rs.getInt("EP_ID"),
                rs.getInt("TP_ID"),
                rs.getString("US_USUARIO"),
                rs.getString("US_CLAVE"),
                rs.getDate("A_FECHA_MODIFICACION"),
                rs.getInt("A_USUARIO_CREA"),
                rs.getInt("A_USUARIO_MODIFICA"),
                rs.getDate("A_FECHA_CREACION"));
    }
    @Override
    protected String campoClavePK() {
        return "US_ID";
    }

    @Override
    protected int limiteDeBusquedaEstablecer() {
        return 500;
    }

    @Override
    protected boolean limiteDeBusquedaEncendido() {
        return true;
    }
   
    @Override
    protected void mapearPreparedStatementInsert(Usuario entidad, PreparedStatement ps) throws SQLException {
        Encryptacion en=new Encryptacion();
        String clave=en.getDesencryptacion(entidad.getClave());
        String usuario=en.getDesencryptacion(entidad.getUsuario());
        
        ps.setInt(      1, entidad.getId());
        ps.setString(   2, usuario);
        ps.setString(   3, clave);
        ps.setDate(     4, entidad.getFechaModificacion());
        ps.setInt(      5,entidad.getUsuarioCrea());
        ps.setInt(      6, entidad.getUsuarioModifica());
        ps.setDate(     7, entidad.getFechaCreacion());
        ps.setInt(      8, entidad.getEpEmpleado());
        ps.setInt(      9, entidad.getTpTipo());
    }

    @Override
    protected void mapearPrepareStatementUpdate(Usuario entidad, PreparedStatement ps) throws SQLException {
        ps.setInt(      1, entidad.getId());
        ps.setString(   2, entidad.getUsuario());
        ps.setString(   3, entidad.getClave());
        ps.setDate(     4, entidad.getFechaModificacion());
        ps.setInt(      5,entidad.getUsuarioCrea());
        ps.setInt(      6, entidad.getUsuarioModifica());
        ps.setDate(     7, entidad.getFechaCreacion());
        ps.setInt(      8, entidad.getEpEmpleado());
        ps.setInt(      9, entidad.getTpTipo());
    }
    
}
