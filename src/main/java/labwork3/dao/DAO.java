package labwork3.dao;

import labwork3.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAO<T, K> implements InterfaceDAO<T, K> {

    @Override
    public List<T> selectAll(Class<T> tClass) {
        EntityManager entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
        String queryString = "FROM " + tClass.getSimpleName();
        TypedQuery<T> query = entityManager.createQuery(queryString, tClass);
        return query.getResultList();

    }

    public void create(T entity) {
        EntityManager entityManager = null;
        try {
            entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        }
        catch (PersistenceException e) {
            if (entityManager != null)
                entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            if (entityManager != null)
                entityManager.close();
        }
    }

    public T select(Class<T> tClass, K key) {
        EntityManager entityManager = null;
        try {
            entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
            return entityManager.find(tClass, key);
        }
        catch (PersistenceException e) {
            e.printStackTrace();
        }
        finally {
            if (entityManager != null)
                entityManager.close();
        }
        return null;
    }

    public void update(T entity) {
        EntityManager entityManager = null;
        try {
            entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
        }
        catch (PersistenceException e) {
            if (entityManager != null)
                entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            if (entityManager != null)
                entityManager.close();
        }
    }

    public void delete(T entity) {
        EntityManager entityManager = null;
        try {
            entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        }
        catch (PersistenceException e) {
            if (entityManager != null)
                entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            if (entityManager != null)
                entityManager.close();
        }
    }

}
