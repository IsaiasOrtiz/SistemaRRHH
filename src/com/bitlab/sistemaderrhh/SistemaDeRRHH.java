/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.sistemaderrhh;

import com.bitlab.dao.EmpleadosDAO;
import com.bitlab.entidades.Empleados;
import com.bitlab.utilidades.Encryptacion;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author elcon
 */
public class SistemaDeRRHH {

    private static Logger log = LoggerFactory.getLogger(SistemaDeRRHH.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Encryptacion en = new Encryptacion();

        EmpleadosDAO da = new EmpleadosDAO();
        Empleados em = new Empleados();

        GregorianCalendar gc = new GregorianCalendar();
        gc.set(GregorianCalendar.DATE, 17);
        gc.set(GregorianCalendar.MONTH, 6);
        gc.set(GregorianCalendar.YEAR, 1997);

        Date date = new Date(gc.getTimeInMillis());
        em.setIdEmploye(100);
        em.setBirthDate(new Date(gc.getTimeInMillis()));
        em.setFirstName("Douglas Isaias");
        em.setLastName("Valle Ortiz");
        em.setGender("M");
        em.setHireDate(new Date(gc.getTimeInMillis()));

        try {
           
//            da.sqlInsert(em);
            em = da.obtenerUnDatoPorId(100);
            em.setFirstName("Juan Antonio");
            em.setLastName("el weyyy");
            da.sqlUpdate(em);
            System.out.println(em.toString());

//            Empleados enp=da.obtenerUnDatoPorId(1003);
//            if(enp!=null)
//                System.out.println(enp.toString());
//            else
//                System.out.println("No se encontraron registros");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(SistemaDeRRHH.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SistemaDeRRHH.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(SistemaDeRRHH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
