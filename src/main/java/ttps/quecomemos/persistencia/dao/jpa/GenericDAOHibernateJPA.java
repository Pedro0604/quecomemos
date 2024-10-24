package ttps.quecomemos.persistencia.dao.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import ttps.quecomemos.persistencia.dao.classes.GenericDAO;
import ttps.quecomemos.persistencia.emf.EMF;

import java.util.List;

public class GenericDAOHibernateJPA<T> implements GenericDAO<T> {
    protected Class<T> persistentClass;

    public GenericDAOHibernateJPA(Class<T> clase) {
        this.persistentClass = clase;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    @Override
    public T persist(T entity) {
        EntityManager em = EMF.getEMF().createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.persist(entity);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw e; // escribir en un log o mostrar un mensaje
        } finally {
            em.close();
        }
        return entity;
    }

    @Override
    public T update(T entity) {
        EntityManager em = EMF.getEMF().createEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        T entityMerged = em.merge(entity);
        etx.commit();
        em.close();
        return entityMerged;
    }

    @Override
    public void delete(T entity) {
        EntityTransaction tx = null;
        try (EntityManager em = EMF.getEMF().createEntityManager()) {
            tx = em.getTransaction();
            tx.begin();
            em.remove(em.merge(entity));
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw e; // escribir en un log o mostrar un mensaje
        }
    }

    @Override
    public void delete(Long id) {
        EntityManager em = EMF.getEMF().createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            T entity = this.get(id);
            if (entity != null) {
                if (em.contains(entity)) {
                    em.remove(entity);
                } else {
                    em.remove(em.merge(entity));
                }
            }
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public List<T> getAll(String columnOrder) {
        Query consulta =
                EMF.getEMF().createEntityManager().createQuery("SELECT e FROM " + getPersistentClass().getSimpleName() + " e order by e." + columnOrder);
        List<T> resultado = (List<T>) consulta.getResultList();
        return resultado;
    }

    @Override
    public T get(Long id) {
        EntityManager em = EMF.getEMF().createEntityManager();
        T entity = em.find(this.getPersistentClass(), id);
        em.close();
        return entity;
    }
}
