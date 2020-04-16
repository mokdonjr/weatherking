package com.example.weatherking.vfinfo.service;

import com.example.weatherking.vfinfo.service.AbsVFService.VFType;

public interface VFService {

    VFType getVFType();

    default String getRequestUrl() {
        return getVFType().getRequestUrl();
    }
}
