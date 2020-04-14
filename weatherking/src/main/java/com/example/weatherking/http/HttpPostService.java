package com.example.weatherking.http;

import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Map;

@Service
public class HttpPostService extends AbsHttpService {

    @Override
    protected HttpRequest getHttpRequest(String url, Map<Object, Object> param) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(requestParams(param)))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .build();
    }
}
