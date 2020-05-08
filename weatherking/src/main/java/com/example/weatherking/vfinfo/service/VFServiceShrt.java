package com.example.weatherking.vfinfo.service;

import com.example.weatherking.util.JsonUtil;
import com.example.weatherking.vfinfo.data.VFType;
import com.example.weatherking.vfinfo.data.request.VFRequestParam;
import com.example.weatherking.vfinfo.data.request.VFRequestParamShrt;
import com.example.weatherking.vfinfo.data.response.*;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * 기상청 동네예보조회 서비스
 */
@Service
public class VFServiceShrt extends AbsVFService {
    @Override
    public VFType getVFType() {
        return VFType.VF_SHRT;
    }

    @Override
    public VFItem getVFResponseItemInstance() {
        return new VFResponseItemShrt();
    }

    @Override
    protected VFCategory getVFCategory(String category) {
        return VFCategoryShrt.valueOf(category);
    }

    @Override
    protected VFItem deserializeVFItem(JsonNode jsonNode) {
        var data = (VFResponseItemShrt) getVFResponseItemInstance();
        data.setBaseDate(JsonUtil.getJsonString(jsonNode, "baseDate"));
        data.setBaseTime(JsonUtil.getJsonString(jsonNode, "baseTime"));
        data.setCategory(getVFCategory(JsonUtil.getJsonString(jsonNode, "category")));
        data.setFcstDate(JsonUtil.getJsonString(jsonNode, "fcstDate"));
        data.setFcstTime(JsonUtil.getJsonString(jsonNode, "fcstTime"));
        data.setFcstValue(JsonUtil.getJsonString(jsonNode, "fcstValue"));
        data.setNx(JsonUtil.getJsonInt(jsonNode, "nx"));
        data.setNy(JsonUtil.getJsonInt(jsonNode, "ny"));
        return data;
    }

    @Override
    protected Map<Object, Object> getParamsFromVFRequestParam(VFRequestParam vfRequestParam) {
        VFRequestParamShrt data = (VFRequestParamShrt) vfRequestParam;
        var param = new HashMap<>();
        param.put("base_date", URLEncoder.encode(data.getBase_date(), StandardCharsets.UTF_8));
        param.put("base_time", URLEncoder.encode(data.getBase_time(), StandardCharsets.UTF_8));
        param.put("nx", URLEncoder.encode(String.valueOf(data.getNx()), StandardCharsets.UTF_8));
        param.put("ny", URLEncoder.encode(String.valueOf(data.getNy()), StandardCharsets.UTF_8));
        return param;
    }
}
