/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.modulosopciones;

import com.bitlab.dao.TipoDAO;
import com.bitlab.entidades.Tipo;
import java.io.IOException;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class TipoDML {
    private final Logger log=LoggerFactory.getLogger(TipoDML.class);
    Tipo tp = new Tipo();
    TipoDAO tpd = new TipoDAO();
    /**
     * Lista los tipos de usuarios disponibles.
     * vista.
     */
    public void tipos() {
        try {

            System.out.println("================TIPOS DE USUARIO DISPONIBLES================");
            for (Tipo t : tpd.obtenerTodos()) {
                System.out.println("|ID: " + t.getId() + " |Nombre: " + t.getNombre());
            }
            System.out.println("============================================================");
        } catch (SQLException ex) {
            ex.printStackTrace();
           log.error(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            log.error(ex.getMessage());
        } catch (IOException ex) {
           log.error(ex.getMessage());
        }

    }
    /**
     * Vefifica si ya existe un dato con ese ID
     * @param id
     * @return 
     */
    public boolean verificar(byte id)
    {
        boolean verificacion=false;
        try {
            verificacion=tpd.datoExiste(id);
        } catch (ClassNotFoundException ex) {
            log.error(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            log.error(ex.getMessage());
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
        return verificacion;
    }
}
