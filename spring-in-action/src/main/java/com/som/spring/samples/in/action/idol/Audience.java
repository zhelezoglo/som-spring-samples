package com.som.spring.samples.in.action.idol;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Audience {
    final Logger logger = LoggerFactory.getLogger(Audience.class);

    public void takeSeats() {
        logger.info("The audience is taking their seats.");
    }

    public void turnOffCellPhones() {
        logger.info("The audience is turning off their cell phones");
    }

    public void applaud() {
        logger.info("CLAP CLAP CLAP CLAP CLAP");
    }


    public void demandRefund() {
        logger.info("Boo! We want our money back!");
    }

    public void watchPerformance(ProceedingJoinPoint joinPoint) {
        try {
            takeSeats();
            turnOffCellPhones();
            long start = System.currentTimeMillis();
            joinPoint.proceed();
            long end = System.currentTimeMillis();
            logger.info("The performance took {} milliseconds", end - start);
        } catch (Throwable throwable) {
            demandRefund();
        }
    }
}
