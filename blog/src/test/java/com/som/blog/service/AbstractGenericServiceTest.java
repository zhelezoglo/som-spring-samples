package com.som.blog.service;

import com.som.blog.domain.base.DomainObject;
import com.som.blog.service.exceptions.GeneralServiceException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.GenericApplicationContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author notme
 */
public abstract class AbstractGenericServiceTest<T extends DomainObject> {

    /**
     * Spring application context to use in tests
     */
    protected static GenericApplicationContext appContext;

    /**
     * Obtaining Spring context for testing
     */
    @BeforeClass
    public static void obtainApplicationContext() {
//        appContext = ApplicationConfig.getApplicationContext();
        assertNotNull("Application context was not created", appContext);
    }

    /**
     * Get the service to use for testing
     */
    protected abstract IGenericService<T> getService();

    /**
     * Get the first entity for testing
     */
    protected abstract T getFirstEntity();

    /**
     * Get the first entity for testing
     */
    protected abstract T getSecondEntity();

    /**
     * Entity that is saved before tests and deleted afterwards
     */
    protected T entity1;
    /**
     * Entity that is saved before tests and deleted afterwards
     */
    protected T entity2;

    /**
     * Saving entities to database, before each test
     *
     * @throws GeneralServiceException
     * @throws IllegalArgumentException
     */
    @Before
    public void saveEntitiesToDatabase() throws IllegalArgumentException,
            GeneralServiceException {
        entity1 = getService().save(getFirstEntity());
        entity2 = getService().save(getSecondEntity());

        assertNotNull("Entity1 were not saved successfully", entity1);
        assertNotNull("Entity2 were not saved successfully", entity2);
    }

    /**
     * Deleting entities from database if their reference is not null
     *
     * @throws IllegalArgumentException
     * @throws GeneralServiceException
     */
    @After
    public void deleteEntitiesFromDatabase() throws IllegalArgumentException,
            GeneralServiceException {
        if (entity1 != null) {
            getService().delEntity(entity1);
        }
        if (entity2 != null) {
            getService().delEntity(entity2);
        }
    }

    /**
     * Test method for
     *
     * @throws GeneralServiceException
     * @throws IllegalArgumentException
     */
    @Test
    public void testGetAllEntitiesCount() throws IllegalArgumentException,
            GeneralServiceException {
        long cnt = getService().getAllEntitiesCount();

        getService().delEntity(entity1);
        entity1 = null;

        long cnt2 = getService().getAllEntitiesCount();

        assertEquals(cnt - 1, cnt2);

        entity1 = getService().save(getFirstEntity());

        cnt2 = getService().getAllEntitiesCount();

        assertEquals(cnt, cnt2);
    }

    /**
     * Test method for
     * . Testing that <code>null</code> entity cannot be saved. Saving of normal
     * entity is indirectly tested in before and other methods.
     *
     * @throws GeneralServiceException
     * @throws IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSaveTIllegalArgument() throws IllegalArgumentException,
            GeneralServiceException {
        getService().save(null);
    }

    /**
     * Test method for
     *
     * @throws GeneralServiceException
     * @throws IllegalArgumentException
     */
    @Test
    public void testDelEntityLong() throws IllegalArgumentException, GeneralServiceException {
        long cnt = getService().getAllEntitiesCount();

        // Nothing should happen for deleting inexistent entity
        getService().delEntity(System.currentTimeMillis());

        assertEquals(cnt, getService().getAllEntitiesCount());

        // should delete successfully entity1
        getService().delEntity(entity1.getId());

        assertEquals(cnt - 1, getService().getAllEntitiesCount());

        assertNull(getService().getEntity(entity1.getId()));

        // Setting entity1 to null, so in @After method it will not be deleted again
        entity1 = null;
    }

    /**
     * Test method for
     *
     * @throws GeneralServiceException
     * @throws IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDelEntityLongIllegalArgument() throws IllegalArgumentException, GeneralServiceException {
        getService().delEntity((Long) null);
    }

    /**
     * Test method for
     * <p/>
     * Testing that <code>null</code> entity cannot be deleted. Deleting of normal
     * entity is indirectly tested in after and other methods.
     *
     * @throws GeneralServiceException
     * @throws IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDelEntityTIllegalArgument() throws IllegalArgumentException, GeneralServiceException {
        getService().delEntity((T) null);
    }

    /**
     * Test method for
     *
     * @throws GeneralServiceException
     * @throws IllegalArgumentException
     */
    @Test
    public void testDelAllEntities() throws IllegalArgumentException, GeneralServiceException {
        long cnt = getService().getAllEntitiesCount();

        Collection<Long> list = new ArrayList<Long>();
        list.add(entity1.getId());
        list.add(entity2.getId());

        getService().delAllEntities(list);

        assertEquals(cnt - 2, getService().getAllEntitiesCount());

        // Setting entities to null, so they will not deleted second time in @after method
        entity1 = null;
        entity2 = null;
    }

    /**
     * Test method for
     *
     * @throws GeneralServiceException
     * @throws IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDelAllEntitiesIllegalArgument() throws IllegalArgumentException, GeneralServiceException {
        getService().delAllEntities(null);
    }

    /**
     * Test method for
     */
    @Test
    public void testGetAllEntites() {
        Collection<T> list = getService().getAllEntities();

        assertNotNull(list);
        assertFalse(list.isEmpty());

        assertTrue(list.contains(entity1));
        assertTrue(list.contains(entity2));
    }

    /**
     * Test method for
     */
    @Test
    public void testGetEntityById() {
        assertNull(getService().getEntity(System.nanoTime()));

        T foundEntity = getService().getEntity(entity1.getId());
        assertNotNull(foundEntity);
        assertEquals(entity1, foundEntity);

        foundEntity = getService().getEntity(entity2.getId());
        assertNotNull(foundEntity);
        assertEquals(entity2, foundEntity);
    }

    /**
     * Test method for
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetEntityByIdIllegalArgument() {
        getService().getEntity(null);
    }

    /**
     * Test method for
     */
//    @Test
    public void testGetAllSorted() {
        List<T> rez = getService().getAllSorted("id", true);
        assertNotNull(rez);
        assertTrue(rez.contains(entity1));
        assertTrue(rez.contains(entity2));

        int index1 = rez.indexOf(entity1);
        int index2 = rez.indexOf(entity2);

        if (entity1.getId().compareTo(entity2.getId()) < 0) {
            assertTrue(index1 < index2);
        } else {
            assertTrue(index1 > index2);
        }

        rez = getService().getAllSorted("id", false);
        assertNotNull(rez);
        assertTrue(rez.contains(entity1));
        assertTrue(rez.contains(entity2));

        index1 = rez.indexOf(entity1);
        index2 = rez.indexOf(entity2);

        if (entity1.getId().compareTo(entity2.getId()) < 0) {
            assertTrue(index1 > index2);
        } else {
            assertTrue(index1 < index2);
        }
    }

    /**
     * Test method for
     */
//    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSortedIllegalArgument() {
        getService().getAllSorted(null, true);
    }

    /**
     * Test method for
     */
    @Test
    public void testGetEntitiesByIds() {
        List<Long> list = new ArrayList<Long>();
        list.add(entity1.getId());
        list.add(System.nanoTime());

        Collection<T> rez = getService().getEntities(list);
        assertNotNull(rez);
        assertEquals(1, rez.size());
        assertTrue(rez.contains(entity1));

    }

    /**
     * Test method for
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetEntitiesByIdsIllegalArgument() {
        getService().getEntities(null);
    }

}
