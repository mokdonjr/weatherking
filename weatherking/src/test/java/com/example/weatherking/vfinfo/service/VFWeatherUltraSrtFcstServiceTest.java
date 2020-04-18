package com.example.weatherking.vfinfo.service;

import com.example.weatherking.vfinfo.data.VFType;

public class VFWeatherUltraSrtFcstServiceTest extends AbsVFWeatherServiceTest {

    @Override
    protected VFType getVFType() {
        return VFType.VF_ULTRA_SRT_FCST;
    }
}
