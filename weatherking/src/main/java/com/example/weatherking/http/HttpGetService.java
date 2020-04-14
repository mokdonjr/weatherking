package com.example.weatherking.http;

import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Map;

@Service
public class HttpGetService extends AbsHttpService {

    @Override
    protected HttpRequest getHttpRequest(String url, Map<Object, Object> param) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url + "?" + requestParams(param)))
                .GET()
                .header("Content-Type", "text/plain; charset=euc-kr")
                .build();
    }
}
