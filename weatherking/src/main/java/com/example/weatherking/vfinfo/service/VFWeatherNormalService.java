package com.example.weatherking.vfinfo.service;

import com.example.weatherking.vfinfo.data.VFType;
import com.example.weatherking.vfinfo.data.response.VFCategory;
import com.example.weatherking.vfinfo.data.response.VFCategoryWeatherNormal;
import com.example.weatherking.vfinfo.data.response.VFItem;
import com.example.weatherking.vfinfo.data.response.VFItemWeatherNormal;
import org.springframework.stereotype.Service;

/**
 * 기상청 동네예보조회 서비스
 */
@Service
public class VFWeatherNormalService extends AbsVFWeatherService {
    @Override
    public VFType getVFType() {
        return VFType.VF_NORMAL;
    }

    @Override
    public VFItem getVFItemInstance() {
        return new VFItemWeatherNormal();
    }

    @Override
    protected VFCategory getVFCategory(String category) {
        return VFCategoryWeatherNormal.valueOf(category);
    }
}
