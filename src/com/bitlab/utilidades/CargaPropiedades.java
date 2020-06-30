/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.utilidades;

import com.bitlab.propiedades.Propiedades;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class CargaPropiedades {
    private final String PROPIEDADES="config2.properties";
    /**
     * Este metodo retorna un Array 
     * String que contiene las propiedades de conexion
     * @return
     * @throws IOException 
     * String[0]="url"
     * String[1]="usuario"
     * String[2]="clave"
     * String[3]="driver"
     */
    public String[] getPropiedadesConfig2() throws IOException
    {
        Properties pro=new Properties();
        pro.load(Propiedades.flujoDeDatos(PROPIEDADES));
        Encryptacion en=new Encryptacion();
        String[] propiedades=new String[4];
        propiedades[0]=(en.getDesencryptacion(pro.getProperty("lur")));
        propiedades[1]=(en.getDesencryptacion(pro.getProperty("urs")));
        propiedades[2]=(en.getDesencryptacion(pro.getProperty("crs")));
        propiedades[3]=(en.getDesencryptacion(pro.getProperty("br")));
        return propiedades;
    }
}
