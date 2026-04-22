package org.example.repository;

import jakarta.persistence.EntityManager;
import java.util.List;

public abstract class GenericRepositoryImpl<T, ID> implements GenericRepository<T, ID> {

    protected final EntityManager em;
    private final Class<T> clazz;

    public GenericRepositoryImpl(EntityManager em, Class<T> clazz) {
        this.em = em;
        this.clazz = clazz;
    }

    @Override
    public void save(T entity) {
        em.persist(entity);
    }

    @Override
    public T findById(ID id) {
        return em.find(clazz, id);
    }

    @Override
    public List<T> findAll() {
        return em.createQuery("from " + clazz.getSimpleName(), clazz)
              .getResultList();
    }

    @Override
    public void delete(T entity) {
        em.remove(entity);
    }
}