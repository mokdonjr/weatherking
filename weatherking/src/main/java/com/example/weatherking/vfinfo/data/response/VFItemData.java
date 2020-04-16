package com.example.weatherking.vfinfo.data.response;

import com.example.weatherking.vfinfo.data.JsonConvertible;
import com.example.weatherking.vfinfo.service.AbsVFService.VFType;

public class VFItemData extends AbsVFItemData implements JsonConvertible<VFItemData> {
    @Override
    public VFType getVFType() {
        return VFType.VF_DATA;
    }

    @Override
    public String serializeJson() {
        return null;
    }

    @Override
    public VFItemData deserializeJson(String json) {
        return null;
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
