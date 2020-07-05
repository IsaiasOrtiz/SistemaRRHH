/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.dao;

import com.bitlab.entidades.Usuario;
import com.bitlab.utilidades.Encryptacion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class LoginDAO extends AbstractDAO<Usuario>{
    public Usuario obtenerUnDatoPorId(String usuario, String clave) {
        try {
            String sqlObtenerUno = sqlSelectConsulta();
            sqlObtenerUno = sqlObtenerUno.replace(TABLA_INDICADOR, obtenerTablaDeBD());
            sqlObtenerUno = sqlObtenerUno.replace(CAMPOS_INDICADOR, Arrays.toString(obtenerCamposDeTabla()));
            sqlObtenerUno = (sqlObtenerUno.replace("[", "")).replace("]", "");
            Connection cn = abrirConexionDB();
            PreparedStatement ps=cn.prepareStatement(sqlObtenerUno);
            ps.setString(1, usuario);
            Encryptacion en=new Encryptacion();
           
            boolean flag=false;
            ResultSet rs = ps.executeQuery();
           
            if (rs.next()) {
                if(en.getDesencryptacion(rs.getString("US_CLAVE")).equals(clave))
                {
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
                
                
            }
            cerrarObjetosJDBC(cn, ps, rs);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

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
    
    @Override
    protected String sqlSelectConsulta() {
        String nuevoSql = SQL_SELECT;
        nuevoSql = nuevoSql.replace(TABLA_INDICADOR, obtenerTablaDeBD());
        nuevoSql = nuevoSql.replace(CAMPOS_INDICADOR, Arrays.toString(obtenerCamposDeTabla()));
        nuevoSql = (nuevoSql.replace("[", "")).replace("]", "");
        nuevoSql = nuevoSql+" WHERE US_USUARIO = ? ";
        return nuevoSql;
    }
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
        return 1;
    }

    @Override
    protected boolean limiteDeBusquedaEncendido() {
        return true;
    }
   
    @Override
    protected void mapearPreparedStatementInsert(Usuario entidad, PreparedStatement ps) throws SQLException {
     
    }

    @Override
    protected void mapearPrepareStatementUpdate(Usuario entidad, PreparedStatement ps) throws SQLException {
       
    }
    
}
