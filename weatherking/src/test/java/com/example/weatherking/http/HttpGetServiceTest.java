package com.example.weatherking.http;

import org.springframework.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

public class HttpGetServiceTest extends AbsHttpServiceTest {
    @Override
    protected HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected String getTestRequestUrl() {
        return "https://postman-echo.com/get";
    }

    @Override
    protected Map<Object, Object> getTestRequestParam() {
        var param = new HashMap<>();
        param.put("foo1", "bar1");
        param.put("foo2", "bar2");
        return param;
    }
}