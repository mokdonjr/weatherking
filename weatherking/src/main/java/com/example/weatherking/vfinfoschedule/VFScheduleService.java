package com.example.weatherking.vfinfoschedule;

import com.example.weatherking.BaseBean;
import com.example.weatherking.util.JsonUtil;
import com.example.weatherking.vfinfo.common.data.VFType;
import com.example.weatherking.vfinfo.common.data.response.VFResponseDefault;
import com.example.weatherking.vfinfo.common.service.VFGateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 동네예보 api 수집 스케쥴 서비스
 */
@Service
public class VFScheduleService extends BaseBean {

    @Autowired
    private VFGateService vfGateService;

//    @Scheduled(fixedDelay = 5000)
    public void scheduleDefault() throws JSONException {
        /*// 초단기 실황 조회
        VFServiceOdam vfServiceOdam = (VFServiceOdam) vfGateService.getVFService(VFType.VF_ODAM);
        VFResponseDefault responseOdam = vfServiceOdam.requestDefault();
        logger.info("[초단기 실황 조회 - ODAM]");
        logger.info(JsonUtil.prettyIndentJson(responseOdam));

        // 초단기 예보 조회
        VFServiceVsrt vfServiceVsrt = (VFServiceVsrt) vfGateService.getVFService(VFType.VF_VSRT);
        VFResponseDefault responseVsrt = vfServiceVsrt.requestDefault();
        logger.info("[초단기 예보 조회 - VSRT]");
        logger.info(JsonUtil.prettyIndentJson(responseVsrt));

        // 동네 예보 조회
        VFServiceShrt vfServiceShrt = (VFServiceShrt) vfGateService.getVFService(VFType.VF_SHRT);
        VFResponseDefault responseShrt = vfServiceShrt.requestDefault();
        logger.info("[동네 예보 - SHRT]");
        logger.info(JsonUtil.prettyIndentJson(responseShrt));

        // 버전 조회
        VFServiceVersion vfServiceVersion = (VFServiceVersion) vfGateService.getVFService(VFType.VF_VERSION);
        VFResponseDefault responseVersion = vfServiceVersion.requestDefault();
        logger.info("[버전 조회 - VERSION]");
        logger.info(JsonUtil.prettyIndentJson(responseVersion));*/
    }

    public void scheduleAll() throws JSONException {
        for (VFType vfType : VFType.values()) {
            logger.info("[{}] 스케쥴!", vfType);
            List<VFResponseDefault> vfResponseList = vfGateService.getVFService(vfType).requestDefault();
            logger.info(JsonUtil.prettyIndentJson(vfResponseList));

            // DB 저장

        }
    }
}
