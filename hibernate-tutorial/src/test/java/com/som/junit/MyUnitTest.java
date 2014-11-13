package com.som.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MyUnitTest {
    private Integer testNumber;

    public MyUnitTest(Integer myTestNumber) {
        this.testNumber = myTestNumber;
    }

    @Test
    public void testMethod() throws Exception {
        System.out.println(testNumber);

    }

    @Parameterized.Parameters
    public static Collection testNumbers() {
//        return Arrays.asList(new Object[][]{{1},{2}});
        return Arrays.asList(new Object[][]{{1}, {2}, {3}});
    }
}