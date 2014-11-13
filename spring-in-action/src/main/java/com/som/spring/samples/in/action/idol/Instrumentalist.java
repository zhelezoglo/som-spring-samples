package com.som.spring.samples.in.action.idol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Instrumentalist implements Performer {
    final Logger logger = LoggerFactory.getLogger(Instrumentalist.class);

    private String song;

    private Instrument instrument;

    @Override
    public void perform() throws PerformanceException {
        logger.info("Playing {} : ", song);
        instrument.play();
    }

    public String getSong() {
        return song;
    }

    public String screamSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }
}
