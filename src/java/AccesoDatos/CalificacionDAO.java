/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;


import Dominio.Calificacion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Citlali Orduño
 */
public class CalificacionDAO extends BaseDAO<Calificacion> {

    @Override
    public void agregar(Calificacion entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entidad);
        entityManager.getTransaction().commit();
        System.out.println("Se agregó la calificación");
    }

    @Override
    public void eliminar(Long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Calificacion calificacion = entityManager.find(Calificacion.class, id);
        if (calificacion != null) {
            entityManager.remove(calificacion);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void actualizar(Calificacion entidad) {
        EntityManager entityManager = this.createEntityManager();
         entityManager.getTransaction().begin();
         Calificacion calificacion = entityManager.find(Calificacion.class, entidad.getId());
        if (calificacion != null) {
           
            calificacion.setIdAlumno(entidad.getIdAlumno());
            calificacion.setIdMateria(entidad.getIdMateria());
            calificacion.setPuntaje(entidad.getPuntaje());

            entityManager.merge(calificacion);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public ArrayList<Calificacion> consultarTodos() {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Calificacion.class));
        Query query = entityManager.createQuery(criteria);
        List<Calificacion> calificacion = query.getResultList();
        
        entityManager.getTransaction().commit();
        return new ArrayList<>(calificacion);
    }

    @Override
    public Calificacion buscarPorId(long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Calificacion calificacion = entityManager.find(Calificacion.class, id);
        entityManager.getTransaction().commit();
        return calificacion;
    }

}
