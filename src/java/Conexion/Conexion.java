/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;


import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Dominio.Utilitarios;

/**
 *
 * @author Dhtey
 */
public class Conexion {
    private static Connection cnx = null;
    public static Connection obtener() throws SQLException, ClassNotFoundException {
      if (cnx == null) {
         try {
            Class.forName("com.mysql.jdbc.Driver");

            //modificar con tus params
            //Cris:"jdbc:mysql://localhost:3306/asistencias", "root", ""
            //Miranda:"jdbc:mysql://localhost:3306/asistencias", "root", "1234"
            cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ssc", "adminSSC", "passwordssc");
         } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
      }
      return cnx;


   }
   public static void cerrar() throws SQLException {
      if (cnx != null) {
         cnx.close();
      }
   }
    
    Connection cn = null;
    Utilitarios uti = new Utilitarios();
    private static String driver = "com.mysql.jdbc.Driver";
    private static String usuario = "adminSSC";
    private static String password = "passwordssc";
    private static String url = "jdbc:mysql://localhost:3306/ssc";

    static {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Proyecto", 0);
        }
    }

    public Connection getCn(){
        try {
            cn =(Connection) DriverManager.getConnection(url, usuario, password);
        } catch (Exception e) {
            uti.msj(e.toString(), 0);
        }
        return cn;
    }
}
