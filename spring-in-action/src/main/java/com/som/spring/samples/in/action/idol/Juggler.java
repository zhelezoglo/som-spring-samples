package com.som.spring.samples.in.action.idol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Juggler implements Performer {

    Logger logger = LoggerFactory.getLogger(Juggler.class);

    private int beanBags = 3;

    public Juggler() {
    }

    public Juggler(int beanBags) {
        this.beanBags = beanBags;
    }

    @Override
    public void perform() throws PerformanceException {
        logger.info("JUGGLING {} BEANBAGS", beanBags);
    }
}
