/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Dominio.Materia;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Citlali Orduño
 */
public class MateriaDAO extends BaseDAO<Materia>{

    @Override
    public void agregar(Materia entidad) {
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
        Materia materia = entityManager.find(Materia.class, id);
        if (materia != null) {
            entityManager.remove(materia);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void actualizar(Materia entidad) {
         EntityManager entityManager = this.createEntityManager();
         entityManager.getTransaction().begin();
         Materia materia = entityManager.find(Materia.class, entidad.getId());
        if (materia != null) {
           
            materia.setTitulo(entidad.getTitulo());
            materia.setIdSemestre(entidad.getIdSemestre());
            materia.setClave(entidad.getClave());
            
            entityManager.merge(materia);
        }
        entityManager.getTransaction().commit();
        
    }

    @Override
    public ArrayList<Materia> consultarTodos() {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Materia.class));
        Query query = entityManager.createQuery(criteria);
        List<Materia> materias = query.getResultList();
        
        entityManager.getTransaction().commit();
        return new ArrayList<>(materias);
    }

    @Override
    public Materia buscarPorId(long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Materia materia = entityManager.find(Materia.class, id);
        entityManager.getTransaction().commit();
        return materia;
    }
    
     public ArrayList<Materia> consultarPorTitulo(String titulo){
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        List<Materia> materias;
        if (!titulo.equals("")) {
           
            String jpql = String.format("SELECT * FROM scc.materias WHERE scc.materias.titulo LIKE '%%"+titulo+"%%'");
            materias = entityManager.createNativeQuery(jpql, Materia.class).getResultList();
        } else {
            String jpql = "SELECT * FROM scc.materias";
            materias = entityManager.createNativeQuery(jpql, Materia.class).getResultList();
        }
        entityManager.getTransaction().commit();

        return new ArrayList<>(materias);
    }
    
}
