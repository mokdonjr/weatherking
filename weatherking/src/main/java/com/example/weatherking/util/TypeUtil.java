package com.example.weatherking.util;

import com.example.weatherking.StaticBaseBean;

import java.util.Date;

public class TypeUtil extends StaticBaseBean {

    public static byte checkNull(Byte v) {
        return v == null ? 0 : v;
    }
    public static byte checkNull(Byte v, byte v2) {
        return v == null ? v2 : v;
    }

    public static short checkNull(Short v) {
        return v == null ? 0 : v;
    }
    public static short checkNull(Short v, short v2) {
        return v == null ? v2 : v;
    }

    public static int checkNull(Integer v) {
        return v == null ? 0 : v;
    }
    public static int checkNull(Integer v, int v2) {
        return v == null ? v2 : v;
    }

    public static long checkNull(Long v) {
        return v == null ? 0L : v;
    }
    public static long checkNull(Long v, long v2) {
        return v == null ? v2 : v;
    }

    public static float checkNull(Float v) {
        return v == null ? 0f : v;
    }
    public static float checkNull(Float v, float v2) {
        return v == null ? v2 : v;
    }

    public static double checkNull(Double v) {
        return v == null ? 0d : v;
    }
    public static double checkNull(Double v, double v2) {
        return v == null ? v2 : v;
    }

    public static boolean checkNull(Boolean v) {
        return v == null ? false : v;
    }
    public static boolean checkNull(Boolean v, boolean v2) {
        return v == null ? v2 : v;
    }

    public static String checkNull(String v) {
        return v == null ? "" : v;
    }
    public static String checkNull(String v, String v2) {
        return v == null ? v2 : v;
    }

    public static Date checkNull(Date v) {
        return v == null ? new Date(0L) : v;
    }
    public static Date checkNull(Date v, Date v2) {
        return v == null ? v2 : v;
    }
}
