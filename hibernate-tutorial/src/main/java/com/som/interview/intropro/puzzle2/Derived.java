package com.som.interview.intropro.puzzle2;

class Base{
    String s = new String("Base");

    Base() {
        init(s);
    }

    void init(String s){
        System.out.println("s = " + s);
    }
}

public class Derived extends Base{
    String s = new String("Derived");

    void init(String s){
        System.out.println("s = " + s);
    }

    public static void main(String[] args) {
        Base instance = new Derived();
    }
}


