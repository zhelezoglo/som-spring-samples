package com.som.blog.service;

import com.som.blog.domain.User;

/**
 * @author som
 */
public interface IUserService extends IGenericService<User> {


    /**
     * Getting user by its login and password
     *
     * @param login    User login
     * @param password User password
     * @return Found user or <code>null</code>
     * @throws IllegalArgumentException if params are <code>null</code>
     */
    public User getUserByLoginAndPassword(String login, String password)
            throws IllegalArgumentException;

    /**
     * Checking if user with specified login exists
     *
     * @param login Login to find user
     * @return True if user with such login exists, false otherwise
     */
    public boolean isUserExist(String login);


}
