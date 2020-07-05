/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.modulosopciones;

import com.bitlab.dao.EstadoCivilDAO;
import com.bitlab.entidades.EstadoCivil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class EstadoCivilMDL {
    EstadoCivilDAO es=new EstadoCivilDAO();
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(EstadoCivilMDL.class);
    /**
     * Muestra todos los estados civiles disponibles con 
     * un formato asignado.
     */
    public void estadosCiviles()
    {
        try {
            System.out.println("========ESTADOS CIVILES========");
            for (EstadoCivil e : es.obtenerTodos()) {
                System.out.println("|ID: "+e.getId()+" Nombre: "+e.getNombre());
            }
            System.out.println("===============================");
        } catch (ClassNotFoundException ex) {
            log.error(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            log.error(ex.getMessage());
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
    }
}
