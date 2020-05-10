package com.example.weatherking.vfinfo.common.config;

import com.example.weatherking.StaticBaseBean;
import com.example.weatherking.vfinfo.common.data.VFDataType;

/**
 * 동네예보 조회서비스 설정
 */
public class VFConfig extends StaticBaseBean {

    public static final int NX_DEFAULT_VALUE = 59;
    public static final int NY_DEFAULT_VALUE = 125;
    public static final int PAGE_NO_DEFAULT_VALUE = 1;
    public static final int NUM_OF_ROWS_DEFAULT_VALUE = 10;
    public static final VFDataType DATA_TYPE_DEFAULT_VALUE = VFDataType.JSON;

    // TODO : 귀찮아서 코드에 넣음. 런칭시 재발급 받고 젠킨스에 등록
    private static String serviceKey = "PL%2FKcH3KbBlOj6hXmAOjVXZ%2FhEepCaeJp%2FLxDJcRmcXd4YgnS3b7bOmuG87ECgbmnBd%2B0yygQ%2FTKND3J3JDB2A%3D%3D";

    public static String getServiceKey() {
        return serviceKey;
    }

    public static void setServiceKey(String serviceKey) {
        VFConfig.serviceKey = serviceKey;
    }
}
