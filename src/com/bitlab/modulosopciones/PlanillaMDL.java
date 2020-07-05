/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.modulosopciones;

import com.bitlab.dao.EmpleadoDAO;
import com.bitlab.dao.PagosDAO;
import com.bitlab.dao.SalarioDAO;
import com.bitlab.entidades.Empleado;
import com.bitlab.entidades.Pagos;
import com.bitlab.entidades.Salario;
import com.bitlab.utilidades.Fechas;
import com.bitlab.utilidades.LecturaDatos;
import com.bitlab.utilidades.Planilla;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class PlanillaMDL {

    EmpleadoDAO ep = new EmpleadoDAO();
    SalarioDAO sl = new SalarioDAO();
    Planilla pl = new Planilla();
    Fechas fc = new Fechas();
    LecturaDatos lr = new LecturaDatos();
    PagosDAO pgd = new PagosDAO();

    public void generarPlanilla(int idu) {
        try {
            Empleado emp = new Empleado();
            Pagos pagos = new Pagos();
            HashMap<Integer, Double> salarios = new HashMap<Integer, Double>();
            HashMap<Integer, Date> fechasPagos = new HashMap<Integer, Date>();
            salarios.clear();
            fechasPagos.clear();

            boolean pagomes = true;
            Date fecha = fc.fechaActual();
            for (Pagos p : pgd.obtenerTodos()) {
                if (fecha.getMonth() == p.getFechaPago().getMonth() && fecha.getYear() == p.getFechaPago().getYear()) {
                    pagomes = false;
                }
            }
            for (Salario o : sl.obtenerTodos()) {

                salarios.put(o.getId(), o.getSalario());
            }

            List<Empleado> empleados = new ArrayList<Empleado>();
            empleados.clear();
            for (Empleado em2 : ep.obtenerTodos()) {
                empleados.add(em2);
                System.out.println("================================================");
                System.out.println("Empleado: " + em2.getNombres() + " " + em2.getApellidos());
                System.out.println("Direccion: " + em2.getDireccion());
                System.out.println("DUI: " + em2.getDui());
                System.out.println("SALARIO: " + (salarios.get(em2.getSlSalario())));
                System.out.println(pl.resumenSalario(salarios.get(em2.getSlSalario())));
                System.out.println("Fecha: " + fc.fechaActual());
                System.out.println("================================================");
            }
            System.out.println("¿Quiere generar el pago de esta planilla?");
            if (lr.siOno()) {
                if (pagomes) {
                    for (Empleado lo : empleados) {

                        Pagos pg = new Pagos();
                        pg.setFechaPago(fc.fechaActual());
                        pg.setIdEmpleado(lo.getId());
                        pg.setMonto(pl.sueldoNeto((salarios.get(lo.getSlSalario()))));
                        pg.setFechaCreacion(fc.fechaActual());
                        pg.setFechaModificacion(fc.fechaActual());
                        pg.setUsuarioCrea(idu);
                        pg.setUsuarioModifica(idu);
                        pgd.sqlInsert(pg);
                    }
                    empleados.clear();
                }else{
                    System.out.println("Ya se hicieron los pagos de este mes.");
                }

            } else {
                empleados.clear();
            }

        } catch (SQLException ex) {
            Logger.getLogger(PlanillaMDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PlanillaMDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PlanillaMDL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
