package com.example.weatherking.util;

import com.example.weatherking.StaticBaseBean;

import java.util.Map;

public class StringUtil extends StaticBaseBean {

    /**
     * 문자열 양끝 공백 및 쌍따옴표 정리
     * @param str
     * @return
     */
    public static String trimDoubleQuotes(String str) {
        var arr = str.trim().toCharArray();

        // 앞자리 찾기
        int beginIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c != "\"".charAt(0)) {
                beginIndex = i;
                break;
            }
        }

        // 뒷자리 찾기
        int endIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[arr.length - i - 1];
            if (c != "\"".charAt(0)) {
                endIndex = arr.length - i;
                break;
            }
        }

        return str.substring(beginIndex, endIndex);
    }

    /**
     * QueryString 만들기
     * - 첫파라미터 구분자 (?)
     * - 이후 파라미터 구분자 (&)
     * @param param
     * @return
     */
    public static String getQueryString(Map<Object, Object> param) {
        var sb = new StringBuilder();
        if (param != null) {
            for (Map.Entry<Object, Object> entry : param.entrySet()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
//                sb.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
                sb.append(entry.getKey().toString());
                sb.append("=");
//                sb.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
                sb.append(entry.getValue().toString());
            }
        }
        return sb.toString();
    }
}
