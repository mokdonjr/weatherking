package com.example.weatherking.http;

import java.net.http.HttpResponse;
import java.util.Map;

public interface IHttpService {

    /**
     * HTTP 요청후 응답 반환
     * @param url
     * @param param
     * @return
     */
    public HttpResponse<String> request(String url, Map<Object, Object> param);
}