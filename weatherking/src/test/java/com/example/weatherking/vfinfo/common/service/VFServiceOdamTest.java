package com.example.weatherking.vfinfo.common.service;

import com.example.weatherking.util.DateUtil;
import com.example.weatherking.vfinfo.common.config.VFConfig;
import com.example.weatherking.vfinfo.common.data.VFDataType;
import com.example.weatherking.vfinfo.common.data.VFType;
import com.example.weatherking.vfinfo.common.data.request.VFRequest;
import com.example.weatherking.vfinfo.odam.VFRequestParamOdam;

public class VFServiceOdamTest extends AbsVFServiceTest {

    @Override
    protected VFType getVFType() {
        return VFType.VF_ODAM;
    }

    @Override
    protected VFRequest getVFRequestDefault() {
        VFRequest vfRequest = new VFRequest();
        vfRequest.setServiceKey(VFConfig.getServiceKey());
        vfRequest.setPageNo(1);
        vfRequest.setNumOfRows(10);
        vfRequest.setDataType(VFDataType.JSON);
        VFRequestParamOdam vfRequestParamOdam = new VFRequestParamOdam();
        vfRequestParamOdam.setBase_date(DateUtil.dateToStringyyyyMMdd(DateUtil.getDateAfterHours(-1)));
        vfRequestParamOdam.setBase_time(DateUtil.dateToStringHHmm(DateUtil.getDateAfterHours(-1)));
        vfRequestParamOdam.setNx(1);
        vfRequestParamOdam.setNy(1);
        vfRequest.setVfRequestParam(vfRequestParamOdam);
        return vfRequest;
    }
}
