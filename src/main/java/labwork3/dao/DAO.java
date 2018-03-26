package labwork3.dao;

import labwork3.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class DAO<T, K> implements InterfaceDAO<T, K> {

    private Class<T> tClass;

    public DAO(Class<T> tClass) {
        this.tClass = tClass;
    }

    @Override
    public List<T> selectAll() {
        EntityManager entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
        String queryString = "FROM " + tClass.getSimpleName();
        TypedQuery<T> query = entityManager.createQuery(queryString, tClass);
        List<T> result = new ArrayList<>();
        result = query.getResultList();
        entityManager.close();
        return result;

    }

    @Override
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

    @Override
    public T select(K key) {
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

    @Override
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

    public void deleteByKey(K key) {
        EntityManager entityManager = null;
        try {
            entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();
            T entity = entityManager.find(tClass, key);
            System.out.println(entity);
            entityManager.remove(entityManager.merge(entity));
            entityManager.flush();
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
