package com.som.hib.validator;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * @author som
 */
public class Engine {
    private final int hps;

    @Min(value = 1000L)
    @Max(value = 1200L)
    private final Long capacity;

    private final String brand;

    @Valid
    private final List<Cylinder> cylinders;

    public Engine(int hps, Long capacity, String brand, List<Cylinder> cylinders) {
        this.hps = hps;
        this.capacity = capacity;
        this.brand = brand;
        this.cylinders = cylinders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Engine)) return false;

        Engine engine = (Engine) o;

        if (hps != engine.hps) return false;
        if (brand != null ? !brand.equals(engine.brand) : engine.brand != null) return false;
        if (capacity != null ? !capacity.equals(engine.capacity) : engine.capacity != null) return false;
        if (cylinders != null ? !cylinders.equals(engine.cylinders) : engine.cylinders != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hps;
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (cylinders != null ? cylinders.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "hps=" + hps +
                ", capacity=" + capacity +
                ", brand=" + brand +
                ", cylinders=" + cylinders +
                '}';
    }
}
