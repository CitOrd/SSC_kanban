/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import AccesoDatos.PreparatoriaDAO;
import Dominio.Preparatoria;
import java.util.ArrayList;

/**
 *
 * @author Citlali Orduño
 */
public class PreparatoriaControl extends BaseControl<Preparatoria> {

    PreparatoriaDAO prepDao;

    public PreparatoriaControl(PreparatoriaDAO prepDao) {
        this.prepDao = new PreparatoriaDAO();
    }
    
    @Override
    public void agregar(Preparatoria preparatoria) {
       if(preparatoria != null){
           this.prepDao.agregar(preparatoria);
           System.out.println("Se agregó la preparatoria");
       }else{
           System.out.println("No se agregó");
       }

    }

    @Override
    public void eliminar(Preparatoria preparatoria) {
        if(preparatoria !=null){
            this.prepDao.eliminar(preparatoria.getId());
            System.out.println("Se eliminó la preparatoria");
        }else{
            System.out.println("No se eliminó la preparatoria");
        }
    }

    @Override
    public void actualizar(Preparatoria preparatoria) {
         if(preparatoria !=null){
            this.prepDao.actualizar(preparatoria);
             System.out.println("Se actualizó la preparatoria");
        }else{
             System.out.println("No se actualizó la preparatoria");
         }
    }

    @Override
    public Preparatoria buscarPorID(Long id) {
        if(id != null){
            System.out.println("Se encontró el id");
           return this.prepDao.buscarPorId(id);
            
        }else{
            System.out.println("No se encontró el id de la preparatoria");
            return null;
        }
    }

    @Override
    public ArrayList<Preparatoria> consultarTodos(Preparatoria preparatoria) {
        if(preparatoria != null){
            System.out.println("Se encontró las preparatorias");
            return this.prepDao.consultarTodos();
        }else{
            System.out.println("no se pudo acceder a las preparatorias");
            return null;
        }
    }
    
     public ArrayList<Preparatoria> consultarCategoriaPorNombre(String nombre){
          if(nombre != ""){
            return this.prepDao.consultarPorNombre(nombre);
        }else{
            System.out.println("No se pudo consultar el titulo de la materia");
            return null;
        }
     } 
    
}
