package com.som.eccel.controller;

public class GreenHouseController {
    public static void main(String[] args) {
        GreenHouseControls houseControls = new GreenHouseControls();

        houseControls.addEvent(houseControls.new Bell(900));
        Event[] events = {
                houseControls.new LightOn(200),
                houseControls.new LightOff(400),
                houseControls.new WaterOn(600),
                houseControls.new WaterOff(800)
        };
        houseControls.addEvent(houseControls.new Restart(2000, events));
        houseControls.run();
    }
}
