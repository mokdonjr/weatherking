package com.example.weatherking.vfinfo.service;

import org.springframework.stereotype.Service;

@Service
public class VFUltraSrtFcstService extends AbsVFService {
    @Override
    public VFType getVFType() {
        return VFType.VF_ULTRA_SRT_FCST;
    }
}
