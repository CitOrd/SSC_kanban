/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Dominio.PlanEstudio;
import java.util.ArrayList;
import javax.persistence.EntityManager;

/**
 *
 * @author Citlali Orduño
 */
public class PlanEstudioDAO extends BaseDAO<PlanEstudio>{

    @Override
    public void agregar(PlanEstudio entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entidad);
        entityManager.getTransaction().commit();
        System.out.println("Se agregó la preparatoria");
    }

    @Override
    public void eliminar(Long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        PlanEstudio planEstudio = entityManager.find(PlanEstudio.class, id);
        if (planEstudio != null) {
            entityManager.remove(planEstudio);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void actualizar(PlanEstudio entidad) {
        EntityManager entityManager = this.createEntityManager();
         entityManager.getTransaction().begin();
        PlanEstudio planEstudio  = entityManager.find(PlanEstudio.class, entidad.getId());
        if (planEstudio != null) {
           
                planEstudio.setTitulo(entidad.getTitulo());
            entityManager.merge(planEstudio);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public ArrayList<PlanEstudio> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PlanEstudio buscarPorId(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
