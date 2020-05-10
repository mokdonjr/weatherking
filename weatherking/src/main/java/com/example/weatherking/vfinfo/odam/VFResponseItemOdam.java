package com.example.weatherking.vfinfo.odam;

import com.example.weatherking.vfinfo.common.data.VFType;
import com.example.weatherking.vfinfo.common.data.response.AbsVFResponseItem;
import com.example.weatherking.vfinfo.common.data.response.VFCategory;

public class VFResponseItemOdam extends AbsVFResponseItem {
    @Override
    public VFType getVFType() {
        return VFType.VF_ODAM;
    }

    // 발표일자 (yyyyMMdd)
    protected String baseDate;
    // 발표시각 (HHmm)
    protected String baseTime;
    // 자료구분코드
    protected VFCategory category;
    // 실황값
    protected String obsrValue; // optional
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

    public String getObsrValue() {
        return obsrValue;
    }

    public void setObsrValue(String obsrValue) {
        this.obsrValue = obsrValue;
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
        return "VFResponseItemOdam{" +
                "baseDate='" + baseDate + '\'' +
                ", baseTime='" + baseTime + '\'' +
                ", category=" + category +
                ", obsrValue='" + obsrValue + '\'' +
                ", nx=" + nx +
                ", ny=" + ny +
                '}';
    }
}
