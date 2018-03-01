package com.library.repository.impl;

import com.library.repository.CrudRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class CrudRepositoryImpl<E, PK extends Serializable> implements CrudRepository<E, PK> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<E> entityClass;

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public void save(E entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(E entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(PK id) {
        entityManager.remove(find(id));
    }

    @Override
    public E find(PK id) {
        return entityManager.find(getEntityClass(), id);
    }

    @Override
    public List<E> findAll() {
        String entityName = getEntityClass().getName();
        return entityManager
                .createQuery(String.format("SELECT entity FROM %s entity", entityName), getEntityClass())
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    public Class<E> getEntityClass() {
        if (entityClass == null) {
            entityClass = (Class<E>) ((ParameterizedType)
                    getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return entityClass;
    }
}
