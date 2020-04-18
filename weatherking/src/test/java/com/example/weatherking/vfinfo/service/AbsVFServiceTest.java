package com.example.weatherking.vfinfo.service;

import com.example.weatherking.BaseBeanTest;
import com.example.weatherking.vfinfo.data.VFType;
import com.example.weatherking.vfinfo.data.request.VFRequest;
import com.example.weatherking.vfinfo.data.response.VFResponseDefault;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbsVFServiceTest extends BaseBeanTest {

    @Autowired
    protected VFGateService vfGateService;

    @Test
    public void testRequest() {
        VFRequest vfRequest = getVFRequestDefault();
        Assertions.assertNotNull(vfRequest);
        logger.info("요청 : {}", vfRequest.toString());

        // 요청
        VFResponseDefault vfResponseDefault = vfGateService.getVFService(getVFType()).request(vfRequest);
        Assertions.assertNotNull(vfResponseDefault);
        logger.info("결과 : {}", vfResponseDefault.toString());
    }

    protected abstract VFType getVFType();

    protected abstract VFRequest getVFRequestDefault();
}
