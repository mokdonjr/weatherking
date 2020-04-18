package com.example.weatherking.vfinfo.data.response;

import com.example.weatherking.vfinfo.data.VFType;

public class VFItemWeatherNormal extends AbsVFItemWeather {
    @Override
    public VFType getVFType() {
        return VFType.VF_NORMAL;
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
