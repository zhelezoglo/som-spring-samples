package com.som.blog.service.impl.real_ts;

import com.som.blog.domain.base.DomainObject;
import com.som.blog.service.IGenericService;
import com.som.blog.service.exceptions.GeneralServiceException;

import java.util.Collection;
import java.util.List;

/**
 * @author som
 */
public abstract class AbstractGenericServiceImpl<T extends DomainObject> implements IGenericService<T> {

    @Override
    public void delEntity(Long id) throws IllegalArgumentException, GeneralServiceException {
        // TODO: Implement
    }

    @Override
    public void delEntity(T entity) throws IllegalArgumentException, GeneralServiceException {
        // TODO: Implement
    }

    @Override
    public void delAllEntities(Collection<Long> ids) throws IllegalArgumentException, GeneralServiceException {
        // TODO: Implement
    }

    @Override
    public T getEntity(Long id) throws IllegalArgumentException {
        return null;  // TODO: Implement
    }

    @Override
    public List<T> getAllEntities() {
        return null;  // TODO: Implement
    }

    @Override
    public T save(T entity) throws IllegalArgumentException, GeneralServiceException {
        return null;  // TODO: Implement
    }

    @Override
    public long getAllEntitiesCount() {
        return 0;  // TODO: Implement
    }

    @Override
    public List<T> getAllSorted(String propertySortBy, boolean asc) throws IllegalArgumentException {
        return null;  // TODO: Implement
    }

    @Override
    public List<T> getEntities(List<Long> ids) throws IllegalArgumentException {
        return null;  // TODO: Implement
    }
}
