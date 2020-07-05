/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.conexion;

import com.bitlab.utilidades.CargaPropiedades;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class ConexionDB {

    private static final ConexionDB main = new ConexionDB();
    private BasicDataSource basicDataSource;
    /**
     * Configurando el pol de conexiones.
     */
    private ConexionDB() {
        try {
            CargaPropiedades cp = new CargaPropiedades();
            String[] pro = cp.getPropiedadesConfig2();
            basicDataSource = new BasicDataSource();
            basicDataSource.setDriverClassName(pro[3]);
            basicDataSource.setUsername(pro[1]);
            basicDataSource.setPassword(pro[2]);
            basicDataSource.setUrl(pro[0]);
            basicDataSource.setInitialSize(2);
            basicDataSource.setMaxTotal(10);
        } catch (IOException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ConexionDB obtenerInstancia() {
        return main;
    }

    /**
     * Establece la conexion con el servidor de base de datos configurado en el
     * archivo de propiedades y lanzo las exepciones para que sean controladas y
     * registradas en un log.
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException
     */
    public Connection abrirConexion() throws ClassNotFoundException, SQLException, IOException {
        return basicDataSource.getConnection();
    }

    /**
     * Cierra la conexion a la base de datos.
     *
     * @param con
     * @throws SQLException
     */
    public static void cerrarConexion(Connection con) throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
}
