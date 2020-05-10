package com.example.weatherking.vfinfo.version;

import com.example.weatherking.util.DateUtil;
import com.example.weatherking.util.JsonUtil;
import com.example.weatherking.vfinfo.common.config.VFConfig;
import com.example.weatherking.vfinfo.common.data.VFFileType;
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
 * 기상청 버전정보 서비스 템플릿
 */
@Service
public class VFServiceVersion extends AbsVFService {
    @Override
    public VFType getVFType() {
        return VFType.VF_VERSION;
    }

    @Override
    public VFItem getVFResponseItemInstance() {
        return new VFResponseItemVersion();
    }

    @Override
    public VFRequest getVFRequestDefault(int page, int num) {
        VFRequest vfRequest = new VFRequest();
        vfRequest.setServiceKey(VFConfig.getServiceKey());
        vfRequest.setPageNo(page);
        vfRequest.setNumOfRows(num);
        vfRequest.setDataType(VFConfig.DATA_TYPE_DEFAULT_VALUE);
        VFRequestParamVersion vfRequestParamVersion = new VFRequestParamVersion();
        // TODO : 파라미터를 어떻게 넘길것인지
        vfRequestParamVersion.setFtype(VFFileType.ODAM);
        vfRequestParamVersion.setBasedatetime(DateUtil.dateToStringyyyyMMddHHmm(DateUtil.getDateAfterHours(-1)));
        vfRequest.setVfRequestParam(vfRequestParamVersion);
        return vfRequest;
    }

    @Override
    protected VFItem deserializeVFItem(JsonNode jsonNode) {
        var data = new VFResponseItemVersion();
        data.setFiletype(VFFileType.valueOf(JsonUtil.getJsonString(jsonNode, "filetype")));
        data.setVersion(JsonUtil.getJsonString(jsonNode, "version"));
        return data;
    }

    @Override
    protected Map<Object, Object> getParamsFromVFRequestParam(VFRequestParam vfRequestParam) {
        VFRequestParamVersion data = (VFRequestParamVersion) vfRequestParam;
        var param = new HashMap<>();
        param.put("ftype", URLEncoder.encode(data.getFtype().name(), StandardCharsets.UTF_8));
        param.put("basedatetime", URLEncoder.encode(data.getBasedatetime(), StandardCharsets.UTF_8));
        return param;
    }

    @Override
    protected VFCategory getVFCategory(String category) {
        return null;
    }
}
