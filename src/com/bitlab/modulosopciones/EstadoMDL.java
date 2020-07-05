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
    /**
     * Siverve para crear un nuevo estado para los empleados.
     * para que posteriormente sean usados
     * recibe como parametro el id del usuario que esta 
     * haciendo los cambios.
     * @param id 
     */
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
                System.out.println("Se creo el estado : "+es.getNombre());
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
    /**
     * Sirve para modificar un estado es simplemente la vista como todos
     * los metodos en esta clase 
     * recibe como paramero el id del empleado que esta modificando el estado
     * @param idu 
     */
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
                 System.out.println("Se modifico el estado a: "+esd2.getNombre());
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
    /**
     * Lista los estados de una manera mas vistosa 
     * para el usuario final.
     */
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
    /**
     * Crea mos todo el moduo para la manipulacion de los estados
     * y con esto llamamos a nuestro metodo segun la opcion seleccionada 
     * recibe el id del usuario de la session.
     * @param id 
     */
    public void moduloEstado(int id)
    {
    boolean flag=true;
        while(flag)
        {
            System.out.println("===========Opciones Estados===========\n");
        System.out.println("1 )Crear un nuevo estado.");
        System.out.println("2 )Modificar un estado");
        System.out.println("3 )Lista de estados.");
        System.out.println("4 )salir");
        System.out.println("============================================");
         switch(lr.leerOpciones((byte)1,(byte)4))
        {
            case 1:
                   nuevoEstadoEmpleado(id);
                break;
            case 2:
                    modificarUnEstado(id);
                    System.out.println("Se modifico el estado.");
                break;
            case 3:
                  consultarEstados();
                {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(EstadoMDL.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

            case 4:
                 flag=false;
                 System.out.println("Volvera al menu principal.");
                break;
            default: 
        }
        }
    
    }
}
