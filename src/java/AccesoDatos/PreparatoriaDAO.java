/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Conexion.Conexion;
import Dominio.Preparatoria;
import Dominio.Utilitarios;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Citlali Orduño
 */
public class PreparatoriaDAO extends BaseDAO<Preparatoria> {

    Connection cn = new Conexion().getCn();
    Utilitarios uti = new Utilitarios();
    
    @Override
    public void agregar(Preparatoria obj) {
        try{
            Statement comando= cn.createStatement();
            String comandoSQL= String.format("INSERT INTO preparatorias(nombre,"
                    + " clave) VALUES('%d', '%s') ", 
                    obj.getNombre(),
                    obj.getClave());
                    
            comando.executeUpdate(comandoSQL);
            
        }catch(SQLException ex){
            
        }
    }

    @Override
    public boolean eliminar(Long id) {
       boolean band=false;
        try {
            CallableStatement cs = cn.prepareCall("{call USP_ELIMINARLIBRO(?)}");
            cs.setLong(1, id);
            
            if(cs.executeUpdate()>0)
                band=true;
            
        } catch (Exception ex) {
            uti.msj(ex.toString(), 0);
        }
        
        return band;
    }

    
    @Override
    public boolean actualizar(Preparatoria obj) {
         boolean band = false;
        try {
            CallableStatement cs = cn.prepareCall("{call USP_ACTUALIZARPREPARATORIA(?,?,?)}");

            cs.setString(1, obj.getNombre());
            cs.setString(2, obj.getClave());
            cs.setBlob(3, obj.getImagen());

            if (cs.executeUpdate() > 0) {
                band = true;
            }

        } catch (Exception ex) {
            uti.msj(ex.toString(), 0);
        }

        return band;
    }

    @Override
    public DefaultTableModel consultarTodos() {
        DefaultTableModel mdl = new DefaultTableModel();
        mdl.addColumn("Codigo");
        mdl.addColumn("Nombre");
        mdl.addColumn("Descripción");
        mdl.addColumn("Autor");
        mdl.addColumn("Genero");
        mdl.addColumn("Cantidad");
        
        try {
            CallableStatement cs=cn.prepareCall("{call USP_LISTADOPREPARATORIA}");
            ResultSet rs=cs.executeQuery();
            
            while(rs.next()){
                Object data[]={rs.getString(1),rs.getString(2),
                               rs.getString(3),rs.getString(4),
                               rs.getString(5),rs.getString(6)};
                
                mdl.addRow(data);
            }
            
        } catch (Exception ex) {
            uti.msj(ex.toString(), 0);
        }
        return mdl;
    }

    @Override
    public Preparatoria buscarPorId(long id) {
        
    }
    
     public ArrayList<Preparatoria> consultarPorNombre(String nombre){
        
        List<Preparatoria> preparatorias;
        if (!nombre.equals("")) {
           
            String jpql = String.format("SELECT * FROM scc.preparatorias WHERE scc.preparatorias.nombre LIKE '%%"+nombre+"%%'");
            preparatorias = ;
        } else {
            String jpql = "SELECT * FROM scc.preparatorias";
            preparatorias = entityManager.createNativeQuery(jpql, Preparatoria.class).getResultList();
        }
        entityManager.getTransaction().commit();

        return new ArrayList<>(preparatorias);
    }
     
}
