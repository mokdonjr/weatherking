package com.example.weatherking.vfinfo.service;

import com.example.weatherking.BaseBean;
import com.example.weatherking.http.HttpGateService;
import com.example.weatherking.vfinfo.data.request.VFRequest;
import com.example.weatherking.vfinfo.data.request.VFRequestParam;
import com.example.weatherking.vfinfo.data.response.VFResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;

import java.net.URLEncoder;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public abstract class AbsVFService extends BaseBean implements VFService {

    @Autowired
    private HttpGateService httpGateService;

    public enum VFType {
        // 예보버전조회
        VF_VERSION("http://apis.data.go.kr/1360000/VilageFcstInfoService/getFcstVersion"),
        // 동네예보조회
        VF_DATA("http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst"),
        // 초단기예보조회
        VF_ULTRA_SRT_FCST("http://apis.data.go.kr/1360000/VilageFcstInfoService/getUltraSrtFcst"),
        // 초단기실황조회
        VF_ULTRA_SRT_NCST("http://apis.data.go.kr/1360000/VilageFcstInfoService/getUltraSrtNcst"),
        ;

        private String requestUrl;

        VFType(String requestUrl) {
            this.requestUrl = requestUrl;
        }

        public String getRequestUrl() {
            return requestUrl;
        }
    }

    @Override
    public VFResponse requestDefault(VFRequest data) {
        var params = getParamsFromVFRequest(data);
        HttpResponse<String> response = httpGateService.getHttpService(HttpMethod.GET).request(getRequestUrl(), params);
        return new VFResponse().deserializeJson(response.body());
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
