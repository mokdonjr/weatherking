package com.example.weatherking.vfinfo.service;

import com.example.weatherking.BaseBean;
import com.example.weatherking.vfinfo.service.AbsVFService.VFType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VFGateService extends BaseBean {

    @Autowired
    private VFVersionService vfVersionService;
    @Autowired
    private VFDataService vfDataService;
    @Autowired
    private VFUltraSrtFcstService vfUltraSrtFcstService;
    @Autowired
    private VFUltraSrtNcstService vfUltraSrtNcstService;

    public VFService getVFService(VFType vfType) {
        switch (vfType) {
            case VF_VERSION: return vfVersionService;
            case VF_DATA: return vfDataService;
            case VF_ULTRA_SRT_FCST: return vfUltraSrtFcstService;
            case VF_ULTRA_SRT_NCST: return vfUltraSrtNcstService;
            default: break;
        }
        return null;
    }
}
