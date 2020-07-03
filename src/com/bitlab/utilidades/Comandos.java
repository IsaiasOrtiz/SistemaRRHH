/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.utilidades;

import java.io.IOException;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class Comandos {

    public void limpiarPantalla() {
        try {
            if ((System.getProperty("os.name").toUpperCase()).contains("WIN")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException ioe) {
            
        }
    }
}
