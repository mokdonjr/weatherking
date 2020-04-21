package com.example.weatherking.util;

import com.example.weatherking.StaticBaseBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil extends StaticBaseBean {

    /**
     * 디폴트 시간 형식
     */
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static Date testDate = null;

    public static Date getCurrentDate() {
        if (testDate == null) {
            return new Date();
        } else {
            return testDate;
        }
    }

    /**
     * 문자열 -> Date 변환
     * @param date
     * @param format
     * @return
     */
    public static Date stringToDate(String date, String format) {
        if (date == null)
            return null;
        Date parsed = null;
        try {
            parsed = new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parsed;
    }

    public static Date stringToDate(String date) {
        return stringToDate(date, DateUtil.DEFAULT_DATE_FORMAT);
    }

    /**
     * Date -> 문자열 변환
     * @param date
     * @param format
     * @return
     */
    public static String dateToString(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    public static String dateToString(String format) {
        return dateToString(getCurrentDate(), format);
    }

    public static String dateToStringyyyyMMddHHmm(Date date) {
        return dateToString(date, "yyyyMMddHHmm");
    }

    public static String dateToStringyyyyMMddHHmm() {
        return dateToStringyyyyMMddHHmm(getCurrentDate());
    }

    public static String dateToStringyyyyMMdd(Date date) {
        return dateToString(date, "yyyyMMdd");
    }

    public static String dateToStringyyyyMMdd() {
        return dateToStringyyyyMMdd(getCurrentDate());
    }

    public static String dateToStringHHmm(Date date) {
        return dateToString(date, "HHmm");
    }

    public static String dateToStringHHmm() {
        return dateToStringHHmm(getCurrentDate());
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
