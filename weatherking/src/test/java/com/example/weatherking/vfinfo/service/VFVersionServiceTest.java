package com.example.weatherking.vfinfo.service;

import com.example.weatherking.util.DateUtil;
import com.example.weatherking.vfinfo.config.VFConfig;
import com.example.weatherking.vfinfo.data.VFDataType;
import com.example.weatherking.vfinfo.data.VFFileType;
import com.example.weatherking.vfinfo.data.VFType;
import com.example.weatherking.vfinfo.data.request.VFRequest;
import com.example.weatherking.vfinfo.data.request.VFRequestParamVersion;

public class VFVersionServiceTest extends AbsVFServiceTest {

    @Override
    protected VFType getVFType() {
        return VFType.VF_VERSION;
    }

    @Override
    protected VFRequest getVFRequestDefault() {
        VFRequest vfRequest = new VFRequest();
        vfRequest.setServiceKey(VFConfig.getServiceKey());
        vfRequest.setPageNo(1);
        vfRequest.setNumOfRows(10);
        vfRequest.setDataType(VFDataType.JSON);
        VFRequestParamVersion vfRequestParamVersion = new VFRequestParamVersion();
        vfRequestParamVersion.setFtype(VFFileType.ODAM);
        vfRequestParamVersion.setBasedatetime(DateUtil.dateToStringyyyyMMddHHmm(DateUtil.getDateAfterHours(-1)));
        vfRequest.setVfRequestParam(vfRequestParamVersion);
        return vfRequest;
    }
}
