package com.som.blog.service;

import com.som.blog.domain.User;
import com.som.blog.domain.base.UserRole;
import com.som.blog.service.exceptions.GeneralServiceException;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

/**
 * @author som
 */
@Ignore
public class UserServiceTest extends AbstractGenericServiceTest<User> {

    /**
     * Getting user service from context
     *
     * @return IUserService implementation
     */
    protected IUserService getUserService() {
        return appContext.getBean(IUserService.class);
    }

    /*
     *
     */
    @Override
    protected User getFirstEntity() {
        User user = new User("aaa", "aaa", "ddd", UserRole.AUTHOR);
        return user;
    }


    /*
     *
     */
    @Override
    protected User getSecondEntity() {
        User user = new User("bbb", "bbb", "eee", UserRole.AUTHOR);
        return user;
    }

    @Override
    protected IGenericService<User> getService() {
        return getUserService();
    }

    /**
     * Test method for
     *
     * @throws GeneralServiceException
     * @throws IllegalArgumentException
     */
    public void testSaveUser() throws IllegalArgumentException,
            GeneralServiceException {
        getUserService().save(getFirstEntity());
    }

    /**
     * Test method for
     *
     * @throws GeneralServiceException
     * @throws IllegalArgumentException
     */
    @Test
    public void testGetUserByLoginAndPassword()
            throws IllegalArgumentException, GeneralServiceException {
        User foundUser = getUserService().getUserByLoginAndPassword(
                entity1.getLogin(), entity1.getPassword());

        assertNotNull(foundUser);
        assertNotNull(foundUser.getId());
        assertEquals(entity1.getLogin(), foundUser.getLogin());
        assertEquals(entity1.getPassword(), foundUser.getPassword());

        foundUser = getUserService().getUserByLoginAndPassword(
                entity2.getLogin(), entity2.getPassword());

        assertNotNull(foundUser);
        assertNotNull(foundUser.getId());
        assertEquals(entity2.getLogin(), foundUser.getLogin());
        assertEquals(entity2.getPassword(), foundUser.getPassword());
    }

    /**
     * Test method for
     *
     * @throws GeneralServiceException
     * @throws IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetUserByLoginAndPasswordIllegalLogin()
            throws IllegalArgumentException, GeneralServiceException {
        getUserService().getUserByLoginAndPassword(null, "asdf");
    }

    /**
     * Test method for
     * .
     *
     * @throws com.som.blog.service.exceptions.GeneralServiceException
     *
     * @throws IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetUserByLoginAndPasswordIllegalPassword()
            throws IllegalArgumentException, GeneralServiceException {
        getUserService().getUserByLoginAndPassword("asdf", null);
    }

    /**
     * Test method for
     * .
     */
    // @Test
    public void testGetVIPUsers() {
//        Collection<User> collection = getUserService().getVIPUsers();
        Collection<User> collection = null;
        assertNotNull(collection);
        assertFalse(collection.isEmpty());

        assertTrue(collection.contains(entity1));
        assertFalse(collection.contains(entity2));
    }

    /**
     * Test method for
     * .
     */
    @Test
    public void testIsUserExists() {
        assertTrue(getUserService().isUserExist(entity1.getLogin()));
        assertTrue(getUserService().isUserExist(entity2.getLogin()));

    }

    /**
     * Test method for
     * .
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIsUserExistsLoginNull() {
        assertFalse(getUserService().isUserExist(null));
    }

    /**
     * Test method for
     * .
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIsUserExistsLoginBlank() {
        assertFalse(getUserService().isUserExist(""));
    }
}
