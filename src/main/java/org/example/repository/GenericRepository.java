package org.example.repository;

import java.util.List;

public interface GenericRepository<T, ID> {
    void save(T entity);
    T findById(ID id);
    List<T> findAll();
    void delete(T entity);
}