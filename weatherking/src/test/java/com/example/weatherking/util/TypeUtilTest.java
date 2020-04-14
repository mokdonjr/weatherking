package com.example.weatherking.util;

import com.example.weatherking.StaticBaseBeanTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class TypeUtilTest extends StaticBaseBeanTest {

    @Test
    public void testCheckNullByte() {
        Byte v = null;
        Assertions.assertEquals(0, TypeUtil.checkNull(v));
        byte v2 = 1;
        Assertions.assertEquals(v2, TypeUtil.checkNull(v, v2));
    }

    @Test
    public void testCheckNullShort() {
        Short v = null;
        Assertions.assertEquals(0, TypeUtil.checkNull(v));
        short v2 = 1;
        Assertions.assertEquals(v2, TypeUtil.checkNull(v, v2));
    }

    @Test
    public void testCheckNullInteger() {
        Integer v = null;
        Assertions.assertEquals(0, TypeUtil.checkNull(v));
        int v2 = 1;
        Assertions.assertEquals(v2, TypeUtil.checkNull(v, v2));
    }

    @Test
    public void testCheckNullLong() {
        Long v = null;
        Assertions.assertEquals(0L, TypeUtil.checkNull(v));
        long v2 = 1L;
        Assertions.assertEquals(v2, TypeUtil.checkNull(v, v2));
    }

    @Test
    public void testCheckNullDouble() {
        Double v = null;
        Assertions.assertEquals(0d, TypeUtil.checkNull(v));
        double v2 = 1.0d;
        Assertions.assertEquals(v2, TypeUtil.checkNull(v, v2));
    }

    @Test
    public void testCheckNullFloat() {
        Float v = null;
        Assertions.assertEquals(0f, TypeUtil.checkNull(v));
        float v2 = 1.0f;
        Assertions.assertEquals(v2, TypeUtil.checkNull(v, v2));
    }

    @Test
    public void testCheckNullString() {
        String v = null;
        Assertions.assertEquals("", TypeUtil.checkNull(v));
        String v2 = "aa";
        Assertions.assertEquals(v2, TypeUtil.checkNull(v, v2));
    }

    @Test
    public void testCheckNullDate() {
        Date v = null;
        Assertions.assertEquals(new Date(0L), TypeUtil.checkNull(v));
        Date v2 = new Date();
        Assertions.assertEquals(v2, TypeUtil.checkNull(v, v2));
    }
}