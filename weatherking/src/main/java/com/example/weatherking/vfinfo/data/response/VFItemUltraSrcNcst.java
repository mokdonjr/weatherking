package com.example.weatherking.vfinfo.data.response;

import com.example.weatherking.vfinfo.data.JsonConvertible;
import com.example.weatherking.vfinfo.service.AbsVFService.VFType;

public class VFItemUltraSrcNcst extends AbsVFItemData implements JsonConvertible<VFItemUltraSrcNcst> {
    @Override
    public VFType getVFType() {
        return VFType.VF_ULTRA_SRT_NCST;
    }

    @Override
    public String serializeJson() {
        return null;
    }

    @Override
    public VFItemUltraSrcNcst deserializeJson(String json) {
        return null;
    }

    @Override
    public String toString() {
        return "VFItemUltraSrcNcst{" +
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
