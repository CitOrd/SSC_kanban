/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import AccesoDatos.PlanEstudioDAO;
import Dominio.PlanEstudio;
import java.util.ArrayList;

/**
 *
 * @author Citlali Orduño
 */
public class PlanEstudioControl extends BaseControl<PlanEstudio>{

    PlanEstudioDAO peDao;

    public PlanEstudioControl(PlanEstudioDAO peDao) {
        this.peDao = new PlanEstudioDAO();
    }
    
    @Override
    public void agregar(PlanEstudio planEstudio) {
        if(planEstudio != null){
            this.peDao.agregar(planEstudio);
            System.out.println("se agrego el plan de estudio");
        }else{
            System.out.println("No se pudo agregar el plan de estudio");
        }
    }

    @Override
    public void eliminar(PlanEstudio planEstudio) {
        if(planEstudio != null){
            this.peDao.eliminar(planEstudio.getId());
            System.out.println("Se elimino el plan de estudio");
        }else{
            System.out.println("No se pudo eliminar el plan de estudio");
        }
    }

    @Override
    public void actualizar(PlanEstudio planEstudio) {
        if(planEstudio != null){
            this.peDao.actualizar(planEstudio);
            System.out.println("");
        }
    }

    @Override
    public PlanEstudio buscarPorID(Long id) {
        if(id != null){
            System.out.println("Se encontró el id");
           return this.peDao.buscarPorId(id);
            
        }else{
            System.out.println("No se encontró el id del plan de estudio");
            return null;
        }
    }

    @Override
    public ArrayList<PlanEstudio> consultarTodos(PlanEstudio planEstudio) {
        if(planEstudio != null){
            System.out.println("se pudo consultar los planes de estudio");
            return this.peDao.consultarTodos();
        }else{
            System.out.println("no se pudo acceder a los planes de estudio");
            return null;
        }
    }
    
    public ArrayList<PlanEstudio> consultarPorTitulo(String titulo){
        if(titulo != null){
            System.out.println("se encontró el titulo del plan de estudio");
            return this.peDao.consultarPorNombre(titulo);
        }else{
            System.out.println("no se pudo acceder al titulo del plan de estudio");
            return null;
        }
    }
    
}
