/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.dao;

import com.bitlab.entidades.Empleados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class EmpleadosDAO extends AbstractDAO<Empleados>{
     
    @Override
    public String obtenerTablaDeBD() {
        return "employees";
    }

    @Override
    public String[] obtenerCamposDeTabla() {
        String[] str={"emp_no","birth_date","first_name","last_name","gender","hire_date"};
        return str;
    }

    @Override
    public Empleados mapearEntidad(ResultSet rs) throws SQLException {
            return new Empleados(
                    rs.getInt("emp_no"),
                    rs.getDate("birth_date"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("gender"),
                    rs.getDate("hire_date"));
    }
    
    @Override
    public String campoClavePK() {
        return "emp_no";
    }

    @Override
    public int limiteDeBusquedaEstablecer() {
        return 100;
    }

    @Override
    public boolean limiteDeBusquedaEncendido() {
        return true;
    }

    @Override
    public void mapearPreparedStatementInsert(Empleados entidad, PreparedStatement ps) throws SQLException {
       ps.setInt(   1,      entidad.getIdEmploye());
       ps.setDate(  2,      entidad.getBirthDate());
       ps.setString(3,      entidad.getFirstName());
       ps.setString(4,      entidad.getLastName());
       ps.setString(5,      entidad.getGender());
       ps.setDate(  6,      entidad.getHireDate());
    }

    @Override
    public void mapearPrepareStatementUpdate(Empleados entidad, PreparedStatement ps) throws SQLException
    {
       ps.setInt(   1,      entidad.getIdEmploye());
       ps.setDate(  2,      entidad.getBirthDate());
       ps.setString(3,      entidad.getFirstName());
       ps.setString(4,      entidad.getLastName());
       ps.setString(5,      entidad.getGender());
       ps.setDate(  6,      entidad.getHireDate());
       ps.setInt(   7,      entidad.getIdEmploye());
    }
}
