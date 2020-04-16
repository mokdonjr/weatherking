package com.example.weatherking.vfinfo.service;

import com.example.weatherking.util.DateUtil;
import com.example.weatherking.vfinfo.config.VFConfig;
import com.example.weatherking.vfinfo.data.VFDataType;
import com.example.weatherking.vfinfo.data.request.VFRequest;
import com.example.weatherking.vfinfo.data.request.VFRequestParamData;
import org.springframework.util.unit.DataUnit;

public abstract class AbsVFDataServiceTest extends AbsVFServiceTest {

    @Override
    protected VFRequest getVFRequestDefault() {
        VFRequest vfRequest = new VFRequest();
        vfRequest.setServiceKey(VFConfig.getServiceKey());
        vfRequest.setPageNo(1);
        vfRequest.setNumOfRows(10);
        vfRequest.setDataType(VFDataType.JSON);
        VFRequestParamData vfRequestParamData = new VFRequestParamData();
        vfRequestParamData.setBase_date(DateUtil.getDateStringFormatyyyyMMdd(DateUtil.getDateAfterHours(-1)));
        vfRequestParamData.setBase_time(DateUtil.getDateStringFormatHHmm(DateUtil.getDateAfterHours(-1)));
        vfRequestParamData.setNx(1);
        vfRequestParamData.setNy(1);
        vfRequest.setVfRequestParam(vfRequestParamData);
        return vfRequest;
    }
}
