package com.som.spring.samples.in.action.idol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Volunteer implements Thinker {

    final Logger logger = LoggerFactory.getLogger(Volunteer.class);

    String thoughts;

    @Override
    public void thinkOfSomething(String thoughts) {
        logger.info("I'm thinking of {}", thoughts);
        this.thoughts = thoughts;
    }

    @Override
    public String getThoughts() {
        return thoughts;
    }
}
