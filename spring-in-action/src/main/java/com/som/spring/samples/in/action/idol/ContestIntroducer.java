package com.som.spring.samples.in.action.idol;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class ContestIntroducer {
    @DeclareParents(value = "Performer+", defaultImpl = GraciousContestant.class)
    public static Contestant contestant;
}
