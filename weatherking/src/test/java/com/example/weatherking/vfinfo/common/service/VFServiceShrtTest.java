package com.example.weatherking.vfinfo.common.service;

import com.example.weatherking.util.DateUtil;
import com.example.weatherking.vfinfo.common.config.VFConfig;
import com.example.weatherking.vfinfo.common.data.VFDataType;
import com.example.weatherking.vfinfo.common.data.VFType;
import com.example.weatherking.vfinfo.common.data.request.VFRequest;
import com.example.weatherking.vfinfo.shrt.VFRequestParamShrt;

public class VFServiceShrtTest extends AbsVFServiceTest {

    @Override
    protected VFType getVFType() {
        return VFType.VF_SHRT;
    }

    @Override
    protected VFRequest getVFRequestDefault() {
        VFRequest vfRequest = new VFRequest();
        vfRequest.setServiceKey(VFConfig.getServiceKey());
        vfRequest.setPageNo(1);
        vfRequest.setNumOfRows(10);
        vfRequest.setDataType(VFDataType.JSON);
        VFRequestParamShrt vfRequestParamShrt = new VFRequestParamShrt();
        vfRequestParamShrt.setBase_date(DateUtil.dateToStringyyyyMMdd(DateUtil.getDateAfterHours(-1)));
        vfRequestParamShrt.setBase_time(DateUtil.dateToStringHHmm(DateUtil.getDateAfterHours(-1)));
        vfRequestParamShrt.setNx(1);
        vfRequestParamShrt.setNy(1);
        vfRequest.setVfRequestParam(vfRequestParamShrt);
        return vfRequest;
    }
}
