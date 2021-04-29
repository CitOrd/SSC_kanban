/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Dominio.Preparatoria;
import Dominio.Utilitarios;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Citlali Orduño
 */
public class PreparatoriaDAO extends BaseDAO<Preparatoria> {

    Utilitarios uti = new Utilitarios();

    @Override
    public void agregar(Preparatoria obj) {
//        File archivoFoto = new File(obj.getImagen());
        try {
            boolean resp = false;
//            FileInputStream convertir_imagen = new FileInputStream(archivoFoto);
            System.out.println("Se agrego correctamente la preparatoria");            
            Connection cn = this.getConexion();
            PreparedStatement ps = cn.prepareStatement("INSERT INTO ssc.preparatorias VALUES(?,?,?,?,?)");
            ps.setInt(1, obj.getId());
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getResponsable());
            ps.setString(4, obj.getClave());
            ps.setBlob(5, obj.getImagen2());
//            ps.setBlob(5, convertir_imagen);

            int i = ps.executeUpdate();

            if (i == 1) {
                resp = true;
            } else {
                resp = false;
            }

            ps.close();
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(PreparatoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    @Override
    public void eliminar(Preparatoria preparatoria) {
        try {
            Connection cn = this.getConexion();
            Statement comando = cn.createStatement();
            String comandoSQL = String.format("DELETE FROM preparatorias WHERE "
                    + "idPreparatoria= '%d'", preparatoria.getId());
            comando.executeUpdate(comandoSQL);
            System.out.println("Se elimino correctamente la preparatoria");
            cn.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
    }

    @Override
    public void actualizar(Preparatoria obj) {
        File archivoFoto = new File(obj.getImagen());
        try {
            boolean resp = false;
            FileInputStream convertir_imagen = new FileInputStream(archivoFoto);
            Connection cn = this.getConexion();
            PreparedStatement ps = cn.prepareStatement("UPDATE ssc.preparatorias SET nombre=?, "
                    + "responsable=?, clave=?, imagen=? WHERE idPreparatoria=? ");

            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getResponsable());
            ps.setString(3, obj.getClave());
            ps.setBlob(4, convertir_imagen);
            ps.setInt(5, obj.getId());

            int i = ps.executeUpdate();

            if (i == 1) {
                resp = true;
            } else {
                resp = false;
            }

            ps.close();
            System.out.println("Se modifico correctamente la preparatoria");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(PreparatoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Preparatoria> consultar() {
        ArrayList<Preparatoria> listaPreparatorias = new ArrayList<>();
        Preparatoria prepa = null;
        try {
            Connection cn = this.getConexion();
            Statement comando = cn.createStatement();
            String comandoSQL = String.format("SELECT * FROM preparatorias");
            ResultSet resultado = comando.executeQuery(comandoSQL);

            while (resultado.next()) {
                int idPrepa = resultado.getInt("idPreparatoria");
                String nombre = resultado.getString("nombre");
                String responsable = resultado.getString("responsable");
                String clave = resultado.getString("clave");
                Blob imagen = resultado.getBlob("imagen");
                prepa = new Preparatoria(idPrepa, nombre,responsable, clave, imagen);
                listaPreparatorias.add(prepa);
            }
            return listaPreparatorias;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return listaPreparatorias;
        }
    }

    @Override
    public Preparatoria buscarPorId(int id) {
        Preparatoria prepa = null;
        try {
            Connection cn = this.getConexion();
            Statement comando = cn.createStatement();
            String comandoSQL = String.format("SELECT * FROM preparatorias WHERE idPreparatoria = %d", id);
            ResultSet resultado = comando.executeQuery(comandoSQL);

            if (resultado.next()) {
                int idPrepa = resultado.getInt("idPreparatoria");
                String nombre = resultado.getString("nombre");
                String responsable = resultado.getString("responsable");
                String clave = resultado.getString("clave");
                Blob imagen = resultado.getBlob("imagen");
                prepa = new Preparatoria(idPrepa, nombre,responsable, clave, imagen);

            }
            return prepa;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return prepa;
        }

    }

}
