package com.som.spring.samples.in.action.idol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Piano implements Instrument {
    final Logger logger = LoggerFactory.getLogger(Piano.class);

    @Override
    public void play() {
        logger.info("\tPLINK PLINK PLINK");
    }
}
