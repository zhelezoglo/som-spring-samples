package com.som.spring.samples.in.action.idol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GraciousContestant implements Contestant {

    final Logger logger = LoggerFactory.getLogger(GraciousContestant.class);

    @Override
    public void receiveAward() {
        logger.info("AWARDING CONTESTANT");
    }
}
