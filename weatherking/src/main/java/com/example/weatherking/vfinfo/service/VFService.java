package com.example.weatherking.vfinfo.service;

import com.example.weatherking.vfinfo.data.request.VFRequest;
import com.example.weatherking.vfinfo.data.response.VFResponse;
import com.example.weatherking.vfinfo.service.AbsVFService.VFType;

public interface VFService {

    VFType getVFType();

    default String getRequestUrl() {
        return getVFType().getRequestUrl();
    }

    VFResponse requestDefault(VFRequest data);
}
