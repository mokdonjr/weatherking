package com.example.weatherking.vfinfo.shrt;

import com.example.weatherking.util.DateUtil;
import com.example.weatherking.util.JsonUtil;
import com.example.weatherking.vfinfo.common.config.VFConfig;
import com.example.weatherking.vfinfo.common.data.VFDataType;
import com.example.weatherking.vfinfo.common.data.VFType;
import com.example.weatherking.vfinfo.common.data.request.VFRequest;
import com.example.weatherking.vfinfo.common.data.request.VFRequestParam;
import com.example.weatherking.vfinfo.common.data.response.VFCategory;
import com.example.weatherking.vfinfo.common.data.response.VFItem;
import com.example.weatherking.vfinfo.common.service.AbsVFService;
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
    public VFRequest getVFRequestDefault(int page, int num) {
        VFRequest vfRequest = new VFRequest();
        vfRequest.setServiceKey(VFConfig.getServiceKey());
        vfRequest.setPageNo(page);
        vfRequest.setNumOfRows(num);
        vfRequest.setDataType(VFConfig.DATA_TYPE_DEFAULT_VALUE);
        VFRequestParamShrt vfRequestParamShrt = new VFRequestParamShrt();
        vfRequestParamShrt.setBase_date(DateUtil.dateToStringyyyyMMdd(DateUtil.getDateAfterHours(-1)));
        vfRequestParamShrt.setBase_time(DateUtil.dateToStringHHmm(DateUtil.getDateAfterHours(-1)));
        // TODO : 파라미터를 어떻게 넘길것인지?
        vfRequestParamShrt.setNx(VFConfig.NX_DEFAULT_VALUE);
        vfRequestParamShrt.setNy(VFConfig.NY_DEFAULT_VALUE);
        vfRequest.setVfRequestParam(vfRequestParamShrt);
        return vfRequest;
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
