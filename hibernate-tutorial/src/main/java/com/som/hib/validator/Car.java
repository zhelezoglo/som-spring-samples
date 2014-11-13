package com.som.hib.validator;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Car extends Vehicle implements ICar {

    @NotNull
    private String manufacturer;

    @NotNull
    @Size(min = 2, max = 14)
    private String licensePlate;

    @NotNull
    @Valid
    private final Engine engine;

    @Min(2)
    private int seatCount;

    public Car(Integer vehicleId, String manufacturer, String licencePlate, Engine engine, int seatCount) {
        super(vehicleId);
        this.manufacturer = manufacturer;
        this.licensePlate = licencePlate;
        this.engine = engine;
        this.seatCount = seatCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        if (!super.equals(o)) return false;

        Car car = (Car) o;

        if (seatCount != car.seatCount) return false;
        if (engine != null ? !engine.equals(car.engine) : car.engine != null) return false;
        if (licensePlate != null ? !licensePlate.equals(car.licensePlate) : car.licensePlate != null) return false;
        if (manufacturer != null ? !manufacturer.equals(car.manufacturer) : car.manufacturer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (licensePlate != null ? licensePlate.hashCode() : 0);
        result = 31 * result + (engine != null ? engine.hashCode() : 0);
        result = 31 * result + seatCount;
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacturer='" + manufacturer + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", engine=" + engine +
                ", seatCount=" + seatCount +
                ", " + super.toString() + "}";
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }
}