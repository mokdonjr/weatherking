package com.example.weatherking.vfinfo.odam;

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
 * 기상청 초단기실황조회 서비스
 */
@Service
public class VFServiceOdam extends AbsVFService {
    @Override
    public VFType getVFType() {
        return VFType.VF_ODAM;
    }

    @Override
    public VFItem getVFResponseItemInstance() {
        return new VFResponseItemOdam();
    }

    @Override
    public VFRequest getVFRequestDefault() {
        VFRequest vfRequest = new VFRequest();
        vfRequest.setServiceKey(VFConfig.getServiceKey());
        vfRequest.setPageNo(VFConfig.PAGE_NO_DEFAULT_VALUE);
        vfRequest.setNumOfRows(VFConfig.NUM_OF_ROWS_DEFAULT_VALUE);
        vfRequest.setDataType(VFConfig.DATA_TYPE_DEFAULT_VALUE);
        VFRequestParamOdam vfRequestParamOdam = new VFRequestParamOdam();
        vfRequestParamOdam.setBase_date(DateUtil.dateToStringyyyyMMdd(DateUtil.getDateAfterHours(-1)));
        vfRequestParamOdam.setBase_time(DateUtil.dateToStringHHmm(DateUtil.getDateAfterHours(-1)));
        vfRequestParamOdam.setNx(VFConfig.NX_DEFAULT_VALUE);
        vfRequestParamOdam.setNy(VFConfig.NY_DEFAULT_VALUE);
        vfRequest.setVfRequestParam(vfRequestParamOdam);
        return vfRequest;
    }

    @Override
    protected VFCategory getVFCategory(String category) {
        return VFCategoryOdam.valueOf(category);
    }

    @Override
    protected VFItem deserializeVFItem(JsonNode jsonNode) {
        var data = (VFResponseItemOdam) getVFResponseItemInstance();
        data.setBaseDate(JsonUtil.getJsonString(jsonNode, "baseDate"));
        data.setBaseTime(JsonUtil.getJsonString(jsonNode, "baseTime"));
        data.setCategory(getVFCategory(JsonUtil.getJsonString(jsonNode, "category")));
        data.setObsrValue(JsonUtil.getJsonString(jsonNode, "obsrValue"));
        data.setNx(JsonUtil.getJsonInt(jsonNode, "nx"));
        data.setNy(JsonUtil.getJsonInt(jsonNode, "ny"));
        return data;
    }

    @Override
    protected Map<Object, Object> getParamsFromVFRequestParam(VFRequestParam vfRequestParam) {
        VFRequestParamOdam data = (VFRequestParamOdam) vfRequestParam;
        var param = new HashMap<>();
        param.put("base_date", URLEncoder.encode(data.getBase_date(), StandardCharsets.UTF_8));
        param.put("base_time", URLEncoder.encode(data.getBase_time(), StandardCharsets.UTF_8));
        param.put("nx", URLEncoder.encode(String.valueOf(data.getNx()), StandardCharsets.UTF_8));
        param.put("ny", URLEncoder.encode(String.valueOf(data.getNy()), StandardCharsets.UTF_8));
        return param;
    }
}
