package com.example.weatherking.vfinfo.data.request;

import com.example.weatherking.vfinfo.data.VFType;

public class VFRequestParamWeatherUltraSrtNcst extends AbsVFRequestParamWeather {
    @Override
    public VFType getVFType() {
        return VFType.VF_ULTRA_SRT_NCST;
    }

    @Override
    public String toString() {
        return "VFRequestParamUltraSrtNcst{" +
                "base_date='" + base_date + '\'' +
                ", base_time='" + base_time + '\'' +
                ", nx=" + nx +
                ", ny=" + ny +
                '}';
    }
}
