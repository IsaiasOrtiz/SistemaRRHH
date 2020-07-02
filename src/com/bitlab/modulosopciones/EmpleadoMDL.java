/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.modulosopciones;

import com.bitlab.dao.EmpleadoDAO;
import com.bitlab.dao.EstadoDAO;
import com.bitlab.entidades.Empleado;
import com.bitlab.entidades.Estado;
import com.bitlab.utilidades.Fechas;
import com.bitlab.utilidades.LecturaDatos;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class EmpleadoMDL {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(EmpleadoMDL.class);
    Scanner sc = new Scanner(System.in);
    LecturaDatos lr = new LecturaDatos();
    Fechas fc = new Fechas();
    EmpleadoDAO esd = new EmpleadoDAO();
    EstadoDAO es=new EstadoDAO();
   public void cambiarEstadoDeEmpleado(int id)
   {
       
        try {
           
            int ide=lr.leerEntero("Id empleado que quiere modificar el estado");
            Empleado ep=esd.obtenerUnDatoPorId(ide);
            if(ep!=null){
            System.out.println("Empleado al que modificara.");
            System.out.println(ep.getNombres()+" "+ep.getNombres()+" Estado: "+ep.getEsEstado());
            System.out.println("Cambiar estado del empleado.");
            estados();
             byte idEstado=lr.leerByte("Id Nuevo Estado ");
             ep.setEsEstado(idEstado);
             ep.setFechaModificacion(fc.fechaActual());
             ep.setUsuarioModifica(id);
             esd.sqlUpdate(ep);
                System.out.println("Se modifico el estado a : " +idEstado);
            }else{
                System.out.println("No se encontro el empleado...");
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpleadoMDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoMDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EmpleadoMDL.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
   }
   public void estados()
   {
        try {
            System.out.println("=================ESTADOS DISPONIBLES=================");
            for (Estado e : es.obtenerTodos()) {
                System.out.println("ID: "+e.getId() + "|"+e.getNombre());
            }} catch (SQLException ex) {
            Logger.getLogger(EmpleadoMDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpleadoMDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EmpleadoMDL.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
    public static void main(String[] args) {
        EmpleadoMDL e=new EmpleadoMDL();
        e.cambiarEstadoDeEmpleado(0);
    }
}
