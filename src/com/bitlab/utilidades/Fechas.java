/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.utilidades;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class Fechas {
    GregorianCalendar gc = new GregorianCalendar();
    Scanner sc = new Scanner(System.in);
    /**
     * Leemos una fecha desde teclado 
     * pidiendo al usuario ingresar 
     * Dia,mes,año 
     * para luego retornarla como un DATE
     * @return 
     */
    public Date agregarFecha() {
        byte dia = 100;
        byte mes = 100;
        short ano = 1;
        boolean flag = true;
        while (flag) {
            try {
                System.out.println("Ingrese el dia:");
                dia = Byte.parseByte(sc.nextLine());
                System.out.println("Ingrese el mes:");
                mes = Byte.parseByte(sc.nextLine());
                System.out.println("Ingrese el año:");
                ano = Short.parseShort(sc.nextLine());
                if (!(dia > 0 && dia < 32)) {
                    System.out.println("Al parecer el dia no esta en el rango permitido...(1-31)");
                } else {
                    flag = false;
                }
                if (!(mes > 0 && mes < 13)) {
                    System.out.println("Al parecer el mes no esta en el rango permitido...(1-12)");
                } else {
                    flag = false;
                }
                if (!(ano > 0 && ano < 2050)) {
                    System.out.println("Al parecer el mes no esta en el rango permitido...(1-12)");
                } else {
                    flag = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Al parecer el formato de fechas que esta tratando de ingresar es invalido.");
            }
        }
        gc.set(GregorianCalendar.DATE, dia);
        gc.set(GregorianCalendar.MONTH, (mes - 1));
        gc.set(GregorianCalendar.YEAR, ano);
        return new Date(gc.getTimeInMillis());
    }
    /**
     * Obtenemos la fecha actual del sistema.
     * @return 
     */
    public Date fechaActual()
    {
        Calendar calendar = Calendar.getInstance();
        return new Date(calendar.getTimeInMillis());
    }
    
}
