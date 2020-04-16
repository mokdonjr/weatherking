package com.example.weatherking.http;

import com.example.weatherking.BaseBean;

import java.io.IOException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public abstract class AbsHttpService extends BaseBean implements IHttpService {

    protected boolean isEnabled = true;

    protected abstract HttpRequest getHttpRequest(String url, Map<Object, Object> param);

    @Override
    public HttpResponse<String> request(String url, Map<Object, Object> param) {
        return sendHttpRequest(getHttpRequest(url, param));
    }

    private HttpResponse<String> sendHttpRequest(HttpRequest httpRequest) {
        long startAt = System.currentTimeMillis();
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();
        HttpResponse<String> httpResponse = null;
        try {
            if (isEnabled) {
                httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        long duration = System.currentTimeMillis() - startAt;
        if (httpResponse == null) {
            logger.info("[HTTP_RESPONSE] duration:{} response is null", duration);
        } else {
            logger.info("[HTTP_RESPONSE] duration:{} response status:{} body:{}", duration, httpResponse.statusCode(), httpResponse.body());
        }

        return httpResponse;
    }

    /**
     * 파라미터 만들기
     * @param param
     * @return
     */
    protected String requestParams(Map<Object, Object> param) {
        var sb = new StringBuilder();
        if (param != null) {
            for (Map.Entry<Object, Object> entry : param.entrySet()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
//                sb.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
                sb.append(entry.getKey().toString());
                sb.append("=");
//                sb.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
                sb.append(entry.getValue().toString());
            }
        }
        return sb.toString();
    }
}