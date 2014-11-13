package com.som.hib.validator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @author som
 */
public abstract class Vehicle {

    private static Validator validator;

    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    //@NotNull
    private final Integer vehicleId;

    public Vehicle(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;

        Vehicle vehicle = (Vehicle) o;

        if (vehicleId != vehicle.vehicleId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return vehicleId != null ? vehicleId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                '}';
    }

    public <T> void validate(T objectToValidate) throws MessageValidationException {
        Set<ConstraintViolation<T>> constraintViolations =
                validator.validate(objectToValidate);

        if (0 < constraintViolations.size()) {
            StringBuilder errorMessage = new StringBuilder("\n\tNext restrictions are violated:");
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                errorMessage.append("\n\t\t[ ");
                errorMessage.append(constraintViolation.getRootBeanClass().getSimpleName());
                errorMessage.append(".");
                errorMessage.append(constraintViolation.getPropertyPath());
                errorMessage.append(" = ");
                errorMessage.append(constraintViolation.getInvalidValue());
                errorMessage.append(" ] - ");
                errorMessage.append(constraintViolation.getMessage());
            }
            throw new MessageValidationException(errorMessage.toString());
        }
    }

}
