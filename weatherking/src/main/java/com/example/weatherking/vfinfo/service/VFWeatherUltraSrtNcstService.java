package com.example.weatherking.vfinfo.service;

import com.example.weatherking.vfinfo.data.VFType;
import com.example.weatherking.vfinfo.data.response.VFItem;
import com.example.weatherking.vfinfo.data.response.VFItemWeatherUltraSrcNcst;
import org.springframework.stereotype.Service;

/**
 * 기상청 초단기실황조회 서비스
 */
@Service
public class VFWeatherUltraSrtNcstService extends AbsVFWeatherService {
    @Override
    public VFType getVFType() {
        return VFType.VF_ULTRA_SRT_NCST;
    }

    @Override
    public VFItem getVFItemInstance() {
        return new VFItemWeatherUltraSrcNcst();
    }
}
