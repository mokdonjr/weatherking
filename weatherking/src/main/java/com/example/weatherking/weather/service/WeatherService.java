package com.example.weatherking.weather.service;

import com.example.weatherking.BaseBean;
import com.example.weatherking.util.DateUtil;
import com.example.weatherking.vfinfo.common.config.VFConfig;
import com.example.weatherking.vfinfo.common.data.VFDataType;
import com.example.weatherking.vfinfo.common.data.VFType;
import com.example.weatherking.vfinfo.common.data.request.VFRequest;
import com.example.weatherking.vfinfo.common.data.response.VFResponseDefault;
import com.example.weatherking.vfinfo.common.service.VFGateService;
import com.example.weatherking.vfinfo.odam.VFRequestParamOdam;
import com.example.weatherking.vfinfo.shrt.VFRequestParamShrt;
import com.example.weatherking.vfinfo.vsrt.VFRequestParamVsrt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO : 클라가 원하는 응답으로 바꿔야함. 폐기!!
 * TODO : 여기 설계를 잘해야함!!
 */
@Deprecated
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
        VFRequestParamShrt vfRequestParamShrt = new VFRequestParamShrt();
        vfRequestParamShrt.setBase_date(DateUtil.dateToStringyyyyMMdd(DateUtil.getDateAfterHours(-1)));
        vfRequestParamShrt.setBase_time(DateUtil.dateToStringHHmm(DateUtil.getDateAfterHours(-1)));
        vfRequestParamShrt.setNx(x);
        vfRequestParamShrt.setNy(y);
        vfRequest.setVfRequestParam(vfRequestParamShrt);
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
