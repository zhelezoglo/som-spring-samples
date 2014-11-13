package com.som.hib.validator;

import org.hibernate.validator.constraints.Range;

/**
 * @author som
 */
public class Cylinder {

    @Range(min = 2, max = 3)
    private final Integer place;

    public Cylinder(Integer place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cylinder)) return false;

        Cylinder cylinder = (Cylinder) o;

        if (place != null ? !place.equals(cylinder.place) : cylinder.place != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return place != null ? place.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "place=" + place +
                '}';
    }
}
