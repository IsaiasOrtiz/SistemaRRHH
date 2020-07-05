/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.utilidades;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class LecturaDatos {

    public static final String ANSI_RESET = "\u001B[0m";
    GregorianCalendar gc = new GregorianCalendar();
    Scanner sc = new Scanner(System.in);

    public Date leerFecha() {
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

    public String leerCadenaDeTexto(String nombreCampo) {
        String nombre = "";
        boolean flag = true;
        while (flag) {

            System.out.println("Ingrese el nombre del " + nombreCampo + " que quiere registrar:");
            nombre = sc.nextLine();
            if (nombre.isEmpty()) {
                System.out.println("No puede dejar el " + nombreCampo + " vacio!");
            } else if (nombre.length() < 3) {
                System.out.println("El " + nombreCampo + " no puede tener solo 2 caracteres.");
            } else {
                flag = false;
            }
        }
        return nombre;
    }

    public int leerEntero(String nombre) {

        int id = 0;
        boolean flag = true;
        while (flag) {
            try {
                System.out.println("Ingrese el " + nombre);
                id = Short.parseShort(sc.nextLine());
                if (id < 0) {
                    System.out.println("No ingresar numeros menores a 0");
                } else {
                    flag = false;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Ups, al parecer el  " + nombre + " que intenta ingresar no esta en un formato valido..");
                System.out.println("Intente nuevamente.\n");
            }
        }
        return id;
    }

    public double leerDouble(String nombre) {

        double decimalDato = 0;
        boolean flag = true;
        while (flag) {
            try {
                System.out.println("Ingrese el " + nombre);
                decimalDato = Short.parseShort(sc.nextLine());
                if (decimalDato < 0) {
                    System.out.println("No ingresar numeros menores a 0");
                } else {
                    flag = false;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Ups, al parecer el  " + nombre + " que intenta ingresar no esta en un formato valido..");
                System.out.println("Intente nuevamente.\n");
            }
        }
        return decimalDato;
    }

    public byte leerByte(String nombre) {

        byte byteD = 0;
        boolean flag = true;
        while (flag) {
            try {
                System.out.println("Ingrese el " + nombre);
                byteD = Byte.parseByte(sc.nextLine());
                if (byteD < 0) {
                    System.out.println(ANSI_RESET + "No ingresar numeros menores a 0" + ANSI_RESET);
                } else {
                    flag = false;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Ups, al parecer el  " + nombre + " que intenta ingresar no esta en un formato valido..");
                System.out.println("Intente nuevamente.\n");
            }
        }
        return byteD;
    }

    public byte leerOpciones(byte inicial, byte fin) {
        boolean flag = true;
        byte numero = 0;
        while (flag) {
            try {
            System.out.println("Seleccione la opcion..");
            numero = Byte.parseByte(sc.nextLine());
            flag = !(numero >= inicial && numero <= fin);
            if (flag) 
                System.out.println("Al parecer no selecciono una opcion valida...");
            } catch (NumberFormatException e) {
                 System.out.println("Al parecer no selecciono una opcion valida...");
            }
            
            
        }
        return numero;
    }  public boolean siOno(Object obj) {
        System.out.println(obj.toString());
        boolean flag = true;
        String dato="";
        while (flag) {
            System.out.println("Opciones = ([Y]-[N]) Yes,No");
            dato=sc.nextLine();
            if(dato.isEmpty())
            {
                System.out.println("Seleccione una opcion...");
            }else if((dato.toUpperCase()).contains("Y")){
                System.out.println("Añadiendo  "+obj.getClass().getSimpleName());
            return true;
            } else if((dato.toUpperCase()).contains("N")){
                System.out.println("No ningun cambio en el "+obj.getClass().getSimpleName());
                return false;
            }
        }
        return false;
    }
    public boolean siOno() {
        boolean flag = true;
        String dato="";
        while (flag) {
            System.out.println("Opciones = ([Y]-[N]) Yes,No");
            dato=sc.nextLine();
            if(dato.isEmpty())
            {
                System.out.println("Seleccione una opcion...");
            }else if((dato.toUpperCase()).contains("Y")){
                
            return true;
            } else if((dato.toUpperCase()).contains("N")){
                System.out.println("No se hara ningun cambio.");
                return false;
            }
        }
        return false;
    }
}
