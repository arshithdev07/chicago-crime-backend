package com.tamu.chicagocrime.service.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by arshi on 9/24/2019.
 */
public class DatesUtil {

    static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static Date stringToDate (String date, String format) {
        try {
            DateFormat dateFormat = new SimpleDateFormat(format);
            return dateFormat.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Date reduceDays(Date date, int noOfDays) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, noOfDays);
        Date dateBeforeNDays = cal.getTime();
        return dateBeforeNDays;
    }

}
