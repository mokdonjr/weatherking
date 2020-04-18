package com.example.weatherking.vfinfo.data.response;

import com.example.weatherking.vfinfo.service.AbsVFService.VFType;

public class VFItemData extends AbsVFItemData {
    @Override
    public VFType getVFType() {
        return VFType.VF_DATA;
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
