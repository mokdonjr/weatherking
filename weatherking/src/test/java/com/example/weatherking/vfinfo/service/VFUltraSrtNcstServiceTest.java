package com.example.weatherking.vfinfo.service;

import com.example.weatherking.vfinfo.service.AbsVFService.VFType;

public class VFUltraSrtNcstServiceTest extends AbsVFDataServiceTest {

    @Override
    protected VFType getVFType() {
        return VFType.VF_ULTRA_SRT_NCST;
    }
}
