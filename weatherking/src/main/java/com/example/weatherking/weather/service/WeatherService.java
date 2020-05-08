package com.example.weatherking.weather.service;

import com.example.weatherking.BaseBean;
import com.example.weatherking.util.DateUtil;
import com.example.weatherking.vfinfo.config.VFConfig;
import com.example.weatherking.vfinfo.data.VFDataType;
import com.example.weatherking.vfinfo.data.VFType;
import com.example.weatherking.vfinfo.data.request.VFRequest;
import com.example.weatherking.vfinfo.data.request.VFRequestParamShrt;
import com.example.weatherking.vfinfo.data.request.VFRequestParamVsrt;
import com.example.weatherking.vfinfo.data.request.VFRequestParamOdam;
import com.example.weatherking.vfinfo.data.response.VFResponseDefault;
import com.example.weatherking.vfinfo.service.VFGateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService extends BaseBean {

    @Autowired
    private VFGateService vfGateService;

    /**
     * 동네예보 조회
     * @param x
     * @param y
     * @return
     */
    public VFResponseDefault getWeatherNormalByLocation(int x, int y) {
        VFRequest vfRequest = new VFRequest();
        vfRequest.setServiceKey(VFConfig.getServiceKey());
        vfRequest.setPageNo(1);
        vfRequest.setNumOfRows(10);
        vfRequest.setDataType(VFDataType.JSON);
        VFRequestParamShrt vfRequestParamDataNormal = new VFRequestParamShrt();
        vfRequestParamDataNormal.setBase_date(DateUtil.dateToStringyyyyMMdd(DateUtil.getDateAfterHours(-1)));
        vfRequestParamDataNormal.setBase_time(DateUtil.dateToStringHHmm(DateUtil.getDateAfterHours(-1)));
        vfRequestParamDataNormal.setNx(x);
        vfRequestParamDataNormal.setNy(y);
        vfRequest.setVfRequestParam(vfRequestParamDataNormal);
        var vfService = vfGateService.getVFService(VFType.VF_SHRT);

        // TODO : 클라가 원하는 데이터로 가공.
        // 일단.. VFResponseDefault로 응답. 클라와 협의
        return vfService.request(vfRequest);
    }

    /**
     * 초단기예보조회
     * @param x
     * @param y
     * @return
     */
    public VFResponseDefault getWeatherUltraForecastByLocation(int x, int y) {
        VFRequest vfRequest = new VFRequest();
        vfRequest.setServiceKey(VFConfig.getServiceKey());
        vfRequest.setPageNo(1);
        vfRequest.setNumOfRows(10);
        vfRequest.setDataType(VFDataType.JSON);
        VFRequestParamVsrt vfRequestParamVsrt = new VFRequestParamVsrt();
        vfRequestParamVsrt.setBase_date(DateUtil.dateToStringyyyyMMdd(DateUtil.getDateAfterHours(-1)));
        vfRequestParamVsrt.setBase_time(DateUtil.dateToStringHHmm(DateUtil.getDateAfterHours(-1)));
        vfRequestParamVsrt.setNx(x);
        vfRequestParamVsrt.setNy(y);
        vfRequest.setVfRequestParam(vfRequestParamVsrt);
        var vfService = vfGateService.getVFService(VFType.VF_VSRT);

        // TODO : 클라가 원하는 데이터로 가공.
        // 일단.. VFResponseDefault로 응답. 클라와 협의
        return vfService.request(vfRequest);
    }

    /**
     * 초단기실황조회
     * @param x
     * @param y
     * @return
     */
    public VFResponseDefault getWeatherUltraCurrentByLocation(int x, int y) {
        VFRequest vfRequest = new VFRequest();
        vfRequest.setServiceKey(VFConfig.getServiceKey());
        vfRequest.setPageNo(1);
        vfRequest.setNumOfRows(10);
        vfRequest.setDataType(VFDataType.JSON);
        VFRequestParamOdam vfRequestParamOdam = new VFRequestParamOdam();
        vfRequestParamOdam.setBase_date(DateUtil.dateToStringyyyyMMdd(DateUtil.getDateAfterHours(-1)));
        vfRequestParamOdam.setBase_time(DateUtil.dateToStringHHmm(DateUtil.getDateAfterHours(-1)));
        vfRequestParamOdam.setNx(x);
        vfRequestParamOdam.setNy(y);
        vfRequest.setVfRequestParam(vfRequestParamOdam);
        var vfService = vfGateService.getVFService(VFType.VF_ODAM);

        // TODO : 클라가 원하는 데이터로 가공.
        // 일단.. VFResponseDefault로 응답. 클라와 협의
        return vfService.request(vfRequest);
    }
}
