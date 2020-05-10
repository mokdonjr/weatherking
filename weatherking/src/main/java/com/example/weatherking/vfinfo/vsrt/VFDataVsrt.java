package com.example.weatherking.vfinfo.vsrt;

import java.util.Date;

/**
 * VF_VSRT 테이블
 * 초단기예보기록
 */
public class VFDataVsrt {
    private Date noticeAt; // pk
    private Date forecastAt; // pk
    private Integer nx; // pk
    private Integer ny; // pk
    private VFCategoryVsrt category; // pk
    private String value;
    private Date createAt;

    public Date getNoticeAt() {
        return noticeAt;
    }

    public void setNoticeAt(Date noticeAt) {
        this.noticeAt = noticeAt;
    }

    public Date getForecastAt() {
        return forecastAt;
    }

    public void setForecastAt(Date forecastAt) {
        this.forecastAt = forecastAt;
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

    public VFCategoryVsrt getCategory() {
        return category;
    }

    public void setCategory(VFCategoryVsrt category) {
        this.category = category;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
