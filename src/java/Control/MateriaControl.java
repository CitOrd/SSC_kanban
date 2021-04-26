/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import AccesoDatos.MateriaDAO;
import Dominio.Materia;
import java.util.ArrayList;

/**
 *
 * @author Citlali Orduño
 */
public class MateriaControl extends BaseControl<Materia>{

    MateriaDAO matDao;
    public MateriaControl() {
        this.matDao= new MateriaDAO();
    }

    
    @Override
    public void agregar(Materia materia) {
         if(materia != null){
            this.matDao.agregar(materia);
        }else{
            System.out.println("No se pudo agregar la materia");
        }
    }

    @Override
    public void eliminar(Materia materia) {
         if(materia != null){
            this.matDao.eliminar(materia.getId());
        }else{
            System.out.println("No se pudo eliminar la materia");
        }
    }

    @Override
    public void actualizar(Materia materia) {
         if(materia != null){
             this.matDao.actualizar(materia);
         }else{
            System.out.println("No se pudo actualizar");
        }
    }

    @Override
    public Materia buscarPorID(Long id) {
         if(id != null){
            return this.matDao.buscarPorId(id);
        }else{
            System.out.println("No se pudo encontrar el id de la materia");
            return null;
        }
    }

    @Override
    public ArrayList<Materia> consultarTodos(Materia materia) {
         if(materia != null){
            return this.matDao.consultarTodos();
        }else{
            System.out.println("No se pudo consultar la materia");
            return null;
        }
    }
    
    
     public ArrayList<Materia> consultarCategoriaPorTitulo(String titulo){
          if(titulo != ""){
            return this.matDao.consultarPorTitulo(titulo);
        }else{
            System.out.println("No se pudo consultar el titulo de la materia");
            return null;
        }
     } 
    
}
