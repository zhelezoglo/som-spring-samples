package com.som.blog.repository;

import com.som.blog.config.ApplicationConfig;
import com.som.blog.domain.User;
import com.som.blog.domain.base.UserRole;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author som
 */
@ContextConfiguration(classes = ApplicationConfig.class)
public class UserRepositoryTest extends AbstractIntegrationTest{

    @Autowired
    IUserRepository repository;

    @Test
    public void savesUserCorrectly() {

        User user = new User("som", "passwd234", "som@som.com", UserRole.AUTHOR);

        User resultUser = repository.save(user);

        assertThat(resultUser.getId(), is(notNullValue()));
    }

//    @Test
//    public void readsCustomerByEmail() {
//
//        EmailAddress email = new EmailAddress("alicia@keys.com");
//        Customer alicia = new Customer("Alicia", "Keys");
//        alicia.setEmailAddress(email);
//
//        repository.save(alicia);
//
//        Customer result = repository.findByEmailAddress(email);
//        assertThat(result, is(alicia));
//    }
//
//    @Test
//    public void preventsDuplicateEmail() {
//
//        Customer dave = repository.findByEmailAddress(new EmailAddress("dave@dmband.com"));
//
//        Customer anotherDave = new Customer("Dave", "Matthews");
//        anotherDave.setEmailAddress(dave.getEmailAddress());
//
//        repository.save(anotherDave);
//    }
}
