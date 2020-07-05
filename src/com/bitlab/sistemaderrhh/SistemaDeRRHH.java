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
       
            LecturaDatos lr = new LecturaDatos();
            LoginDAO lg = new LoginDAO();
            int random=(int) (Math.random()*1000000+100000);
            System.out.println("RH"+random);
            Usuario us = null;//lg.obtenerUnDatoPorId("douglasvalle89@gmail.com", "Bitlab2020}");
            if (us != null) {
                if(us.getTpTipo()== 0){
                Administrador ad = new Administrador();
                ad.modulo(us.getUsuario(), us.getId());
                }else if(us.getTpTipo()== 1)
                {
                    RecursosHumanos ru = new RecursosHumanos();
                    ru.moduloRecursosHumanos(us.getId());
                }
            }else{
                System.out.println("Clave o usuario invalido.");
            }
           
            
            
//        ad.modulo("Douglas", 0);
       
    }

}
