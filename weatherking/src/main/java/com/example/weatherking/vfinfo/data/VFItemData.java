package com.example.weatherking.vfinfo.data;

import com.example.weatherking.vfinfo.service.AbsVFService.VFType;

public class VFItemData extends AbsVFItemData implements JsonConvertible<VFItemData> {
    @Override
    public VFType getVFType() {
        return VFType.VF_DATA;
    }

    @Override
    public String serializeJson() {
        return null;
    }

    @Override
    public VFItemData deserializeJson(String json) {
        return null;
    }
}
