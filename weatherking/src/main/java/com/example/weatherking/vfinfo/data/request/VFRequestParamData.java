package com.example.weatherking.vfinfo.data.request;

import com.example.weatherking.vfinfo.service.AbsVFService.VFType;

public class VFRequestParamData extends AbsVFRequestParamData {
    @Override
    public VFType getVFType() {
        return VFType.VF_DATA;
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
