package com.som.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author som
 */
public class WildCards {

    public static void main(String[] args) {

        Set<String> stringList = new HashSet<>();
        Set<Integer> integerList = new HashSet<>();
        Set voidList = new HashSet<>();
        Set<?> voidList2 = new HashSet<>();
        print(stringList);
        print(integerList);
        print(voidList);


        Collection<?> c = new ArrayList<String>();
        c.add(null);

        Collection c2 = new ArrayList<String>();
        c2.add("foo");
        c2.add(new Integer(300));
        c2.add(new Object());

    }

    static void print(Set objects){
        for (Object object : objects) {
            System.out.print(object);
        }
        System.out.println();
    }
}
