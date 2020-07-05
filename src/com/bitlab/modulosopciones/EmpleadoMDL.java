/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.modulosopciones;

import com.bitlab.dao.EmpleadoDAO;
import com.bitlab.dao.EstadoDAO;
import com.bitlab.dao.SalarioDAO;
import com.bitlab.dao.SexoDAO;
import com.bitlab.entidades.Empleado;
import com.bitlab.entidades.Estado;
import com.bitlab.entidades.Salario;
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
    SexoDAO sx = new SexoDAO();
    EstadoDAO es = new EstadoDAO();
    EstadoCivilMDL ecivil = new EstadoCivilMDL();
    SalarioDAO sl = new SalarioDAO();
    DepartamentosMDL dp = new DepartamentosMDL();

    public void nuevoEmpleado(int id) {
        try {
            Empleado ep = new Empleado();
            System.out.println("Usted ingresara un nuevo empleado.");
            ep.setId(lr.leerEntero("Id del empleado."));
            ep.setNombres(lr.leerCadenaDeTexto("nombres empleado"));
            ep.setApellidos(lr.leerCadenaDeTexto("apellidos empleado"));
            ep.setDireccion("direccion empleado");
            System.out.println("Ingrese la fecha de nacimiento:");
            ep.setFechaNacimiento(fc.agregarFecha());
            ep.setDui("DUI empleado.");
            ecivil.estadosCiviles();
            ep.setEcEstadoCivil(lr.leerByte("Estado civil"));
            sx.sexosConformato();
            ep.setSxSexo(lr.leerByte("sexo del empleado"));
            dp.verDepartamentos();
            ep.setDpArea(lr.leerByte("Departamento del empleado."));
            ep.setSlSalario(0);
            ep.setEsEstado(1);
            ep.setFechaCreacion(fc.fechaActual());
            ep.setFechaModificacion(fc.fechaActual());
            ep.setUsuarioCrea(id);
            ep.setUsuarioModifica(id);
            if (esd.obtenerUnDatoPorId(ep.getId()) == null) {
                System.out.println("Seguro que quiere registrar al empleado");
                if (lr.siOno(ep)) {
                    esd.sqlInsert(ep);
                }
            }
            System.out.println("Los empleados se crean con el salario minimo por defecto");
            System.out.println("Para cambiarlo cree un nuevo empleado y asignelo al empleado.");
            System.out.println("Empleado creado.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpleadoMDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoMDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EmpleadoMDL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void desactivarEmpleado(int id) {
        try {
            Empleado ep = new Empleado();
            ep.setId(lr.leerEntero("Id del empleado a despedir."));
            ep = esd.obtenerUnDatoPorId(ep.getId());
            if (ep == null) {
                System.out.println("Este empleado no existe.");
            } else {
                System.out.println("Seguro que quiere despedir al empleado.?");
                if (lr.siOno(ep)) {
                    ep.setEsEstado(3);
                    ep.setUsuarioModifica(id);
                    ep.setFechaModificacion(fc.fechaActual());
                    esd.sqlUpdate(ep);
                    System.out.println("Se cambio el estado a Despedido.");
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpleadoMDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoMDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EmpleadoMDL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cambiarEstadoDeEmpleado(int id) {

        try {

            int ide = lr.leerEntero("Id empleado que quiere modificar el estado");
            Empleado ep = esd.obtenerUnDatoPorId(ide);
            if (ep != null) {
                System.out.println("Empleado al que modificara.");
                System.out.println(ep.getNombres() + " " + ep.getNombres() + " Estado: " + ep.getEsEstado());
                System.out.println("Cambiar estado del empleado.");
                estados();
                byte idEstado = lr.leerByte("Id Nuevo Estado ");
                ep.setEsEstado(idEstado);
                ep.setFechaModificacion(fc.fechaActual());
                ep.setUsuarioModifica(id);
                esd.sqlUpdate(ep);
                System.out.println("Se modifico el estado a : " + idEstado);
            } else {
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

    public void actualizarEmpleado(int id) {
        try {

            int ide = lr.leerEntero("Id empleado que quiere modificar el estado");
            Empleado ep = esd.obtenerUnDatoPorId(ide);
            if (ep != null) {
                System.out.println("Empleado al que modificara.");
                System.out.println(ep.getNombres() + " " + ep.getNombres() + " Estado: " + ep.getEsEstado());
                ep.setNombres("Ingrese el nombre");
                ep.setApellidos("Ingrese los apellidos");
                ep.setDui("Ingrese el DUI");
                sx.sexosConformato();
                ep.setSxSexo(lr.leerByte("sexo"));
                ep.setFechaModificacion(fc.fechaActual());
                ep.setUsuarioModifica(id);
                esd.sqlUpdate(ep);
                System.out.println("Se modifico el empleado");
            } else {
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

    public void estados() {
        try {
            System.out.println("=================ESTADOS DISPONIBLES=================");
            for (Estado e : es.obtenerTodos()) {
                System.out.println("ID: " + e.getId() + "|" + e.getNombre());
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoMDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpleadoMDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EmpleadoMDL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void asignarDepartamento(int id) {

        try {

            int ide = lr.leerEntero("Id empleado que quiere modificar el estado");
            Empleado ep = esd.obtenerUnDatoPorId(ide);
            if (ep != null) {
                System.out.println("Empleado al que modificara.");
                System.out.println(ep.getNombres() + " " + ep.getNombres() + " Estado: " + ep.getEsEstado());
                System.out.println("Seleccione el departamento");
                dp.verDepartamentos();

                ep.setFechaModificacion(fc.fechaActual());
                ep.setUsuarioModifica(id);
                System.out.println("Seguro que quiere cambiar de departamentos.");
                if (lr.siOno(ep)) {
                    esd.sqlUpdate(ep);

                    System.out.println("Se modifico el departamento");
                }
            } else {
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

    public void verSalarioEmpleado() {
        try {
            int ide = lr.leerEntero("Id empleado del que quiere ver el salario.");
            Empleado ep = esd.obtenerUnDatoPorId(ide);
            if (ep != null) {

                Salario sla = sl.obtenerUnDaCampoEspecifico(ep.getSlSalario(), "SL_ID");
                System.out.println("===============SALARIO DEL EMPLEDO " + ep.getId() + "=============");
                System.out.println("El empleado : " + ep.getNombres() + " " + ep.getApellidos());
                System.out.println("Tiene un sueldo de : $" + sla.getSalario());
                System.out.println("====================================================");
            } else {

                System.out.println("El empleado no existe.");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpleadoMDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoMDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EmpleadoMDL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void asignarnuevoSalario(int id) {
        try {
            Salario sal = new Salario();
            int ide = lr.leerEntero("Id empleado del que quiere actualizar el salario");
            Empleado ep = esd.obtenerUnDatoPorId(ide);
            if (ep != null) {
                System.out.println(ep.toString());
                System.out.println("ID del nuevo salario :");
                sal.setId(lr.leerEntero("Id nuevo salario"));
                sal.setSalario(lr.leerDouble("Nuevo salario"));
                sal.setFechaModificacion(fc.fechaActual());
                sal.setFechaCreacion(fc.fechaActual());
                sal.setUsuarioModifica(id);
                sal.setUsuarioCrea(id);
                sl.sqlInsert(sal);
                System.out.println("Se modificara el salario del empleado");
                ep.setSlSalario(sal.getId());
                esd.sqlUpdate(ep);
                System.out.println("Se actualizo el salario del empleado.");
            }
        } catch (ClassNotFoundException ex) {
            log.error(ex.getMessage());
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }

        }

//    public static void main(String[] args) {
//        EmpleadoMDL e=new EmpleadoMDL();
//        e.cambiarEstadoDeEmpleado(0);
//    }
    }
