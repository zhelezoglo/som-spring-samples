package com.som.spring.samples.in.action.idol;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Service {

    final Logger logger = LoggerFactory.getLogger(Service.class);

    private ApplicationContext context = new ClassPathXmlApplicationContext("spring-idol.xml");

    public String magicianShouldReadVolunteersMind(String thought) {
        Thinker thinker = (Thinker) context.getBean("volunteer");
        thinker.thinkOfSomething(thought);
        return thinker.getThoughts();
    }

    public void awardContestant() {
        Contestant contestant = (Contestant) context.getBean("duke");
        try {
            contestant.receiveAward();
        } catch (Exception e) {
            logger.error("CANNOT AWARD!", e);
        }
    }

    public void performDuke() {
        Performer performer = (Performer) context.getBean("duke");
        try {
            performer.perform();
        } catch (PerformanceException e) {
            logger.error("CANNOT PERFORM!", e);
        }
    }

    public void performPoeticDuke() {
        Performer performer = (Performer) context.getBean("poeticDuke");
        try {
            performer.perform();
        } catch (PerformanceException e) {
            logger.error("CANNOT PERFORM!", e);
        }
    }

    public void performKenny() {
        Performer performer = (Performer) context.getBean("kenny");
        try {
            performer.perform();
        } catch (PerformanceException e) {
            logger.error("CANNOT PERFORM!", e);
        }
    }

    public void performHank() {
        Performer performer = (Performer) context.getBean("hank");
        try {
            performer.perform();
        } catch (PerformanceException e) {
            logger.error("CANNOT PERFORM!", e);
        }
    }

}
