package com.som.spring.samples.in.action.idol;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Auditorium {

    final Logger logger = LoggerFactory.getLogger(Auditorium.class);

    public void turnOnLights() {
        logger.info("LIGHTS are turned ON");
    }

    public void turnOffLights() {
        logger.info("LIGHTS are turned OFF");
    }
}
