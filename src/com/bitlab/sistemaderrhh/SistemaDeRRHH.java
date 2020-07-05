/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.sistemaderrhh;

import com.bitlab.dao.LoginDAO;
import com.bitlab.entidades.Usuario;
import com.bitlab.modulos.Administrador;
import com.bitlab.modulos.RecursosHumanos;
import com.bitlab.utilidades.LecturaDatos;
import com.bitlab.utilidades.Mensajes;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class SistemaDeRRHH {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String usuario;
        String clave;
        LecturaDatos lr = new LecturaDatos();
        LoginDAO lg = new LoginDAO();
        int random = (int) (Math.random() * 1000000 + 100000);
        int intentos = 0;
        boolean flag = true;
        while (flag) {

            System.out.println("Ingrese el usuario:");
            usuario = lr.leerCadenaDeTexto();
            System.out.println("Ingrese la clave:");
            clave = lr.leerCadenaDeTexto();
            Usuario us = lg.obtenerUnDatoPorId(usuario, clave);
            if (us != null) {
                Mensajes mj = new Mensajes();
                mj.enviarMensaje("Codigo de verificacion.", "RH" + random, usuario);
                System.out.println("Ingrese el codigo de verificacion enviado a su correo electronico:");
                if (lr.leerCadenaDeTexto().equals("RH" + random)) {
                    if (us.getTpTipo() == 0) {
                        Administrador ad = new Administrador();
                        ad.modulo(us.getUsuario(), us.getId());
                        flag = false;
                    } else if (us.getTpTipo() == 1) {
                        RecursosHumanos ru = new RecursosHumanos();
                        ru.moduloRecursosHumanos(us.getId());
                        flag = false;
                    }
                    
                } else {
                    System.out.println("CODIGO DE VERIFICACION INVALIDO.");
                    System.exit(0);
                }
                
            } else {
                intentos++;
                if (intentos == 4) {
                    System.out.println("Supero el limite de intentos permitidos....");
                    System.exit(intentos);
                }
                System.out.println("Clave o usuario invalido.");
                System.out.println("=====================================");
            }

//        ad.modulo("Douglas", 0);
        }
        
    }
    
}
