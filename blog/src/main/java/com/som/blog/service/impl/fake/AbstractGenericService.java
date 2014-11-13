package com.som.blog.service.impl.fake;


import com.som.blog.domain.base.DomainObject;
import com.som.blog.service.IGenericService;
import com.som.blog.service.exceptions.GeneralServiceException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public abstract class AbstractGenericService<T extends DomainObject> implements IGenericService<T> {

    protected abstract Map<Long, T> storage();

    protected static <T extends DomainObject> void checkThrowEntityNull(T entity) throws IllegalArgumentException {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
    }

    protected static void checkThrowIdsListNull(Collection<Long> ids) throws IllegalArgumentException {
        if (ids == null) {
            throw new IllegalArgumentException("Ids cannot be null");
        }
    }

    protected static void checkThrowIdNull(Long id) throws IllegalArgumentException {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
    }

    @Override
    public void delEntity(Long id) throws IllegalArgumentException, GeneralServiceException {
        checkThrowIdNull(id);
        storage().remove(id);
    }

    @Override
    public void delEntity(T entity) throws IllegalArgumentException, GeneralServiceException {
        checkThrowEntityNull(entity);
        delEntity(entity.getId());
    }

    @Override
    public void delAllEntities(Collection<Long> ids) throws IllegalArgumentException, GeneralServiceException {
        checkThrowIdsListNull(ids);
        for (Long id : ids) {
            delEntity(id);
        }
    }

    @Override
    public T getEntity(Long id) throws IllegalArgumentException {
        checkThrowIdNull(id);
        return storage().get(id);
    }

    @Override
    public List<T> getAllEntities() {
        return new ArrayList<T>(storage().values());
    }

    @Override
    public T save(T entity) throws IllegalArgumentException, GeneralServiceException {
        checkThrowEntityNull(entity);
        if (entity.getId() == null) {
            entity.setId(System.nanoTime());
            storage().put(entity.getId(), entity);
        }
        return entity;
    }

    @Override
    public long getAllEntitiesCount() {
        return storage().size();
    }

    @Override
    public List<T> getAllSorted(String propertySortBy, boolean asc) throws IllegalArgumentException {
        return null;  // TODO
    }

    @Override
    public List<T> getEntities(List<Long> ids) throws IllegalArgumentException {
        checkThrowIdsListNull(ids);
        List<T> foundEntities = new ArrayList<T>(ids.size());
        for (Long id : ids) {
            T entity = getEntity(id);
            if (entity == null) continue;
            foundEntities.add(entity);
        }
        return foundEntities;
    }
}
