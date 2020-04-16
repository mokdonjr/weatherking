package com.example.weatherking.vfinfo.service;

import org.springframework.stereotype.Service;

@Service
public class VFVersionService extends AbsVFService {
    @Override
    public VFType getVFType() {
        return VFType.VF_VERSION;
    }
}
