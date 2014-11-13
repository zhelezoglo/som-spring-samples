package com.som.time;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author som
 */
public class Main {
    private static final String DATE_FORMAT = "yy-MM-dd-HH-mmss";
    private static final String TIMEZONE = "Europe/Paris";
    private static final String TIMEZONE_GMT = "GMT";
    private static final String TIMEZONE_GMT_ST = "GMT Standard Time";
    private static final String TIMEZONE_UTC = "UTC";
    private static final String TIMEZONE_PST = "PST";
    private static final String TIMEZONE_LA = "America/Los_Angeles";
    private static final String TIMEZONE_8 = "GMT-8:00";


    protected static SimpleDateFormat createDateFormater(String timeZone) {
        SimpleDateFormat ret = new SimpleDateFormat(DATE_FORMAT);
        ret.setTimeZone(TimeZone.getTimeZone(timeZone));

        return ret;
    }


    public static void main(String[] args) throws Exception {
        System.out.println("Paris " + createDateFormater(TIMEZONE).format(new Date()));
        System.out.println("=================================================================");
        System.out.println("  GMT " + createDateFormater(TIMEZONE_GMT).format(new Date()));
        System.out.println("  GMT " + createDateFormater(TIMEZONE_UTC).format(new Date()));
        System.out.println(" SGMT " + createDateFormater(TIMEZONE_GMT_ST).format(new Date()));
        System.out.println("=================================================================");
        System.out.println("  GMT " + createDateFormater(TIMEZONE_GMT).format(new Date(130418101643L)));
        System.out.println(" SGMT " + createDateFormater(TIMEZONE_GMT_ST).format(new Date(130418101643L)));
        System.out.println(" SGMT " + createDateFormater(TIMEZONE_UTC).format(new Date(130418101643L)));
        System.out.println("=================================================================");
        System.out.println("  GMT " + createDateFormater(TIMEZONE_GMT).format(new Date(130718101643L)));
        System.out.println(" SGMT " + createDateFormater(TIMEZONE_GMT_ST).format(new Date(130718101643L)));
        System.out.println(" SGMT " + createDateFormater(TIMEZONE_UTC).format(new Date(130718101643L)));
        System.out.println("=================================================================");
        System.out.println("  GMT " + createDateFormater(TIMEZONE_GMT).format(new Date(131018101643L)));
        System.out.println(" SGMT " + createDateFormater(TIMEZONE_GMT_ST).format(new Date(131018101643L)));
        System.out.println(" SGMT " + createDateFormater(TIMEZONE_UTC).format(new Date(131018101643L)));

        for (String arg : TimeZone.getAvailableIDs()) {
            System.out.println("arg = " + arg);
        }

        System.out.println("TZ GMT = " + TimeZone.getTimeZone("GMT"));
        System.out.println("TZ UTC = " + TimeZone.getTimeZone("UTC"));
        System.out.println("TZ Europe/Paris = " + TimeZone.getTimeZone("Europe/Paris"));
    }
}
