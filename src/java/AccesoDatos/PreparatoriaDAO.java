/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Conexion.Conexion;
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
        File archivoFoto = new File(obj.getImagen());
        try {
            boolean resp = false;
            FileInputStream convertir_imagen = new FileInputStream(archivoFoto);
            Connection cn = this.getConexion();
            PreparedStatement ps = cn.prepareStatement("INSERT INTO ssc.preparatorias VALUES(?,?,?,?,?)");
            ps.setInt(1, obj.getId());
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getResponsable());
            ps.setString(4, obj.getClave());
            ps.setBlob(5, convertir_imagen);

            int i = ps.executeUpdate();

            if (i == 1) {
                resp = true;
            } else {
                resp = false;
            }

            ps.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PreparatoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            Connection cn = this.getConexion();
            Statement comando = cn.createStatement();
            String comandoSQL = String.format("UPDATE preparatorias SET clave='%s', "
                    + "nombre='%s', imagen= ? WHERE idPreparatoria = %d",
                    obj.getNombre(),
                    obj.getClave(),
                    obj.getImagen());

            comando.executeUpdate(comandoSQL);
            System.out.println("Se actualizó la preparatoria");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public ArrayList<Preparatoria> consultar() {
        ArrayList<Preparatoria> listaPreparatorias = new ArrayList<>();

        try {
            Connection cn = this.getConexion();
            Statement comando = cn.createStatement();
            String comandoSQL = String.format("SELECT idPreparatoria, clave, imagen FROM preparatorias");
            ResultSet resultado = comando.executeQuery(comandoSQL);

            while (resultado.next()) {
                Integer id = resultado.getInt("idPreparatoria");
                String nombre = resultado.getString("nombre");
                String clave = resultado.getString("clave");
                String imagen = resultado.getString("imagen");
                Preparatoria preparatoria = new Preparatoria(id, nombre, clave, imagen);
                listaPreparatorias.add(preparatoria);
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
            String comandoSQL = String.format("SELECT idPreparatoria, clave, imagen FROM preparatorias = %s", id);
            ResultSet resultado = comando.executeQuery(comandoSQL);

            if (resultado.next()) {
                int idPrepa = resultado.getInt("idPreparatoria");
                String nombre = resultado.getString("nombre");
                String clave = resultado.getString("clave");
                String imagen = resultado.getString("imagen");
                prepa = new Preparatoria(idPrepa, nombre, clave, imagen);

            }
            return prepa;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return prepa;
        }

    }

}
