/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Dominio.Preparatoria;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Citlali Orduño
 */
public class PreparatoriaDAO extends BaseDAO<Preparatoria> {

    @Override
    public void agregar(Preparatoria entidad) {
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
        Preparatoria preparatoria = entityManager.find(Preparatoria.class, id);
        if (preparatoria != null) {
            entityManager.remove(preparatoria);
        }
        entityManager.getTransaction().commit();
    }

    
    @Override
    public void actualizar(Preparatoria entidad) {
         EntityManager entityManager = this.createEntityManager();
         entityManager.getTransaction().begin();
         Preparatoria preparatoria = entityManager.find(Preparatoria.class, entidad.getId());
        if (preparatoria != null) {
           
            preparatoria.setNombre(entidad.getNombre());
            preparatoria.setImagen(entidad.getImagen());
            preparatoria.setClave(entidad.getClave());

            entityManager.merge(preparatoria);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public ArrayList<Preparatoria> consultarTodos() {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Preparatoria.class));
        Query query = entityManager.createQuery(criteria);
        List<Preparatoria> preparatorias = query.getResultList();
        
        entityManager.getTransaction().commit();
        return new ArrayList<>(preparatorias);
    }

    @Override
    public Preparatoria buscarPorId(long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Preparatoria preparatoria = entityManager.find(Preparatoria.class, id);
        entityManager.getTransaction().commit();
        return preparatoria;
    }
    
     public ArrayList<Preparatoria> consultarPorNombre(String nombre){
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        List<Preparatoria> preparatorias;
        if (!nombre.equals("")) {
           
            String jpql = String.format("SELECT * FROM scc.preparatorias WHERE scc.preparatorias.nombre LIKE '%%"+nombre+"%%'");
            preparatorias = entityManager.createNativeQuery(jpql, Preparatoria.class).getResultList();
        } else {
            String jpql = "SELECT * FROM scc.preparatorias";
            preparatorias = entityManager.createNativeQuery(jpql, Preparatoria.class).getResultList();
        }
        entityManager.getTransaction().commit();

        return new ArrayList<>(preparatorias);
    }
     
}
