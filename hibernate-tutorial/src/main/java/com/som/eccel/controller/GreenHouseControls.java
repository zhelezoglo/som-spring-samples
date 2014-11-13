package com.som.eccel.controller;

public class GreenHouseControls extends Controller {
    private boolean light = false;

    public class LightOn extends Event {
        @Override
        public void action() {
            // call hardware here to switch on the light
            light = true;
        }

        public LightOn(long delayTime) {
            super(delayTime);

        }

        @Override
        public String toString() {
            return "The light is switched on";
        }
    }

    public class LightOff extends Event {
        @Override
        public void action() {
            // call hardware here to switch off the light
            light = false;
        }

        public LightOff(long delayTime) {
            super(delayTime);

        }

        @Override
        public String toString() {
            return "The light is switched off";
        }
    }

    public boolean water = false;

    public class WaterOn extends Event {
        @Override
        public void action() {
            // call hardware here to switch on the water
            water = true;
        }

        public WaterOn(long delayTime) {
            super(delayTime);

        }

        @Override
        public String toString() {
            return "The water is switched on";
        }
    }

    public class WaterOff extends Event {
        @Override
        public void action() {
            // call hardware here to switch off the light
            water = false;
        }

        public WaterOff(long delayTime) {
            super(delayTime);

        }

        @Override
        public String toString() {
            return "The water is switched off";
        }
    }

    public class Bell extends Event {
        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }

        @Override
        public String toString() {
            return "Bang!";
        }
    }

    public class Restart extends Event {
        private Event[] events;

        public Restart(long delayTime, Event[] events) {
            super(delayTime);
            this.events = events;
            for (Event event : events) {
                addEvent(event);
            }
        }

        @Override
        public void action() {
            for (Event event : events) {
                event.start();
                addEvent(this);
            }
        }

        @Override
        public String toString() {
            return "System restart";
        }
    }

    public static class Terminate extends Event {
        public Terminate(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "Disconnection";
        }
    }

}
