package com.som.spring.samples.in.action.idol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public aspect JudgeAspect {
    final Logger logger = LoggerFactory.getLogger(JudgeAspect.class);

    private CriticismEngine criticismEngine;

    public JudgeAspect() {
    }

    pointcut performance(): execution(* perform(..));

    after() returning(): performance() {
        logger.info(criticismEngine.getCriticism());
    }

    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }
}
