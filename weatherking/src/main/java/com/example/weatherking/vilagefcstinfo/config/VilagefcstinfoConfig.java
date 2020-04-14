package com.example.weatherking.vilagefcstinfo.config;

import com.example.weatherking.StaticBaseBean;

/**
 * 동네예보 조회서비스 설정
 */
public class VilagefcstinfoConfig extends StaticBaseBean {

    // TODO : 귀찮아서 코드에 넣음. 런칭시 재발급 받고 젠킨스에 등록
    private static String serviceKey = "PL%2FKcH3KbBlOj6hXmAOjVXZ%2FhEepCaeJp%2FLxDJcRmcXd4YgnS3b7bOmuG87ECgbmnBd%2B0yygQ%2FTKND3J3JDB2A%3D%3D";

    public static String getServiceKey() {
        return serviceKey;
    }

    public static void setServiceKey(String serviceKey) {
        VilagefcstinfoConfig.serviceKey = serviceKey;
    }
}
