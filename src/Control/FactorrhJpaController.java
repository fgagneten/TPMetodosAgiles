/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Control.exceptions.NonexistentEntityException;
import Control.exceptions.PreexistingEntityException;
import Entity.Factorrh;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Victoria
 */
public class FactorrhJpaController implements Serializable {

    public FactorrhJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Factorrh factorrh) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(factorrh);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFactorrh(factorrh.getIdfactor()) != null) {
                throw new PreexistingEntityException("Factorrh " + factorrh + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Factorrh factorrh) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            factorrh = em.merge(factorrh);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = factorrh.getIdfactor();
                if (findFactorrh(id) == null) {
                    throw new NonexistentEntityException("The factorrh with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factorrh factorrh;
            try {
                factorrh = em.getReference(Factorrh.class, id);
                factorrh.getIdfactor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The factorrh with id " + id + " no longer exists.", enfe);
            }
            em.remove(factorrh);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Factorrh> findFactorrhEntities() {
        return findFactorrhEntities(true, -1, -1);
    }

    public List<Factorrh> findFactorrhEntities(int maxResults, int firstResult) {
        return findFactorrhEntities(false, maxResults, firstResult);
    }

    private List<Factorrh> findFactorrhEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Factorrh.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Factorrh findFactorrh(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Factorrh.class, id);
        } finally {
            em.close();
        }
    }

    public int getFactorrhCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Factorrh> rt = cq.from(Factorrh.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
