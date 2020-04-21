package com.example.weatherking.vfinfo.service;

import com.example.weatherking.util.JsonUtil;
import com.example.weatherking.vfinfo.data.request.AbsVFRequestParamWeather;
import com.example.weatherking.vfinfo.data.request.VFRequestParam;
import com.example.weatherking.vfinfo.data.response.AbsVFItemWeather;
import com.example.weatherking.vfinfo.data.response.VFCategory;
import com.example.weatherking.vfinfo.data.response.VFItem;
import com.fasterxml.jackson.databind.JsonNode;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * 기상청 날씨정보 서비스 템플릿
 */
public abstract class AbsVFWeatherService extends AbsVFService {

    @Override
    protected VFItem deserializeVFItem(JsonNode jsonNode) {
        var data = (AbsVFItemWeather) getVFItemInstance();
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

    protected abstract VFCategory getVFCategory(String category);

    @Override
    protected Map<Object, Object> getParamsFromVFRequestParam(VFRequestParam vfRequestParam) {
        AbsVFRequestParamWeather data = (AbsVFRequestParamWeather) vfRequestParam;
        var param = new HashMap<>();
        param.put("base_date", URLEncoder.encode(data.getBase_date(), StandardCharsets.UTF_8));
        param.put("base_time", URLEncoder.encode(data.getBase_time(), StandardCharsets.UTF_8));
        param.put("nx", URLEncoder.encode(String.valueOf(data.getNx()), StandardCharsets.UTF_8));
        param.put("ny", URLEncoder.encode(String.valueOf(data.getNy()), StandardCharsets.UTF_8));
        return param;
    }
}
