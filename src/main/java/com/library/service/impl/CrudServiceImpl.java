package com.library.service.impl;

import com.library.repository.CrudRepository;
import com.library.service.CrudService;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

public abstract class CrudServiceImpl<E, PK extends Serializable, R extends CrudRepository<E, PK>> implements CrudService<E, PK> {

    @Override
    @Transactional
    public void save(E entity) {
        getRepository().save(entity);
    }

    @Override
    @Transactional
    public void update(E entity) {
        getRepository().update(entity);
    }

    @Override
    @Transactional
    public void delete(PK primaryKey) {
        getRepository().delete(primaryKey);
    }

    @Override
    public E find(PK primaryKey) {
        return getRepository().find(primaryKey);
    }

    @Override
    public List<E> findAll() {
        return getRepository().findAll();
    }

    @Override
    public abstract R getRepository();
}
