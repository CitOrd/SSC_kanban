/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import AccesoDatos.CalificacionDAO;
import Dominio.Calificacion;
import java.util.ArrayList;

/**
 *
 * @author Citlali Orduño
 */
public class CalificacionControl extends BaseControl<Calificacion> {
    CalificacionDAO calDao;
    
    @Override
    public void agregar(Calificacion calificacion) {
        if(calDao != null){
            this.calDao.agregar(calificacion);
            System.out.println("Se agregó la calificacion");
        }else{
            System.out.println("No se pudo agregar la calificacion");
        }
    }

    @Override
    public void eliminar(Calificacion calificacion) {
        if(calDao != null){
            this.calDao.eliminar(calificacion.getId());
            System.out.println("Se elimino la calificacion");
        }else{
            System.out.println("no se elimino la calificacion");
        }
    }

    @Override
    public void actualizar(Calificacion calificacion) {
        if(calDao != null){
            this.calDao.actualizar(calificacion);
            System.out.println("se actualizo la calificacion");
        }else{
            System.out.println("No se pudo actualizar la calificacion");
        }
    }

    @Override
    public Calificacion buscarPorID(Long id) {
         if(id != null){
            System.out.println("Se encontró el id");
           return this.calDao.buscarPorId(id);
            
        }else{
            System.out.println("No se encontró el id ");
            return null;
        }
    }

    @Override
    public ArrayList<Calificacion> consultarTodos(Calificacion calificacion) {
        if(calificacion != null){
            System.out.println("Se encontraron las calificaciones");
            return this.calDao.consultarTodos();
        }else{
            System.out.println("no se pudo acceder a las calificaciones");
            return null;
        }
    }
    
}
