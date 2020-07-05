/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.modulosopciones;

import com.bitlab.dao.EmpleadoDAO;
import com.bitlab.dao.PagosDAO;
import com.bitlab.entidades.Empleado;
import com.bitlab.entidades.Pagos;
import com.bitlab.utilidades.Planilla;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class PagosMDL {
    EmpleadoDAO em=new EmpleadoDAO();
    PagosDAO pg=new PagosDAO();
    Planilla pl=new Planilla();
   
    public void pagosGenerados() 
    {
        HashMap<Integer ,String> empleado =new HashMap<Integer, String>();
        empleado.clear();
        try {
            for (Empleado ot : em.obtenerTodos()) {
                empleado.put(ot.getId(), "Empleado : "+ot.getNombres()+" "+ot.getApellidos());
            }
            for (Pagos ob : pg.obtenerTodos()) {
                System.out.println("=================================================");
                System.out.println("ID del pago : "+ob.getId());
                System.out.println(empleado.get(ob.getId()));
                System.out.println("Fecha del pago : "+ob.getFechaPago());
                System.out.println("Monto : "+ob.getMonto());
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PagosMDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PagosMDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PagosMDL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
