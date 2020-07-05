/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.modulos;

import com.bitlab.modulosopciones.EmpleadoMDL;
import com.bitlab.modulosopciones.PagosMDL;
import com.bitlab.modulosopciones.PlanillaMDL;
import com.bitlab.utilidades.LecturaDatos;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class RecursosHumanos {

    LecturaDatos lr = new LecturaDatos();
    EmpleadoMDL ep=new EmpleadoMDL();
    PlanillaMDL plm=new PlanillaMDL();
    PagosMDL pg=new PagosMDL();
    public void moduloRecursosHumanos(int id)
    {
        System.out.println("1 )Actualización de datos del empleado.");
        System.out.println("2 )Desactivación de empleados por despido.");
        System.out.println("3 )Contratación de empleados");
        System.out.println("4 )Asignación de departamento o jefatura");
        System.out.println("5 )Actualización de salario mensual");
        System.out.println("6 )Visualización de pagos generados");
        System.out.println("7 )Generación de pagos en planilla.");
        System.out.println("8 )Salir.");
        switch(lr.leerOpciones((byte)1, (byte)8))
        {
            case 1:
                ep.actualizarEmpleado(id);
                break;
            case 2:
                ep.desactivarEmpleado(id);
                break;
            case 3: 
                ep.nuevoEmpleado(id);
                break;
            case 4: 
                ep.asignarDepartamento(id);
                break;
            case 5:
                ep.asignarnuevoSalario(id);
                break;
            case 6:
                pg.pagosGenerados();
                break;
            case 7:
                plm.generarPlanilla(id);
                break;
            case 8:
                
                break;
            default:
        
        }
        
    }
    
}
