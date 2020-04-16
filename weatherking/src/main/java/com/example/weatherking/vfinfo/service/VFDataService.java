package com.example.weatherking.vfinfo.service;

import org.springframework.stereotype.Service;

@Service
public class VFDataService extends AbsVFService {
    @Override
    public VFType getVFType() {
        return VFType.VF_DATA;
    }
}
