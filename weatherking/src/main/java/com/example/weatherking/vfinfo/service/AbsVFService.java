package com.example.weatherking.vfinfo.service;

import com.example.weatherking.BaseBean;

public abstract class AbsVFService extends BaseBean implements VFService {

    public enum VFType {
        // 예보버전조회
        VF_VERSION("http://apis.data.go.kr/1360000/VilageFcstInfoService/getFcstVersion"),
        // 동네예보조회
        VF_DATA("http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst"),
        // 초단기예보조회
        VF_ULTRA_SRT_FCST("http://apis.data.go.kr/1360000/VilageFcstInfoService/getUltraSrtFcst"),
        // 초단기실황조회
        VF_ULTRA_SRT_NCST("http://apis.data.go.kr/1360000/VilageFcstInfoService/getUltraSrtNcst"),
        ;

        private String requestUrl;

        VFType(String requestUrl) {
            this.requestUrl = requestUrl;
        }

        public String getRequestUrl() {
            return requestUrl;
        }
    }
}
