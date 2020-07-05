/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.modulosopciones;

import com.bitlab.dao.UsuarioDAO;
import com.bitlab.entidades.Empleado;
import com.bitlab.entidades.Usuario;
import com.bitlab.utilidades.Encryptacion;
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
public class UsuarioMDL {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(UsuarioMDL.class);
    Scanner sc = new Scanner(System.in);
    LecturaDatos lr = new LecturaDatos();
    Fechas fc = new Fechas();
    UsuarioDAO us = new UsuarioDAO();

    TipoDML tp = new TipoDML();
    public static void main(String[] args) {
        UsuarioMDL us=new UsuarioMDL();
        us.crearNuevoUsuario(0);
    }
    public void crearNuevoUsuario(int idU) {
        try {
            Usuario user = new Usuario();
            System.out.println("Usted creara un nuevo usuario: ");
            user.setId(lr.leerEntero("ID del usuario..."));
            System.out.println("Asegurese que el usuario sea un correo electronico valido...");
            user.setUsuario(lr.leerCadenaDeTexto("nombre de usuario"));
            user.setClave(lr.leerCadenaDeTexto("clave de usuario"));
            user.setEpEmpleado(lr.leerEntero("Id del empleado"));
            tp.tipos();
            user.setTpTipo(lr.leerByte("tipo de usuario"));
            user.setFechaModificacion(fc.fechaActual());
            user.setFechaCreacion(fc.fechaActual());
            user.setUsuarioCrea(idU);
            user.setUsuarioModifica(idU);
            if (us.obtenerUnDaCampoEspecifico(user.getUsuario(), "US_USUARIO") == null) {
                System.out.println("Insertara el siguiente usuario.");
                if (lr.siOno(user)) {
                    us.sqlInsert(user);
                    System.out.println("Se creo el usuario..");
                }

            } else {
                System.out.println("Ya existe un usuario con ese nombre.....");
            }
        } catch (ClassNotFoundException ex) {
            log.error(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("El id del empleado que intenta registrar ya existe.");
            log.error(ex.getMessage());
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
    }

    public void cambiarRol(int idU) {

        try {
            System.out.println("Cambiar rol del usuario");
            Usuario user2 = us.obtenerUnDatoPorId(lr.leerEntero("ID del usuario"));
            if (user2 != null) {
                System.out.println("Rol actual [" + user2.getTpTipo() + "] Usuario [" + user2.getUsuario() + "]");
                tp.tipos();
                System.out.println("Seleccione nuevo rol..");
                user2.setTpTipo(lr.leerByte("Tipo de usuario"));
                user2.setUsuarioModifica(idU);
                user2.setFechaModificacion(fc.fechaActual());
                us.sqlUpdate(user2);
                System.out.println("Se actualizo el estado..");
            } else {
                System.out.println("No existe ese usuario.");
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioMDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(UsuarioMDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UsuarioMDL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listaUsuarios() {
        try {

            System.out.println("================USUARIOS DE RRHH================");
            for (Usuario o : us.obtenerTodos()) {
                System.out.println("ID: " + o.getId());
                System.out.println("Usuario: " + o.getUsuario());
                System.out.println("Clave: " + o.getClave());
                System.out.println("Empleado ID: " + o.getEpEmpleado());
                System.out.println("Usuario que lo creo: " + o.getUsuarioCrea());
                System.out.println("Usuario que lo modifico: " + o.getUsuarioModifica());
                System.out.println("Fecha de creacion: " + o.getFechaCreacion());
                System.out.println("Fecha de ultima modificacion: " + o.getFechaModificacion());
                System.out.println("================================================");

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            log.error(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            log.error(ex.getMessage());
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }

    }

    public void modificarUsuario(int id) {
        try {
            System.out.println("|Modificar usuario|");
            Usuario uss = us.obtenerUnDatoPorId(lr.leerEntero("ID usuario"));
            if (uss == null) {
                System.out.println("no existe un usuario con ese ID");
            } else {
                Encryptacion en = new Encryptacion();
                System.out.println("Ingrese la nueva clave");
                uss.setClave(en.getEncryptacion(lr.leerCadenaDeTexto("nueva clave")));
                uss.setFechaModificacion(fc.fechaActual());
                uss.setUsuarioModifica(id);
                System.out.println("Seguro que quiere modificar:");
                if (lr.siOno(uss)) {
                    us.sqlUpdate(uss);
                }

            }
        } catch (ClassNotFoundException ex) {
           log.error(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
           log.error(ex.getMessage());
        } catch (IOException ex) {
           log.error(ex.getMessage());
        }

    }

    public void usuariosModulo(int id) {
        boolean flag = true;
        while (flag) {
            System.out.println("===========Opciones Estados===========\n");
            System.out.println("1 )Crear un nuevo usuario.");
            System.out.println("2 )Ver usuarios");
            System.out.println("3 )modificar usuario.");
            System.out.println("4 )salir");
            System.out.println("============================================");
            switch (lr.leerOpciones((byte) 1, (byte) 4)) {
                case 1:
                    crearNuevoUsuario(id);
                    break;
                case 2:
                    listaUsuarios();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        log.error(ex.getMessage());
                    }
                    break;
                case 3:
                    modificarUsuario(id);
                    break;

                case 4:
                    flag = false;
                    System.out.println("Volvera al menu principal.");
                    break;
                default:
            }
        }

    }

}
