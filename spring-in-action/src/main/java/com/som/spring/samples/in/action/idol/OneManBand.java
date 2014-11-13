package com.som.spring.samples.in.action.idol;

import java.util.Set;

public class OneManBand implements Performer {

    private Set<Instrument> instruments;

    @Override
    public void perform() throws PerformanceException {
        for (Instrument instrument : instruments) {
            instrument.play();
        }
    }

    public void setInstruments(Set<Instrument> instruments) {
        this.instruments = instruments;
    }
}
