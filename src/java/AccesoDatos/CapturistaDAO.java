/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Dominio.Capturista;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Citlali Orduño
 */
public class CapturistaDAO extends BaseDAO<Capturista> {

    @Override
    public void agregar(Capturista entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entidad);
        entityManager.getTransaction().commit();
        System.out.println("Se agregó el capturista");
    }

    @Override
    public void eliminar(Long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Capturista capturista= entityManager.find(Capturista.class, id);
        if (capturista != null) {
            entityManager.remove(capturista);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void actualizar(Capturista entidad) {
        EntityManager entityManager = this.createEntityManager();
         entityManager.getTransaction().begin();
         Capturista capturista= entityManager.find(Capturista.class, entidad.getId());
        if (capturista != null) {
           
            capturista.setNombre(entidad.getNombre());
            capturista.setUsuario(entidad.getUsuario());
            capturista.setContraseña(entidad.getContraseña());
            capturista.setIdPreparatoria(entidad.getIdPreparatoria());
            
            entityManager.merge(capturista);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public ArrayList<Capturista> consultarTodos() {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Capturista.class));
        Query query = entityManager.createQuery(criteria);
        List<Capturista> capturistas = query.getResultList();
        
        entityManager.getTransaction().commit();
        return new ArrayList<>(capturistas);
    }

    @Override
    public Capturista buscarPorId(long id) {
         EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Capturista capturista= entityManager.find(Capturista.class, id);
        entityManager.getTransaction().commit();
        return capturista;
    }
    
    public ArrayList<Capturista> consultarPorNombre(String nombre){
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        List<Capturista> capturistas;
        if (!nombre.equals("")) {
           
            String jpql = String.format("SELECT * FROM scc.capturistas WHERE scc.capturistas.nombre LIKE '%%"+nombre+"%%'");
            capturistas = entityManager.createNativeQuery(jpql, Capturista.class).getResultList();
        } else {
            String jpql = "SELECT * FROM scc.capturistas";
            capturistas = entityManager.createNativeQuery(jpql, Capturista.class).getResultList();
        }
        entityManager.getTransaction().commit();

        return new ArrayList<>(capturistas);
    }
}
