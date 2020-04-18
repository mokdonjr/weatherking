package com.example.weatherking.vfinfo.data.request;

import com.example.weatherking.vfinfo.data.VFType;

public class VFRequestParamWeatherNormal extends AbsVFRequestParamWeather {
    @Override
    public VFType getVFType() {
        return VFType.VF_NORMAL;
    }

    @Override
    public String toString() {
        return "VFRequestParamData{" +
                "base_date='" + base_date + '\'' +
                ", base_time='" + base_time + '\'' +
                ", nx=" + nx +
                ", ny=" + ny +
                '}';
    }
}
