package org.barrak.java8.time;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Previous API to the new one conversion and vice-versa.
 *
 * @author Emilien Guenichon <emilien.guenichon@cgi.com>
 */
public class TimeAPIConversion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Date to instant
        Date date = new Date();
        Instant instant =  date.toInstant();
        date = Date.from(instant);
        
        // Calendar to instant
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("Europe/Paris"));
        ZonedDateTime zdt = gregorianCalendar.toZonedDateTime();
        instant = gregorianCalendar.toInstant();
        
        // Instant/ZonedDateTime to 
        zdt = ZonedDateTime.ofInstant(instant, ZoneId.of("Europe/Paris"));
        GregorianCalendar.from(zdt);
    }

}
