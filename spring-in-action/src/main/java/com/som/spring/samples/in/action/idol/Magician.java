package com.som.spring.samples.in.action.idol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Magician implements MindReader {
    final Logger logger = LoggerFactory.getLogger(Magician.class);

    private String thoughts;

    @Override
    public void interceptThoughts(String thoughts) {
        logger.info("Intercepting volunteer's thoughts: {}", thoughts);
        this.thoughts = thoughts;
    }

    @Override
    public String getThoughts() {
        return thoughts;
    }
}
