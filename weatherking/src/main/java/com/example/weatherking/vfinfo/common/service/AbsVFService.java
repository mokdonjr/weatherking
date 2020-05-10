package com.example.weatherking.vfinfo.common.service;

import com.example.weatherking.BaseBean;
import com.example.weatherking.http.HttpGateService;
import com.example.weatherking.util.JsonUtil;
import com.example.weatherking.vfinfo.common.data.VFDataType;
import com.example.weatherking.vfinfo.common.data.request.VFRequest;
import com.example.weatherking.vfinfo.common.data.request.VFRequestParam;
import com.example.weatherking.vfinfo.common.data.response.*;
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

    /**
     * 동네예보 응답 데이터 역직렬화하기
     * @param json
     * @return
     */
    private VFResponseDefault deserializeVFResponseDefault(String json) {
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

    /**
     * 동네예보 응답 데이터 역직렬화하기
     * @param jsonNode
     * @return
     */
    private VFResponseDefault deserializeVFResponseDefault(JsonNode jsonNode) {
        var data = new VFResponseDefault();
        if (jsonNode.has("response")) {
            var response = new VFResponse();
            var jsonNodeResponse = jsonNode.get("response");
            if (jsonNodeResponse.has("header")) {
                var jsonNodeHeader = jsonNodeResponse.get("header");
                var header = new VFHeader();
                header.setResultCode(JsonUtil.getJsonString(jsonNodeHeader, "resultCode"));
                header.setResultMsg(JsonUtil.getJsonString(jsonNodeHeader, "resultMsg"));
                response.setHeader(header);
            }
            if (jsonNodeResponse.has("body")) {
                var body = new VFBody();
                var jsonNodeBody = jsonNodeResponse.get("body");
                body.setDataType(VFDataType.valueOf(JsonUtil.getJsonString(jsonNodeBody, "dataType")));
                if (jsonNodeBody.has("items")) {
                    List<VFItem> list = new ArrayList<>();
                    JsonNode jsonNodeItems = jsonNodeBody.get("items");
                    if (jsonNodeItems.has("item")) {
                        JsonNode jsonNodeItem = jsonNodeItems.get("item");
                        Iterator<JsonNode> jsonNodeItemIterator = jsonNodeItem.elements();
                        while (jsonNodeItemIterator.hasNext()) {
                            JsonNode jsonNodePerItem = jsonNodeItemIterator.next();
                            var item = deserializeVFItem(jsonNodePerItem);
                            list.add(item);
                        }
                    }
                    body.setItems(list);
                }
                body.setPageNo(JsonUtil.getJsonInt(jsonNodeBody, "pageNo"));
                body.setNumOfRows(JsonUtil.getJsonInt(jsonNodeBody, "numOfRows"));
                body.setTotalCount(JsonUtil.getJsonInt(jsonNodeBody, "totalCount"));
                response.setBody(body);
            }
            data.setResponse(response);
        }
        return data;
    }

    /**
     * 동네예보 응답데이터 타입별 역직렬화하기
     * @param jsonNode
     * @return
     */
    protected abstract VFItem deserializeVFItem(JsonNode jsonNode);

    @Override
    public VFResponseDefault requestDefault() {
        return request(getVFRequestDefault());
    }

    @Override
    public VFResponseDefault request(VFRequest data) {
        var params = getParamsFromVFRequest(data);
        HttpResponse<String> response = httpGateService.getHttpService(HttpMethod.GET).request(getRequestUrl(), params);
        return deserializeVFResponseDefault(response.body());
    }

    /**
     * 동네예보 요청데이터 파라미터 만들기
     * @param vfRequest
     * @return
     */
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

    /**
     * 동네예보 요청데이터 타입별 파라미터 만들기
     * @param vfRequestParam
     * @return
     */
    protected abstract Map<Object, Object> getParamsFromVFRequestParam(VFRequestParam vfRequestParam);

    protected abstract VFCategory getVFCategory(String category);
}
