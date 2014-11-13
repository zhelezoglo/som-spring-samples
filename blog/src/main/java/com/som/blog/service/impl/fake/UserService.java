package com.som.blog.service.impl.fake;

import com.som.blog.domain.User;
import com.som.blog.service.IUserService;
import com.som.blog.util.CheckNotEmpty;
import com.som.blog.util.CheckNotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * @author me
 */
public class UserService extends AbstractGenericService<User> implements IUserService {

    protected static Map<Long, User> storage = new HashMap<Long, User>();

    @Override
    protected Map<Long, User> storage() {
        return storage;
    }

    @Override
    public User getUserByLoginAndPassword(String login, String password) throws IllegalArgumentException {
        CheckNotNull.throwIllegalArgument("Login", login);
        CheckNotNull.throwIllegalArgument("Password", password);
        for (User user : getAllEntities()) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean isUserExist(String login) {
        CheckNotNull.throwIllegalArgument("Login", login);
        CheckNotEmpty.throwIllegalArgument("Login", login);
        for (User user : getAllEntities()) {
            if (user.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }
}
