package com.example.weatherking.vfinfo.service;

import com.example.weatherking.BaseBean;
import com.example.weatherking.http.HttpGateService;
import com.example.weatherking.util.StringUtil;
import com.example.weatherking.vfinfo.data.VFDataType;
import com.example.weatherking.vfinfo.data.request.VFRequest;
import com.example.weatherking.vfinfo.data.request.VFRequestParam;
import com.example.weatherking.vfinfo.data.response.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;

import java.net.URLEncoder;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * 동네예보 서비스 기본 템플릿
 */
public abstract class AbsVFService extends BaseBean implements VFService {

    @Autowired
    private HttpGateService httpGateService;

    @Override
    public VFResponseDefault deserializeVFResponseDefault(String json) {
        VFResponseDefault data = null;
        try {
            var om = new ObjectMapper();
            JsonNode jsonNode = om.readTree(json);
            data = deserializeVFResponseDefault(jsonNode);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public VFResponseDefault deserializeVFResponseDefault(JsonNode jsonNode) {
        var data = new VFResponseDefault();
        if (jsonNode.has("response")) {
            var response = new VFResponse();
            var jsonNodeResponse = jsonNode.get("response");
            if (jsonNodeResponse.has("header")) {
                var jsonNodeHeader = jsonNodeResponse.get("header");
                var header = new VFHeader();
                if (jsonNodeHeader.has("resultCode")) {
                    header.setResultCode(jsonNodeHeader.get("resultCode").toString());
                }
                if (jsonNodeHeader.has("resultMsg")) {
                    header.setResultMsg(jsonNodeHeader.get("resultMsg").toString());
                }
                response.setHeader(header);
            }
            if (jsonNodeResponse.has("body")) {
                var body = new VFBody();
                var jsonNodeBody = jsonNodeResponse.get("body");
                if (jsonNodeBody.has("dataType")) {
                    String dataType = jsonNodeBody.get("dataType").toString();
                    body.setDataType(VFDataType.valueOf(StringUtil.trimDoubleQuotes(dataType)));
                }
                if (jsonNodeBody.has("items")) {
                    List<VFItem> list = new ArrayList<>();
                    Iterator<JsonNode> iterator = jsonNodeBody.get("items").elements();
                    while (iterator.hasNext()) {
                        JsonNode jsonNodeInner = iterator.next();
                        if (jsonNodeInner.has("item")) {
                            jsonNodeInner = jsonNodeInner.get("item");
                            var item = deserializeVFItem(jsonNodeInner);
                            list.add(item);
                        }
                    }
                    body.setItems(list);
                }
                if (jsonNodeBody.has("pageNo")) {
                    body.setPageNo(jsonNodeBody.get("pageNo").asInt());
                }
                if (jsonNodeBody.has("numOfRows")) {
                    body.setNumOfRows(jsonNodeBody.get("numOfRows").asInt());
                }
                if (jsonNodeBody.has("totalCount")) {
                    body.setTotalCount(jsonNodeBody.get("totalCount").asInt());
                }
                response.setBody(body);
            }
            data.setResponse(response);
        }
        return data;
    }

    protected abstract VFItem deserializeVFItem(JsonNode jsonNode);

    @Override
    public VFResponseDefault request(VFRequest data) {
        var params = getParamsFromVFRequest(data);
        HttpResponse<String> response = httpGateService.getHttpService(HttpMethod.GET).request(getRequestUrl(), params);
        return deserializeVFResponseDefault(response.body());
//        return new VFResponse().deserializeJson(response.body());
    }

    protected Map<Object, Object> getParamsFromVFRequest(VFRequest vfRequest) {
        var param = new HashMap<>();
        param.put("ServiceKey", vfRequest.getServiceKey());
        param.put("pageNo", URLEncoder.encode(String.valueOf(vfRequest.getPageNo()), StandardCharsets.UTF_8));
        param.put("numOfRows", URLEncoder.encode(String.valueOf(vfRequest.getNumOfRows()), StandardCharsets.UTF_8));
        param.put("dataType", URLEncoder.encode(vfRequest.getDataType().getValue(), StandardCharsets.UTF_8));
        var paramInner = getParamsFromVFRequestParam(vfRequest.getVfRequestParam());
        param.putAll(paramInner);
        return param;
    }

    protected abstract Map<Object, Object> getParamsFromVFRequestParam(VFRequestParam vfRequestParam);
}
