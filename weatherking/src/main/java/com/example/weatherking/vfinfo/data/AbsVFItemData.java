package com.example.weatherking.vfinfo.data;

public abstract class AbsVFItemData extends AbsVFItem {
    // 발표일자 (yyyyMMdd)
    private String baseDate;
    // 발표시각 (HHmm)
    private String baseTime;
    // 예보일자 (yyyyMMdd)
    private String fcstDate;
    // 예보시각 (HHmm)
    private String fcstTime;
    // 자료구분문자
    private String category;
    // 예보값
    private String fcstValue; // optional
    // 예보지점 x좌표
    private Integer nx; // optional
    // 예보지점 y좌표
    private Integer ny; // optional

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFcstValue() {
        return fcstValue;
    }

    public void setFcstValue(String fcstValue) {
        this.fcstValue = fcstValue;
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
}
