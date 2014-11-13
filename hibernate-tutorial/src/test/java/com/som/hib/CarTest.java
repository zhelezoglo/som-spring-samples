package com.som.hib;

import com.som.hib.validator.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;

@Ignore
public class CarTest {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        validator = factory.getValidator();
    }

    @Test
    public void testCar() throws MessageValidationException {
//        Vehicle car = new Car(null, null, "DD-AB-123", 4);
//        Cylinder cylinder1 = new Cylinder(1);
        Cylinder cylinder2 = new Cylinder(3);
        List<Cylinder> cylinderList = new ArrayList<Cylinder>();
//        cylinderList.add(cylinder1);
        cylinderList.add(cylinder2);
//        Engine engine = new Engine(77, 1600L, "VAZ", cylinderList);
        Engine engine = new Engine(77, 1200L, "VAZ", cylinderList);

        Vehicle car = new Car(2, "2--__aaa3", "DDDD", engine, 4);
//        Vehicle car = new Car(null, null, "DDDD", engine, 4);
//        Vehicle car = new Car(null, "\t", "DDDD", engine, 4);

        car.validate(car);

//        Set<ConstraintViolation<Vehicle>> constraintViolations =
//                validator.validate(car);
//
//
//
//        assertEquals(1, constraintViolations.size());
//        assertEquals("may not be null", constraintViolations.iterator().next().getMessage());
    }

//    @Test
//    public void licensePlateTooShort() {
//        Car car = new Car("Morris", "D", 4);
//
//        Set<ConstraintViolation<Car>> constraintViolations =
//                validator.validate(car);
//
//        assertEquals(1, constraintViolations.size());
//        assertEquals("size must be between 2 and 14", constraintViolations.iterator().next().getMessage());
//    }
//
//    @Test
//    public void seatCountTooLow() {
//        Car car = new Car("Morris", "DD-AB-123", 1);
//
//        Set<ConstraintViolation<Car>> constraintViolations =
//                validator.validate(car);
//
//        assertEquals(1, constraintViolations.size());
//        assertEquals("must be greater than or equal to 2", constraintViolations.iterator().next().getMessage());
//    }
//
//    @Test
//    public void carIsValid() {
//        Car car = new Car("Morris", "DD-AB-123", 2);
//
//        Set<ConstraintViolation<Car>> constraintViolations =
//                validator.validate(car);
//
//        assertEquals(0, constraintViolations.size());
//    }
}