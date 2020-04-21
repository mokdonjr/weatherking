package com.example.weatherking.vfinfo.service;

import com.example.weatherking.util.DateUtil;
import com.example.weatherking.vfinfo.config.VFConfig;
import com.example.weatherking.vfinfo.data.VFDataType;
import com.example.weatherking.vfinfo.data.request.VFRequest;
import com.example.weatherking.vfinfo.data.request.VFRequestParamWeatherNormal;

public abstract class AbsVFWeatherServiceTest extends AbsVFServiceTest {

    @Override
    protected VFRequest getVFRequestDefault() {
        VFRequest vfRequest = new VFRequest();
        vfRequest.setServiceKey(VFConfig.getServiceKey());
        vfRequest.setPageNo(1);
        vfRequest.setNumOfRows(10);
        vfRequest.setDataType(VFDataType.JSON);
        VFRequestParamWeatherNormal vfRequestParamDataNormal = new VFRequestParamWeatherNormal();
        vfRequestParamDataNormal.setBase_date(DateUtil.dateToStringyyyyMMdd(DateUtil.getDateAfterHours(-1)));
        vfRequestParamDataNormal.setBase_time(DateUtil.dateToStringHHmm(DateUtil.getDateAfterHours(-1)));
        vfRequestParamDataNormal.setNx(1);
        vfRequestParamDataNormal.setNy(1);
        vfRequest.setVfRequestParam(vfRequestParamDataNormal);
        return vfRequest;
    }
}
