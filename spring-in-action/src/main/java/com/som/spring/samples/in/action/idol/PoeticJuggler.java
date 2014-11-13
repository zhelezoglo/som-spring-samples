package com.som.spring.samples.in.action.idol;


import org.slf4j.LoggerFactory;

public class PoeticJuggler extends Juggler {

    {
        logger = LoggerFactory.getLogger(PoeticJuggler.class);
    }

    private Poem poem;

    public PoeticJuggler(Poem poem) {
        super();
        this.poem = poem;
    }

    public PoeticJuggler(int beanBags, Poem poem) {
        super(beanBags);
        this.poem = poem;
    }

    @Override
    public void perform() throws PerformanceException {
        super.perform();
        logger.info("While reciting...");
        poem.recite();
    }
}
