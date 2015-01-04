package org.barrak.java8.time;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * The basic time API demo.
 * 
 * @author Emilien Guenichon <emilien.guenichon@cgi.com>
 */
public class TimeAPI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Old API
        Date date = new Date();
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.MINUTE, 5);
        
        // System time and duration
        Instant instant = Instant.now();
        Duration duration = Duration.between(instant, cal.toInstant());
        System.out.println(duration.getSeconds()); // 299
        
        // Humain time (with offset ...)
        // With offset
        ZonedDateTime.now(ZoneId.of("GMT+1"));
        OffsetDateTime.now(ZoneOffset.of("+01:00"));
        
        // No offset
        LocalDateTime local = LocalDateTime.now();
        // Set to january ! (not start from 0)
        local.withMonth(1);
        // Fluid API !
        local.withHour(0).withSecond(0);
        
        // Shorter version
        // Only time
        LocalTime lt = LocalTime.now();
        lt.getHour();
        // Only date
        LocalDate ld = LocalDate.now();
        ld.getDayOfYear();
        
        // Specific enums
        DayOfWeek dow = DayOfWeek.THURSDAY;
        Month month = Month.DECEMBER;
        Year year = Year.of(2015);
        
        // Leap or not !
        boolean isLeap = Year.isLeap(2000); // True
    }
    
}
