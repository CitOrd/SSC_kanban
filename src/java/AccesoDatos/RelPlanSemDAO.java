/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;


import Dominio.RelPlanSem;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Citlali Orduño
 */
public class RelPlanSemDAO extends BaseDAO<RelPlanSem>{

    @Override
    public void agregar(RelPlanSem entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entidad);
        entityManager.getTransaction().commit();
        System.out.println("Se agregó la relacion del plan de estudio y el semestre");
    }

    @Override
    public void eliminar(Long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        RelPlanSem relPlanSem = entityManager.find(RelPlanSem.class, id);
        if (relPlanSem != null) {
            entityManager.remove(relPlanSem);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void actualizar(RelPlanSem entidad) {
          EntityManager entityManager = this.createEntityManager();
         entityManager.getTransaction().begin();
         RelPlanSem relPlanSem = entityManager.find(RelPlanSem.class, entidad.getId());
        if (relPlanSem != null) {
           
            relPlanSem.setIdPlanEstudio(entidad.getIdPlanEstudio());
            relPlanSem.setIdSemestre(entidad.getIdSemestre());

            entityManager.merge(relPlanSem);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public ArrayList<RelPlanSem> consultarTodos() {
         EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(RelPlanSem.class));
        Query query = entityManager.createQuery(criteria);
        List<RelPlanSem> relPlanesSems = query.getResultList();
        
        entityManager.getTransaction().commit();
        return new ArrayList<>(relPlanesSems);
    }

    @Override
    public RelPlanSem buscarPorId(long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        RelPlanSem relplansem = entityManager.find(RelPlanSem.class, id);
        entityManager.getTransaction().commit();
        return relplansem;
    }
    
}
