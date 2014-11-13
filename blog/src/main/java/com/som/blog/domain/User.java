package com.som.blog.domain;

import com.som.blog.domain.base.DomainObject;
import com.som.blog.domain.base.UserRole;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * @author som
 */
@Entity
@Table(name = "users")
public class User extends DomainObject {

    private String login;

    private String password;

    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole role;

//    @Temporal(TemporalType.DATE)
//    private Date cratedAt;

    public User(String login, String password, String email, UserRole role) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    protected User() {
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
