/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Clase abstracta padre con los metodos a usar en clases hijas para acceder a la BD.
 * @author Citlali Orduño
 */
public abstract class BaseDAO<T> {
    private static final String CONEXION = "jdbc:mysql://localhost:3306/ssc";
    private static final String USUARIO = "adminSSC";
    private static final String PASSWORD = "passwordssc";
    
    protected Connection getConexion() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver"); 
        Connection conexion = DriverManager.getConnection(BaseDAO.CONEXION,
                BaseDAO.USUARIO, BaseDAO.PASSWORD);
        return conexion;
    }
     
    public abstract void agregar(T entidad);
    
    public abstract void eliminar(T entidad);
    
    public abstract void actualizar(T entidad);
    
    public abstract ArrayList<T> consultar();
    
    public abstract T buscarPorId(int id);
}
