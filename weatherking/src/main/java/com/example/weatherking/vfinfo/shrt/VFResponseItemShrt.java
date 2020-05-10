package com.example.weatherking.vfinfo.shrt;

import com.example.weatherking.vfinfo.common.data.VFType;
import com.example.weatherking.vfinfo.common.data.response.AbsVFResponseItem;
import com.example.weatherking.vfinfo.common.data.response.VFCategory;

public class VFResponseItemShrt extends AbsVFResponseItem {
    @Override
    public VFType getVFType() {
        return VFType.VF_SHRT;
    }

    // 발표일자 (yyyyMMdd)
    protected String baseDate;
    // 발표시각 (HHmm)
    protected String baseTime;
    // 자료구분코드
    protected VFCategory category;
    // 예보값
    protected String fcstValue; // optional
    // 예보일자 (yyyyMMdd)
    protected String fcstDate;
    // 예보시각 (HHmm)
    protected String fcstTime;
    // 예보지점 x좌표
    protected Integer nx; // optional
    // 예보지점 y좌표
    protected Integer ny; // optional

    public String getBaseDate() {
        return baseDate;
    }

    public void setBaseDate(String baseDate) {
        this.baseDate = baseDate;
    }

    public String getBaseTime() {
        return baseTime;
    }

    public void setBaseTime(String baseTime) {
        this.baseTime = baseTime;
    }

    public VFCategory getCategory() {
        return category;
    }

    public void setCategory(VFCategory category) {
        this.category = category;
    }

    public String getFcstValue() {
        return fcstValue;
    }

    public void setFcstValue(String fcstValue) {
        this.fcstValue = fcstValue;
    }

    public String getFcstDate() {
        return fcstDate;
    }

    public void setFcstDate(String fcstDate) {
        this.fcstDate = fcstDate;
    }

    public String getFcstTime() {
        return fcstTime;
    }

    public void setFcstTime(String fcstTime) {
        this.fcstTime = fcstTime;
    }

    public Integer getNx() {
        return nx;
    }

    public void setNx(Integer nx) {
        this.nx = nx;
    }

    public Integer getNy() {
        return ny;
    }

    public void setNy(Integer ny) {
        this.ny = ny;
    }

    @Override
    public String toString() {
        return "VFItemData{" +
                "baseDate='" + baseDate + '\'' +
                ", baseTime='" + baseTime + '\'' +
                ", fcstDate='" + fcstDate + '\'' +
                ", fcstTime='" + fcstTime + '\'' +
                ", category='" + category + '\'' +
                ", fcstValue='" + fcstValue + '\'' +
                ", nx=" + nx +
                ", ny=" + ny +
                '}';
    }
}
