package com.som.spring.samples.in.action.idol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sonnet29 implements Poem {
    final Logger logger = LoggerFactory.getLogger(Sonnet29.class);

    private static String[] LINES = {
            "When,indisgracewithfortuneandmen'seyes,",
            "Iallalonebeweepmyoutcaststate",
            "Andtroubledeafheavenwithmybootlesscries",
            "Andlookuponmyselfandcursemyfate,",
            "Wishingmeliketoonemorerichinhope,",
            "Featuredlikehim,likehimwithfriendspossess'd,",
            "Desiringthisman'sartandthatman'sscope,",
            "WithwhatImostenjoycontentedleast;",
            "Yetinthesethoughtsmyselfalmostdespising,",
            "HaplyIthinkonthee,andthenmystate,",
            "Liketothelarkatbreakofdayarising",
            "Fromsullenearth,singshymnsatheaven'sgate;",
            "Forthysweetloveremember'dsuchwealthbrings",
            "ThatthenIscorntochangemystatewithkings."};

    public Sonnet29() {
    }

    public void recite() {
        for (String LINE : LINES) {
            logger.info("\t {}", LINE);
        }
    }
}
