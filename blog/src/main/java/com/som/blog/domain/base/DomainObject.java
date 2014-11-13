package com.som.blog.domain.base;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Locale;


/**
 * General class for all entities, that makes it possible to store them in DB.
 *
 * @author Notme
 */
@MappedSuperclass
public abstract class DomainObject implements Serializable {


    /**
     * Unique identifier.
     */
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = null;

    /**
     * Default locale to use
     */
    @Transient
    private Locale defLocale = new Locale("ua", "UA");

    /**
     * Simple plain constructor
     */
    public DomainObject() {
        id = null;
    }

    /**
     * Constructor that sets the id parameter
     *
     * @param id Id of the object to set
     */
    public DomainObject(Long id) {
        this.id = id;
    }


    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }


    /*
 * (non-Javadoc)
 * @see java.lang.Object#equals(java.lang.Object)
 */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (this.id == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
            return false;
        }

        DomainObject that = (DomainObject) obj;

        return this.id.equals(that.getId());
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }
}
