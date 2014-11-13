package com.som.blog.domain.base;

import javax.persistence.Embeddable;

/**
 * @author me
 */
@Embeddable
public enum UserRole {

    ADMIN,

    AUTHOR,

    GUEST

}
