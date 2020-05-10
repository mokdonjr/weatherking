package com.example.weatherking.vfinfo.common.service;

import com.example.weatherking.util.DateUtil;
import com.example.weatherking.vfinfo.common.config.VFConfig;
import com.example.weatherking.vfinfo.common.data.VFDataType;
import com.example.weatherking.vfinfo.common.data.VFFileType;
import com.example.weatherking.vfinfo.common.data.VFType;
import com.example.weatherking.vfinfo.common.data.request.VFRequest;
import com.example.weatherking.vfinfo.version.VFRequestParamVersion;

public class VFServiceVersionTest extends AbsVFServiceTest {

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
