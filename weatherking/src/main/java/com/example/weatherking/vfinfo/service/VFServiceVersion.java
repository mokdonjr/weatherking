package com.example.weatherking.vfinfo.service;

import com.example.weatherking.util.JsonUtil;
import com.example.weatherking.vfinfo.data.VFFileType;
import com.example.weatherking.vfinfo.data.VFType;
import com.example.weatherking.vfinfo.data.request.VFRequestParam;
import com.example.weatherking.vfinfo.data.request.VFRequestParamVersion;
import com.example.weatherking.vfinfo.data.response.VFCategory;
import com.example.weatherking.vfinfo.data.response.VFItem;
import com.example.weatherking.vfinfo.data.response.VFResponseItemVersion;
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
