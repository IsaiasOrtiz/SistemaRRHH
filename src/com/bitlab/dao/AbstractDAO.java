/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.dao;

import com.bitlab.conexion.ConexionDB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public abstract class AbstractDAO<T> {
    //Lo que entendi es que cuando heredemos esta clase tenemos que pasarle la entidad.
    //La cual si trabajamos en un DAO empleadosDAO su entidad seria Empleados
    //donde tengo los set y get de cada uno de ellos.

    //Constantes para los ACME de las tablas.
    public final String SQL_SELECT = "SELECT [CAMPOS] FROM [TABLA]";

    public final String TABLA_INDICADOR = "[TABLA]";

    public final String CAMPOS_INDICADOR = "[CAMPOS]";

    public final String SQL_WHERE = " WHERE ";

    public final String SQL_INSERT = "INSERT INTO [TABLA] ([CAMPOS]) VALUES ([VALORES])";

    public final String VALORES_INDICADOR = "[VALORES]";

    public final String SQL_UPDATE = "UPDATE [TABLA] SET [VALORES] WHERE [CONDICION]";

    public final String INDICADOR_CONDICION = "[CONDICION]";

    public final String SQL_DELETE = "DELETE FROM [TABLA] WHERE [CONDICION]";
    //Metodos para conectarme a la bd desde la clase abstracta y poseer los metodos.

    /**
     * Establece la conexion con la base de datos.
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException
     */
    protected Connection abrirConexionDB() throws ClassNotFoundException, SQLException, IOException {
        return ConexionDB.abrirConexion();
    }

    /**
     * Cierra la conexion a de la base de datos.
     *
     * @param cn
     * @throws SQLException
     */
    protected void cerrarConexionDB(Connection cn) throws SQLException {
        if (cn != null && !cn.isClosed()) {
            cn.close();
        }
    }
    //metodos para cerrar los JDBC necesarios.

    /**
     * Cierra los objetos que recibe como parametros. tienes que controlar la
     * Exception.
     *
     * @param cn
     * @param st
     * @throws SQLException
     */
    public void cerrarObjetosJDBC(Connection cn, Statement st) throws SQLException {
        if (st != null && !st.isClosed()) {
            st.close();
        }
        if (cn != null && !cn.isClosed()) {
            cn.close();
        }
    }

    /**
     * Cierra los objetos que recibe como parametros. tienes que controlar la
     * Exception.
     *
     * @param cn
     * @param st
     * @throws SQLException
     */
    public void cerrarObjetosJDBC(Connection cn, PreparedStatement st) throws SQLException {
        if (st != null && !st.isClosed()) {
            st.close();
        }
        if (cn != null && !cn.isClosed()) {
            cn.close();
        }
    }

    /**
     * Cierra los objetos que recibe como parametros. tienes que controlar la
     * Exception.
     *
     * @param cn
     * @param st
     * @param rs
     * @throws SQLException
     */
    public void cerrarObjetosJDBC(Connection cn, Statement st, ResultSet rs) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (st != null && !st.isClosed()) {
            st.close();
        }
        if (cn != null && !cn.isClosed()) {
            cn.close();
        }
    }

    /**
     * Cierra los objetos que recibe como parametros. tienes que controlar la
     * Exception.
     *
     * @param cn
     * @param st
     * @param rs
     * @throws SQLException
     */
    public void cerrarObjetosJDBC(Connection cn, PreparedStatement st, ResultSet rs) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (st != null && !st.isClosed()) {
            st.close();
        }
        if (cn != null && !cn.isClosed()) {
            cn.close();
        }
    }

    /**
     * Retorna un String con la consulta SQL para consultar campos de la tabla.
     * select [CAMPOS] FROM [TABLA]
     *
     * @return
     */
    protected String sqlSelectConsulta() {
        String nuevoSql = SQL_SELECT;
        nuevoSql = nuevoSql.replace(TABLA_INDICADOR, obtenerTablaDeBD());
        nuevoSql = nuevoSql.replace(CAMPOS_INDICADOR, Arrays.toString(obtenerCamposDeTabla()));
        nuevoSql = (nuevoSql.replace("[", "")).replace("]", "");
        return nuevoSql;
    }

    /**
     * Obtenemos todos los datos de la obtenerTablaDeBD
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public List<T> obtenerTodos() throws SQLException, ClassNotFoundException, IOException {
        Connection cn = abrirConexionDB();
        PreparedStatement ps = cn.prepareStatement(sqlSelectConsulta());
        if (limiteDeBusquedaEncendido()) {
            ps.setMaxRows(limiteDeBusquedaEstablecer());
        }
        ResultSet rs = ps.executeQuery();
        List<T> lista = new ArrayList<T>();
        while (rs.next()) {
            lista.add(mapearEntidad(rs));
        }
        cerrarObjetosJDBC(cn, ps, rs);
        return lista;
    }

    /**
     * Este metodo es para buscar por PrimaryKey un campo en una
     * obtenerTablaDeBD recibe un tipo object ya que podemos recibir
     * obtenerCamposDeTabla de cualquier tipo y en caso de que queramos buscar
     * por otro campo solo tenemos que asignarlo al campo clave.
     *
     * @param id
     * @return un objeto de la entidad.
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException
     */
    public T obtenerUnDatoPorId(Object id) throws ClassNotFoundException, SQLException, IOException {
        String sqlObtenerUno = SQL_SELECT + SQL_WHERE + campoClavePK() + " = ?";
        sqlObtenerUno = sqlObtenerUno.replace(TABLA_INDICADOR, obtenerTablaDeBD());
        sqlObtenerUno = sqlObtenerUno.replace(CAMPOS_INDICADOR, Arrays.toString(obtenerCamposDeTabla()));
        sqlObtenerUno = (sqlObtenerUno.replace("[", "")).replace("]", "");
        Connection cn = abrirConexionDB();
        PreparedStatement ps = cn.prepareStatement(sqlObtenerUno);
        ps.setObject(1, id);
        ResultSet rs = ps.executeQuery();
        T e = null;
        if (rs.next()) {
            e = mapearEntidad(rs);
        }
        cerrarObjetosJDBC(cn, ps, rs);
        return e;
    }

    /**
     * Retorna la consulta SELECT [CAMPOS] FROM [TABLA] modificada y lista para
     * usar recordar setiar parametros de los siguientes metodos campoClavePK();
     * limiteDeBusquedaEstablecer(); limiteDeBusquedaEncendido();
     * mapearEntidad(ResultSet rs)
     *
     * @return
     */
    protected String sqlInsertConsulta() {
        String sql = SQL_INSERT;
        sql = sql.replace(TABLA_INDICADOR, obtenerTablaDeBD());
        sql = sql.replace(CAMPOS_INDICADOR, Arrays.toString(obtenerCamposDeTabla()));
        StringBuilder strB = new StringBuilder();
        for (byte i = 0; i < obtenerCamposDeTabla().length; i++) {
            strB.append("?,");
        }
        sql = sql.replace(VALORES_INDICADOR, (strB.toString()).substring(0, strB.toString().length() - 1));
        sql = sql.replace("[", "").replace("]", "");
        strB = null;
        return sql;
    }

    /**
     * Inserta en la base de datos los valores que recibes en la entidad.
     * (Tinenes que tener configurado tus metodos abstractos.)
     *
     * @param entidad
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException
     */
    public void sqlInsert(T entidad) throws ClassNotFoundException, SQLException, IOException {
        Connection cn = abrirConexionDB();
        PreparedStatement ps = cn.prepareStatement(sqlInsertConsulta());
        mapearPreparedStatementInsert(entidad, ps);
        ps.execute();
        cerrarObjetosJDBC(cn, ps);
    }

    /**
     * Retorna la consulta SQL para actualizar datos
     *
     * @return
     */
    protected String sqlUpdateConsulta() {
        String sql = SQL_UPDATE;
        sql = sql.replace(TABLA_INDICADOR, obtenerTablaDeBD());
        sql = sql.replace(INDICADOR_CONDICION, (campoClavePK() + "= ?"));
        StringBuilder str = new StringBuilder();
        for (String campo : obtenerCamposDeTabla()) {
            str.append(campo).append("=? ,");
        }
        sql = sql.replace(VALORES_INDICADOR, str.toString().substring(0, str.toString().length() - 1));
        return sql;
    }

    /**
     * Ejecuta el update de una tabla de acorde a la entidad recibida. tienes
     * que tener todos los valores de los metodos abstractos asignados.
     *
     * @param entidad
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException
     */
    public void sqlUpdate(T entidad) throws ClassNotFoundException, SQLException, IOException {
        Connection cn = abrirConexionDB();
        PreparedStatement ps = cn.prepareStatement(sqlUpdateConsulta());
        mapearPrepareStatementUpdate(entidad, ps);
        ps.execute();
        cerrarObjetosJDBC(cn, ps);
    }

    /**
     * Crea la sentencia SQL de la consulta DELETE DELETE FROM [TABLA] WHERE
     * [CONDICION]
     *
     * @return
     */
    protected String sqlDeleteConsulta() {
        String sql = SQL_DELETE;
        sql = sql.replace(TABLA_INDICADOR, obtenerTablaDeBD());
        sql = sql.replace(INDICADOR_CONDICION, campoClavePK() + " = ?");
        return sql;
    }

    /**
     * Ejecuta el sql delete de acorde a su campo clave o PK
     *
     * @param valor
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException
     */
    public void sqlDelete(Object valor) throws ClassNotFoundException, SQLException, IOException {
        Connection cn = abrirConexionDB();
        PreparedStatement ps = cn.prepareStatement(sqlUpdateConsulta());
        ps.setObject(1, valor);
        ps.execute();
        cerrarObjetosJDBC(cn, ps);
    }

    /**
     * debes retornar el nombre de tu obtenerTablaDeBD.
     *
     * @return mi_tabla
     */
    protected abstract String obtenerTablaDeBD();

    /**
     * Debes retornar los obtenerCamposDeTabla de tu obtenerTablaDeBD de la
     * forma establecida o la de tu preferencia.
     *
     * @return {"campo1","campo2","campo3""}
     */
    protected abstract String[] obtenerCamposDeTabla();

    /**
     * Necesito que me mapees la entidad para poder utilizarlas en las consultas
     * sql
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    protected abstract T mapearEntidad(ResultSet rs) throws SQLException;

    /**
     * Necesito que me retornes el campo clave de la obtenerTablaDeBD o la
     * PrimaryKey.
     *
     * @return
     */
    protected abstract String campoClavePK();

    /**
     * necesito que me retornen la cantidad de registros maximos que traeremos
     * al obtener datos.
     *
     * @return
     */
    protected abstract int limiteDeBusquedaEstablecer();

    /**
     * Tienes que retornarme verdadero si estaras usando el limite de busquedas.
     * si retornas falso el limite de busquedas se desactivara y traeras todo.
     *
     * @return
     */
    protected abstract boolean limiteDeBusquedaEncendido();

    /**
     * Mapeo de los parametros de las entidades para poder realizar en insert.
     *
     * @param entidad
     * @param ps
     * @throws SQLException
     */
    protected abstract void mapearPreparedStatementInsert(T entidad, PreparedStatement ps) throws SQLException;

    /**
     * Mapeo de entidad para hacer un update recordar que al mapear entidades
     * tienen que setiar por ultimo el id(Primary key) y si tambien lo tienes de
     * primero tambien lo haras de primero y de ultimo ya que no puedes
     * modificar si id en caso que cambies el id a modificar se modificara el id
     * que asignaste.
     *
     * @param entidad
     * @param ps
     * @throws SQLException
     */
    protected abstract void mapearPrepareStatementUpdate(T entidad, PreparedStatement ps) throws SQLException;

}
