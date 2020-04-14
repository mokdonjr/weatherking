package com.example.weatherking.http;

import com.example.weatherking.BaseBeanTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;

import java.util.Map;

public abstract class AbsHttpServiceTest extends BaseBeanTest {
    protected abstract HttpMethod getHttpMethod();
    protected abstract String getTestRequestUrl();
    protected abstract Map<Object, Object> getTestRequestParam();

    @Autowired
    private HttpGateService httpGateService;

    @Test
    public void testHttpRequest() {
        logger.info("[TEST_HTTP_REQUEST] HttpMethod:{}", getHttpMethod());
        var response = httpGateService.getHttpService(getHttpMethod()).request(getTestRequestUrl(), getTestRequestParam());
        Assertions.assertAll(
                () -> Assertions.assertNotNull(response),
                () -> Assertions.assertEquals(200, response.statusCode())
        );
        logger.info("[TEST_HTTP_REQUEST] HttpMethod:{}, body:{}", getHttpMethod(), response.body());
    }
}
