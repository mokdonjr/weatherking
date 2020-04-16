package com.example.weatherking.vfinfo.data;

import com.example.weatherking.vfinfo.service.AbsVFService.VFType;

public class VFItemUltraSrcNcst extends AbsVFItemData implements JsonConvertible<VFItemUltraSrcNcst> {
    @Override
    public VFType getVFType() {
        return VFType.VF_ULTRA_SRT_NCST;
    }

    @Override
    public String serializeJson() {
        return null;
    }

    @Override
    public VFItemUltraSrcNcst deserializeJson(String json) {
        return null;
    }
}
