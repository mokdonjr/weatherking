package com.example.weatherking.vfinfo.data.response;

import com.example.weatherking.vfinfo.data.VFType;

public class VFItemWeatherUltraSrtFcst extends AbsVFItemWeather {
    @Override
    public VFType getVFType() {
        return VFType.VF_ULTRA_SRT_FCST;
    }

    @Override
    public String toString() {
        return "VFItemUltraSrtFcst{" +
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
