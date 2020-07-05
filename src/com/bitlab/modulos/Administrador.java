/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.modulos;

import com.bitlab.modulosopciones.DepartamentosMDL;
import com.bitlab.modulosopciones.EstadoMDL;
import com.bitlab.modulosopciones.UsuarioMDL;
import com.bitlab.utilidades.Comandos;
import com.bitlab.utilidades.LecturaDatos;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class Administrador {

    LecturaDatos lr = new LecturaDatos();
    DepartamentosMDL dp = new DepartamentosMDL();
    EstadoMDL es=new EstadoMDL();
    UsuarioMDL us=new UsuarioMDL();
    Comandos comandos=new Comandos();

    public void modulo(String nombre, int id) {
        boolean flag = true;
        System.out.println("Hola [" + nombre + "] Administrador.\n");
        while (flag) {
            
            System.out.println("============Opciones============");
            System.out.println("1 )Gestión de departamentos.");
            System.out.println("2 )Gestión de estados de empleados.");
            System.out.println("3 )Gestión de usuarios");
            System.out.println("4 )Gestión de Roles");
            System.out.println("5 )Salir");
            System.out.println("================================");

            switch (lr.leerOpciones((byte) 1, (byte) 5)) {
                case 1:
                    dp.moduloDepartamentos(id);
                    comandos.limpiarPantalla();
                    break;
                case 2:
                    es.moduloEstado(id);
                    comandos.limpiarPantalla();
                    break;
                case 3:
                    us.usuariosModulo(id);
                    comandos.limpiarPantalla();
                    break;
                case 4:
                    us.cambiarRol(id);
                     try {
                            Thread.sleep(3000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(EstadoMDL.class.getName()).log(Level.SEVERE, null, ex);
                        }
                     comandos.limpiarPantalla();
                    break;
                case 5:
                    comandos.limpiarPantalla();
                    System.out.println("Gracias por usar el sistema :D");
                    flag=false;
                    break;
                default:
            }
        }

    }

}
