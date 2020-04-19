package com.example.weatherking.vfinfo.service;

import com.example.weatherking.vfinfo.data.VFType;
import com.example.weatherking.vfinfo.data.response.VFCategory;
import com.example.weatherking.vfinfo.data.response.VFCategoryWeatherUltraSrtFcst;
import com.example.weatherking.vfinfo.data.response.VFItem;
import com.example.weatherking.vfinfo.data.response.VFItemWeatherUltraSrtFcst;
import org.springframework.stereotype.Service;

/**
 * 기상청 초단기예보조회 서비스
 */
@Service
public class VFWeatherUltraSrtFcstService extends AbsVFWeatherService {
    @Override
    public VFType getVFType() {
        return VFType.VF_ULTRA_SRT_FCST;
    }

    @Override
    public VFItem getVFItemInstance() {
        return new VFItemWeatherUltraSrtFcst();
    }

    @Override
    protected VFCategory getVFCategory(String category) {
        return VFCategoryWeatherUltraSrtFcst.valueOf(category);
    }
}
