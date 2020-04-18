package com.example.weatherking.vfinfo.service;

import com.example.weatherking.BaseBean;
import com.example.weatherking.vfinfo.data.VFType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VFGateService extends BaseBean {

    @Autowired
    private VFVersionService vfVersionService;
    @Autowired
    private VFWeatherNormalService vfWeatherService;
    @Autowired
    private VFWeatherUltraSrtFcstService vfWeatherUltraSrtFcstService;
    @Autowired
    private VFWeatherUltraSrtNcstService vfWeatherUltraSrtNcstService;

    public VFService getVFService(VFType vfType) {
        switch (vfType) {
            case VF_VERSION: return vfVersionService;
            case VF_NORMAL: return vfWeatherService;
            case VF_ULTRA_SRT_FCST: return vfWeatherUltraSrtFcstService;
            case VF_ULTRA_SRT_NCST: return vfWeatherUltraSrtNcstService;
            default: break;
        }
        return null;
    }
}
