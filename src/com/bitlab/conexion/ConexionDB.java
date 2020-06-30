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
/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class ConexionDB {
    /**
     * Establece la conexion con el servidor de base de datos 
     * configurado en el archivo de propiedades
     * y lanzo las exepciones para que sean controladas
     * y registradas en un log.
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException 
     */
    public static Connection abrirConexion() throws ClassNotFoundException, SQLException, IOException
    {
        CargaPropiedades cp=new CargaPropiedades();
        String[] pro=cp.getPropiedadesConfig2();
        Class.forName(pro[3]);
        return DriverManager.getConnection(pro[0], pro[1], pro[2]);
    }
    /**
     * Cierra la conexion a la base de datos.
     * @param con
     * @throws SQLException 
     */
    public static void cerrarConexion(Connection con) throws SQLException
    {
        if(con != null && !con.isClosed())
            con.close();
    }
}
