package com.som.spring.samples.in.action.idol;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Saxophone implements Instrument {
    final Logger logger = LoggerFactory.getLogger(Saxophone.class);

    @Override
    public void play() {
        logger.info("\tTOOT TOOT TOOT");
    }
}
