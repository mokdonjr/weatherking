package com.example.weatherking.vfinfo.data.request;

import com.example.weatherking.vfinfo.service.AbsVFService.VFType;

public class VFRequestParamUltraSrtFcst extends AbsVFRequestParamData {
    @Override
    public VFType getVFType() {
        return VFType.VF_ULTRA_SRT_FCST;
    }

    @Override
    public String toString() {
        return "VFRequestParamUltraSrtFcst{" +
                "base_date='" + base_date + '\'' +
                ", base_time='" + base_time + '\'' +
                ", nx=" + nx +
                ", ny=" + ny +
                '}';
    }
}
