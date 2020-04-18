package com.example.weatherking.vfinfo.service;

import com.example.weatherking.vfinfo.data.VFType;
import com.example.weatherking.vfinfo.data.request.VFRequest;
import com.example.weatherking.vfinfo.data.response.VFItem;
import com.example.weatherking.vfinfo.data.response.VFResponseDefault;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * 동네예보 서비스
 */
public interface VFService {

    /**
     * 동네예보 타입
     * @return
     */
    VFType getVFType();

    /**
     * 동네예보 요청 URL
     * @return
     */
    default String getRequestUrl() {
        return getVFType().getRequestUrl();
    }

    /**
     * 동네예보 응답 데이터 타입 인스턴스로 가져오기
     * @return
     */
    VFItem getVFItemInstance();

    /**
     * 동네예보 요청하기
     * @param data
     * @return
     */
    VFResponseDefault request(VFRequest data);

    /**
     * 동네예보 응답 데이터 역직렬화하기
     * @param json
     * @return
     */
    VFResponseDefault deserializeVFResponseDefault(String json);
    VFResponseDefault deserializeVFResponseDefault(JsonNode jsonNode);
}
