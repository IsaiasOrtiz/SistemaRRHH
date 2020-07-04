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

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class EstadoCivilMDL {
    EstadoCivilDAO es=new EstadoCivilDAO();
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
        } catch (SQLException ex) {
            Logger.getLogger(EstadoCivilMDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstadoCivilMDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EstadoCivilMDL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
