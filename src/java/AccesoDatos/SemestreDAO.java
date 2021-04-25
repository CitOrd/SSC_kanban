/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;


import Dominio.Semestre;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Citlali Orduño
 */
public class SemestreDAO extends BaseDAO<Semestre> {

    @Override
    public void agregar(Semestre entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entidad);
        entityManager.getTransaction().commit();
        System.out.println("Se agregó el semestre");
    }

    @Override
    public void eliminar(Long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Semestre semestre = entityManager.find(Semestre.class, id);
        if (semestre != null) {
            entityManager.remove(semestre);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void actualizar(Semestre entidad) {
        EntityManager entityManager = this.createEntityManager();
         entityManager.getTransaction().begin();
         Semestre semestre = entityManager.find(Semestre.class, entidad.getId());
        if (semestre != null) {
           
            semestre.setNumSemestre(entidad.getNumSemestre());
            semestre.setMaterias(entidad.getMaterias());
            

            entityManager.merge(semestre);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public ArrayList<Semestre> consultarTodos() {
         EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Semestre.class));
        Query query = entityManager.createQuery(criteria);
        List<Semestre> semestres = query.getResultList();
        
        entityManager.getTransaction().commit();
        return new ArrayList<>(semestres);
    }

    @Override
    public Semestre buscarPorId(long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Semestre semestre = entityManager.find(Semestre.class, id);
        entityManager.getTransaction().commit();
        return semestre;
    }
    
    
}
