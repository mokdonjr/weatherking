package com.example.weatherking.vfinfo.service;

import com.example.weatherking.BaseBean;
import com.example.weatherking.vfinfo.data.VFType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VFGateService extends BaseBean {

    @Autowired
    private VFServiceVersion vfServiceVersion;
    @Autowired
    private VFServiceShrt vfWeatherService;
    @Autowired
    private VFServiceVsrt vfServiceVsrt;
    @Autowired
    private VFServiceOdam vfServiceOdam;

    public VFService getVFService(VFType vfType) {
        switch (vfType) {
            case VF_VERSION: return vfServiceVersion;
            case VF_SHRT: return vfWeatherService;
            case VF_VSRT: return vfServiceVsrt;
            case VF_ODAM: return vfServiceOdam;
            default: break;
        }
        return null;
    }
}
