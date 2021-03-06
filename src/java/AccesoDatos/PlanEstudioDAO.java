/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Dominio.PlanEstudio;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

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
        System.out.println("Se agregó el plan de estudio");
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
         EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(PlanEstudio.class));
        Query query = entityManager.createQuery(criteria);
        List<PlanEstudio> planesEstudio = query.getResultList();
        
        entityManager.getTransaction().commit();
        return new ArrayList<>(planesEstudio);
    }

    @Override
    public PlanEstudio buscarPorId(long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        PlanEstudio planEstudio = entityManager.find(PlanEstudio.class, id);
        entityManager.getTransaction().commit();
        return planEstudio;
    }
    
     public ArrayList<PlanEstudio> consultarPorNombre(String titulo){
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        List<PlanEstudio> planesEstudio;
        if (!titulo.equals("")) {
           
            String jpql = String.format("SELECT * FROM scc.planesEstudio WHERE scc.planesEstudio.titulo LIKE '%%"+titulo+"%%'");
            planesEstudio = entityManager.createNativeQuery(jpql, PlanEstudio.class).getResultList();
        } else {
            String jpql = "SELECT * FROM scc.preparatorias";
            planesEstudio = entityManager.createNativeQuery(jpql, PlanEstudio.class).getResultList();
        }
        entityManager.getTransaction().commit();

        return new ArrayList<>(planesEstudio);
    }
    
}
