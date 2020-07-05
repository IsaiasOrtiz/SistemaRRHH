/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.modulosopciones;

import com.bitlab.dao.DepartamentoDAO;
import com.bitlab.dao.EstadoDAO;
import com.bitlab.entidades.Departamento;
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
public class DepartamentosMDL {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(DepartamentosMDL.class);
    Scanner sc = new Scanner(System.in);
    DepartamentoDAO dp = new DepartamentoDAO();
    LecturaDatos lr = new LecturaDatos();
    Fechas fc = new Fechas();
    EstadoDAO esd = new EstadoDAO();
    /**
     * Es como un frontend para crear un nuevo departamento 
     * recibe como parametro el usuario que registro  el nuevo departamento
     * @param idUsuario 
     */
    public void crearNuevoDepartamento(int idUsuario) {
        Departamento area = new Departamento();
        area.setId(lr.leerEntero("ID del departamento"));
        area.setNombre(lr.leerCadenaDeTexto("Nombre del departamento"));
        area.setScID(lr.leerEntero("ID de la sucursal"));
        area.setFechaCreacion(fc.fechaActual());
        area.setFechaModificacion(fc.fechaActual());
        area.setUsuarioCrea(idUsuario);
        area.setUsuarioModifica(idUsuario);
        System.out.println("Usted esta apunto de crear el departamento.");
        try {
            if (lr.siOno(area)) {
                dp.sqlInsert(area);
                System.out.println("Se creo el departamento.");
            }
        } catch (ClassNotFoundException ex) {
            log.error(ex.getMessage());
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            log.error(ex.getMessage());
            System.out.println("Al parecer ocurrio un error con la base de datos...");
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
    }
    /**
     * Fronted donde eliminamos un demartamento.
     * consulta si el departamento existe.
     * y controla las exepxciones y las registra 
     * en un log
     */
    public void eliminarDapartamento() {
        try {
            int idDp = lr.leerEntero("Id departamento a eliminar");
            System.out.println("Esta a punto de eliminnar el Departamento: \n" + dp.obtenerUnDatoPorId(idDp).toString());
            System.out.println("Esta seguro??");
            if (lr.siOno(log)) {
                dp.sqlDelete(idDp);
                System.out.println("Se elimino el registro...");
            } else {
                System.out.println("No se elimino el registro");
            }
        } catch (ClassNotFoundException ex) {
            log.error(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
            log.error(ex.getMessage());
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
    }
    /**
     * Vista para modificar un departamento 
     * recibe como paraetro el usuario que modifica el departamento.
     * @param idU 
     */
    public void modificarDepartamento(int idU) {
        try {
            int id = lr.leerEntero("Id departamento a modificar");
            Departamento ar2 = dp.obtenerUnDatoPorId(id);
            if (ar2 != null) {
                System.out.println("Nuevo nombre del departamento....");
                ar2.setNombre(lr.leerCadenaDeTexto("Departamento"));
                ar2.setUsuarioModifica(idU);
                ar2.setFechaModificacion(fc.fechaActual());
                System.out.println("Esta a modificando el usuario..");
                if (lr.siOno(ar2)) {
                    dp.sqlUpdate(ar2);
                }

            } else {
                System.out.println("No se encontro departamento con el ID : " + id);
            }
        } catch (ClassNotFoundException ex) {
            log.error(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Ocurrio un error con la base de datos : " + ex.getMessage());
            log.error(ex.getMessage());
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }

    }
    /**
     * Lista los departamentos 
     * con un formato mas vistoso.
     */
    public void verDepartamentos() {
        try {
            for (Departamento obtenerTodo : dp.obtenerTodos()) {
                System.out.println("==============Departamento===========");
                System.out.println("Id : " + obtenerTodo.getId());
                System.out.println("Nombre : " + obtenerTodo.getNombre());
            }
        } catch (ClassNotFoundException ex) {
            log.error(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Ocurrio un error con la base de datos : " + ex.getMessage());
            log.error(ex.getMessage());
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
    }
    /**
     * Genera todo el modulo para la administracion de departamentos
     * y brinda las opciones al usuario.
     * recibe el id del usuario de la sision
     * @param id 
     */
    public void moduloDepartamentos(int id) {
        boolean flag = true;
        while (flag) {
            System.out.println("===========Opciones departamentos===========\n");
            System.out.println("1 )Crear nuevo departamento.");
            System.out.println("2 )Ver departamentos");
            System.out.println("3 )Modificar un departamento");
            System.out.println("4 )Eliminar un departamento");
            System.out.println("5 )salir");
            System.out.println("============================================");
            switch (lr.leerOpciones((byte) 1, (byte) 5)) {
                case 1:
                    crearNuevoDepartamento(id);
                    break;
                case 2:
                    verDepartamentos();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(EstadoMDL.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 3:
                    modificarDepartamento(id);
                    break;
                case 4:
                    eliminarDapartamento();
                    break;
                case 5:
                    flag = false;
                    System.out.println("Volvera al menu principal.");
                    break;
                default:
            }
        }

    }
}
