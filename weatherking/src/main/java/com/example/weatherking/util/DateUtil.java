package com.example.weatherking.util;

import com.example.weatherking.StaticBaseBean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil extends StaticBaseBean {

    private static Date testDate = null;

    public static Date getCurrentDate() {
        if (testDate == null) {
            return new Date();
        } else {
            return testDate;
        }
    }

    public static String getDateStringFormat(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    public static String getDateStringFormat(String format) {
        return getDateStringFormat(getCurrentDate(), format);
    }

    public static String getDateStringFormatyyyyMMddHHmm(Date date) {
        return getDateStringFormat(date, "yyyyMMddHHmm");
    }

    public static String getDateStringFormatyyyyMMddHHmm() {
        return getDateStringFormatyyyyMMddHHmm(getCurrentDate());
    }

    public static String getDateStringFormatyyyyMMdd(Date date) {
        return getDateStringFormat(date, "yyyyMMdd");
    }

    public static String getDateStringFormatyyyyMMdd() {
        return getDateStringFormatyyyyMMdd(getCurrentDate());
    }

    public static String getDateStringFormatHHmm(Date date) {
        return getDateStringFormat(date, "HHmm");
    }

    public static String getDateStringFormatHHmm() {
        return getDateStringFormatHHmm(getCurrentDate());
    }

    public static Date getDateAfterMillis(Date date, int millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MILLISECOND, millis);
        return calendar.getTime();
    }

    public static Date getDateAfterMillis(int millis) {
        return getDateAfterMillis(getCurrentDate(), millis);
    }

    public static Date getDateAfterSeconds(Date date, int sec) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, sec);
        return calendar.getTime();
    }

    public static Date getDateAfterSeconds(int sec) {
        return getDateAfterSeconds(getCurrentDate(), sec);
    }

    public static Date getDateAfterMinutes(Date date, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MILLISECOND, minutes);
        return calendar.getTime();
    }

    public static Date getDateAfterMinutes(int minutes) {
        return getDateAfterMinutes(getCurrentDate(), minutes);
    }

    public static Date getDateAfterHours(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, hours);
        return calendar.getTime();
    }

    public static Date getDateAfterHours(int hours) {
        return getDateAfterHours(getCurrentDate(), hours);
    }

    public static Date getDateAfterDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    public static Date getDateAfterDays(int days) {
        return getDateAfterDays(getCurrentDate(), days);
    }
}
