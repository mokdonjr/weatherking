package com.example.weatherking.util;

import com.example.weatherking.StaticBaseBean;

import java.io.Serializable;
import java.util.Objects;

public class MultipleKey extends StaticBaseBean implements Serializable {

    private boolean booleanValue1;
    private boolean booleanValue2;
    private byte byteValue1;
    private byte byteValue2;
    private char charValue1;
    private char charValue2;
    private short shortValue1;
    private short shortValue2;
    private int intValue1;
    private int intValue2;
    private float floatValue1;
    private float floatValue2;
    private long longValue1;
    private long longValue2;
    private double doubleValue1;
    private double doubleValue2;

    public MultipleKey(double doubleValue1, double doubleValue2) {
        this.doubleValue1 = doubleValue1;
        this.doubleValue2 = doubleValue2;
    }

    public boolean isBooleanValue1() {
        return booleanValue1;
    }

    public void setBooleanValue1(boolean booleanValue1) {
        this.booleanValue1 = booleanValue1;
    }

    public boolean isBooleanValue2() {
        return booleanValue2;
    }

    public void setBooleanValue2(boolean booleanValue2) {
        this.booleanValue2 = booleanValue2;
    }

    public byte getByteValue1() {
        return byteValue1;
    }

    public void setByteValue1(byte byteValue1) {
        this.byteValue1 = byteValue1;
    }

    public byte getByteValue2() {
        return byteValue2;
    }

    public void setByteValue2(byte byteValue2) {
        this.byteValue2 = byteValue2;
    }

    public char getCharValue1() {
        return charValue1;
    }

    public void setCharValue1(char charValue1) {
        this.charValue1 = charValue1;
    }

    public char getCharValue2() {
        return charValue2;
    }

    public void setCharValue2(char charValue2) {
        this.charValue2 = charValue2;
    }

    public short getShortValue1() {
        return shortValue1;
    }

    public void setShortValue1(short shortValue1) {
        this.shortValue1 = shortValue1;
    }

    public short getShortValue2() {
        return shortValue2;
    }

    public void setShortValue2(short shortValue2) {
        this.shortValue2 = shortValue2;
    }

    public int getIntValue1() {
        return intValue1;
    }

    public void setIntValue1(int intValue1) {
        this.intValue1 = intValue1;
    }

    public int getIntValue2() {
        return intValue2;
    }

    public void setIntValue2(int intValue2) {
        this.intValue2 = intValue2;
    }

    public float getFloatValue1() {
        return floatValue1;
    }

    public void setFloatValue1(float floatValue1) {
        this.floatValue1 = floatValue1;
    }

    public float getFloatValue2() {
        return floatValue2;
    }

    public void setFloatValue2(float floatValue2) {
        this.floatValue2 = floatValue2;
    }

    public long getLongValue1() {
        return longValue1;
    }

    public void setLongValue1(long longValue1) {
        this.longValue1 = longValue1;
    }

    public long getLongValue2() {
        return longValue2;
    }

    public void setLongValue2(long longValue2) {
        this.longValue2 = longValue2;
    }

    public double getDoubleValue1() {
        return doubleValue1;
    }

    public void setDoubleValue1(double doubleValue1) {
        this.doubleValue1 = doubleValue1;
    }

    public double getDoubleValue2() {
        return doubleValue2;
    }

    public void setDoubleValue2(double doubleValue2) {
        this.doubleValue2 = doubleValue2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultipleKey that = (MultipleKey) o;
        return booleanValue1 == that.booleanValue1 &&
                booleanValue2 == that.booleanValue2 &&
                byteValue1 == that.byteValue1 &&
                byteValue2 == that.byteValue2 &&
                charValue1 == that.charValue1 &&
                charValue2 == that.charValue2 &&
                shortValue1 == that.shortValue1 &&
                shortValue2 == that.shortValue2 &&
                intValue1 == that.intValue1 &&
                intValue2 == that.intValue2 &&
                Float.compare(that.floatValue1, floatValue1) == 0 &&
                Float.compare(that.floatValue2, floatValue2) == 0 &&
                longValue1 == that.longValue1 &&
                longValue2 == that.longValue2 &&
                Double.compare(that.doubleValue1, doubleValue1) == 0 &&
                Double.compare(that.doubleValue2, doubleValue2) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(booleanValue1, booleanValue2, byteValue1, byteValue2, charValue1, charValue2, shortValue1, shortValue2, intValue1, intValue2, floatValue1, floatValue2, longValue1, longValue2, doubleValue1, doubleValue2);
    }

    @Override
    public String toString() {
        return "MultipleKey{" +
                "booleanValue1=" + booleanValue1 +
                ", booleanValue2=" + booleanValue2 +
                ", byteValue1=" + byteValue1 +
                ", byteValue2=" + byteValue2 +
                ", charValue1=" + charValue1 +
                ", charValue2=" + charValue2 +
                ", shortValue1=" + shortValue1 +
                ", shortValue2=" + shortValue2 +
                ", intValue1=" + intValue1 +
                ", intValue2=" + intValue2 +
                ", floatValue1=" + floatValue1 +
                ", floatValue2=" + floatValue2 +
                ", longValue1=" + longValue1 +
                ", longValue2=" + longValue2 +
                ", doubleValue1=" + doubleValue1 +
                ", doubleValue2=" + doubleValue2 +
                '}';
    }
}
