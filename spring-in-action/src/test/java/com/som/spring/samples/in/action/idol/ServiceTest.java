package com.som.spring.samples.in.action.idol;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ServiceTest {
    private static Service service = new Service();


    @Before
    public void setUp() {
        System.out.println();
    }

    @Test
    public void testMagicianShouldReadVolunteersMind() {
        System.out.println("\t\tServiceTest.testMagicianShouldReadVolunteersMind");
        final String thoughtToThink = "Queen Of Hearts";
        String interceptedThought = service.magicianShouldReadVolunteersMind(thoughtToThink);
        Assert.assertEquals(thoughtToThink, interceptedThought);
    }

    //@Test  // TODO: fix and add AspectJ
    public void testAwardContestant() {
        System.out.println("\t\tServiceTest.testAwardContestant");
        service.awardContestant();
    }

    @Test
    public void testPerformDuke() {
        System.out.println("\t\tServiceTest.testPerformDuke");
        service.performDuke();
    }

    @Test
    public void testPerformPoeticDuke() {
        System.out.println("\t\tServiceTest.testPerformPoeticDuke");
        service.performPoeticDuke();
    }

    @Test
    public void testPerformKenny() {
        System.out.println("\t\tServiceTest.testPerformKenny");
        service.performKenny();
    }

    @Test
    public void testPerformHank() {
        System.out.println("\t\tServiceTest.testPerformHank");
        service.performHank();
    }

    @After
    public void tearDown() {
        System.out.println();
    }
}
