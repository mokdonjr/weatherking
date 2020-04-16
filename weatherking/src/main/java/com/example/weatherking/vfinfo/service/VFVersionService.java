package com.example.weatherking.vfinfo.service;

import com.example.weatherking.vfinfo.data.request.VFRequestParam;
import com.example.weatherking.vfinfo.data.request.VFRequestParamVersion;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class VFVersionService extends AbsVFService {
    @Override
    public VFType getVFType() {
        return VFType.VF_VERSION;
    }

    @Override
    protected Map<Object, Object> getParamsFromVFRequestParam(VFRequestParam vfRequestParam) {
        VFRequestParamVersion data = (VFRequestParamVersion) vfRequestParam;
        var param = new HashMap<>();
        param.put("ftype", URLEncoder.encode(data.getFtype().name(), StandardCharsets.UTF_8));
        param.put("basedatetime", URLEncoder.encode(data.getBasedatetime(), StandardCharsets.UTF_8));
        return param;
    }
}
