/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Dominio.Alumno;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Citlali Orduño
 */
public class AlumnoDAO extends BaseDAO<Alumno> {

    @Override
    public void agregar(Alumno entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entidad);
        entityManager.getTransaction().commit();
        System.out.println("Se agregó el alumno");
    }

    @Override
    public void eliminar(Long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Alumno alumno = entityManager.find(Alumno.class, id);
        if (alumno != null) {
            entityManager.remove(alumno);
        }
        entityManager.getTransaction().commit();
        
    }

    @Override
    public void actualizar(Alumno entidad) {
        EntityManager entityManager = this.createEntityManager();
         entityManager.getTransaction().begin();
         Alumno alumno = entityManager.find(Alumno.class, entidad.getId());
        if (alumno != null) {
           
            alumno.setNombre(entidad.getNombre());
            alumno.setPreparatoria(entidad.getPreparatoria());
            alumno.setCalificaciones(entidad.getCalificaciones());

            entityManager.merge(alumno);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public ArrayList<Alumno> consultarTodos() {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Alumno.class));
        Query query = entityManager.createQuery(criteria);
        List<Alumno> alumno = query.getResultList();
        
        entityManager.getTransaction().commit();
        return new ArrayList<>(alumno);
    }

    @Override
    public Alumno buscarPorId(long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Alumno alumno = entityManager.find(Alumno.class, id);
        entityManager.getTransaction().commit();
        return alumno;
    }
    
     public ArrayList<Alumno> consultarPorNombre(String nombre){
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        List<Alumno> alumnos;
        if (!nombre.equals("")) {
           
            String jpql = String.format("SELECT * FROM scc.alumnos WHERE scc.alumnos.nombre LIKE '%%"+nombre+"%%'");
            alumnos = entityManager.createNativeQuery(jpql, Alumno.class).getResultList();
        } else {
            String jpql = "SELECT * FROM scc.preparatorias";
            alumnos = entityManager.createNativeQuery(jpql, Alumno.class).getResultList();
        }
        entityManager.getTransaction().commit();

        return new ArrayList<>(alumnos);
    }
}
