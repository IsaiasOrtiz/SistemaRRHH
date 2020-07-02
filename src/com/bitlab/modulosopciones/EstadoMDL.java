/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.modulosopciones;

import com.bitlab.dao.EstadoDAO;
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
public class EstadoMDL {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(EstadoMDL.class);
    Scanner sc = new Scanner(System.in);
    LecturaDatos lr = new LecturaDatos();
    Fechas fc = new Fechas();
    EstadoDAO esd = new EstadoDAO();

    public void nuevoEstadoEmpleado(int id) {
        Estado es = new Estado();
        es.setId(lr.leerEntero("Id estado de empleado"));
        es.setNombre(lr.leerCadenaDeTexto("Nombre del estado"));
        es.setFechaCreacion(fc.fechaActual());
        es.setFechaModificacion(fc.fechaActual());
        es.setUsuarioCrea(id);
        es.setUsuarioModifica(id);
        System.out.println("Creara el estado..");
        if (lr.siOno(es)) {
            try {
                esd.sqlInsert(es);
            } catch (ClassNotFoundException ex) {
                log.error(ex.getMessage());
            } catch (SQLException ex) {
                System.out.println("Ocurrio un error con la base de datos : " + ex.getMessage());
                log.error(ex.getMessage());
            } catch (IOException ex) {
                log.error(ex.getMessage());
            }
        }
    }

    public void modificarUnEstado(int idu) {
        try {
            System.out.println("Modificara un estado..");
            int id = lr.leerEntero("Id del estado a modificar");
            Estado esd2 = esd.obtenerUnDatoPorId(id);
            if (esd2 != null) {
                esd2.setNombre(lr.leerCadenaDeTexto("Nuevo nombre"));
                esd2.setUsuarioModifica(idu);
                esd2.setFechaModificacion(fc.fechaActual());
                System.out.println("Seguro que quiere modificar?:");
                if(lr.siOno(esd2))
                {
                esd.sqlUpdate(esd2);
                }else{
                    System.out.println("No se modifico");
                }
                
            }else{
                System.out.println("No se encontro un estado con ese ID.");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstadoMDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EstadoMDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EstadoMDL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void consultarEstados()
    {
        try {
            for (Estado e : esd.obtenerTodos()) {
                System.out.println("=================Estados=================");
                System.out.println("ID: "+e.getId());
                System.out.println("Nombre: "+e.getNombre());
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstadoMDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstadoMDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EstadoMDL.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
