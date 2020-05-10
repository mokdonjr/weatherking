package com.example.weatherking.vfinfo;

import com.example.weatherking.util.DateUtil;
import com.example.weatherking.vfinfo.common.config.VFConfig;
import com.example.weatherking.vfinfo.common.data.VFDataType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * 동네예보 조회서비스 api 테스트
 * 	http://apis.data.go.kr/1360000/VilageFcstInfoService
 */
public class VFExampleTest {

    // 아직 인증 못받음
    private String serviceKey = VFConfig.getServiceKey();

    private String dataType = VFDataType.JSON.getValue();

    /**
     * 예보보전조회 테스트
     * http://apis.data.go.kr/1360000/VilageFcstInfoService/getFcstVersion
     * @throws IOException
     */
    @Test
    public void testGetFcstVersion() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService/getFcstVersion"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey",StandardCharsets.UTF_8) + "=" + serviceKey); /*Service Key*/
//        urlBuilder.append("&" + URLEncoder.encode("ServiceKey",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("-", StandardCharsets.UTF_8)); /*공공데이터포털에서 받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("1", StandardCharsets.UTF_8)); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("10", StandardCharsets.UTF_8)); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType",StandardCharsets.UTF_8) + "=" + URLEncoder.encode(dataType, StandardCharsets.UTF_8)); /*요청자료형식(XML/JSON)Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("ftype",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("ODAM", StandardCharsets.UTF_8)); /*파일구분-ODAM: 동네예보실황, -VSRT: 동네예보초단기, -SHRT: 동네예보단기*/
        Date date = DateUtil.getDateAfterHours(-1);
        urlBuilder.append("&" + URLEncoder.encode("basedatetime",StandardCharsets.UTF_8) + "=" + URLEncoder.encode(DateUtil.dateToString(date, "yyyyMMddHHmm"), StandardCharsets.UTF_8)); /*각각의 base_time 로 검색 참고자료 참조*/
//        urlBuilder.append("&" + URLEncoder.encode("base_date",StandardCharsets.UTF_8) + "=" + URLEncoder.encode(DateUtil.dateToString(date, "yyyyMMdd"), StandardCharsets.UTF_8)); /*15년 12월 1일발표*/
//        urlBuilder.append("&" + URLEncoder.encode("base_time",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("0500", StandardCharsets.UTF_8)); /*05시 발표*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        Assertions.assertEquals(200, conn.getResponseCode());
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());

        // 인증 검증
        Assertions.assertFalse(sb.toString().contains("SERVICE_KEY_IS_NOT_REGISTERED_ERROR"));
    }

    /**
     * 동네예보조회
     * http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst
     */
    @Test
    public void testGetVilageFcst() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey",StandardCharsets.UTF_8) + "=" + serviceKey); /*Service Key*/
//        urlBuilder.append("&" + URLEncoder.encode("ServiceKey",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("-", StandardCharsets.UTF_8)); /*공공데이터포털에서 받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("1", StandardCharsets.UTF_8)); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("10", StandardCharsets.UTF_8)); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType",StandardCharsets.UTF_8) + "=" + URLEncoder.encode(dataType, StandardCharsets.UTF_8)); /*요청자료형식(XML/JSON)Default: XML*/
        Date date = DateUtil.getDateAfterHours(-1);
        urlBuilder.append("&" + URLEncoder.encode("base_date",StandardCharsets.UTF_8) + "=" + URLEncoder.encode(DateUtil.dateToString(date, "yyyyMMdd"), StandardCharsets.UTF_8)); /*15년 12월 1일발표*/
        urlBuilder.append("&" + URLEncoder.encode("base_time",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("0500", StandardCharsets.UTF_8)); /*05시 발표*/
        urlBuilder.append("&" + URLEncoder.encode("nx",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("1", StandardCharsets.UTF_8)); /*예보지점 X 좌표값*/
        urlBuilder.append("&" + URLEncoder.encode("ny",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("1", StandardCharsets.UTF_8)); /*예보지점의 Y 좌표값*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        Assertions.assertEquals(200, conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());

        // 인증 검증
        Assertions.assertFalse(sb.toString().contains("SERVICE_KEY_IS_NOT_REGISTERED_ERROR"));
    }

    /**
     * 초단기예보조회 테스트
     * http://apis.data.go.kr/1360000/VilageFcstInfoService/getUltraSrtFcst
     */
    @Test
    public void testGetUltraSrcFcst() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService/getUltraSrtFcst"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey",StandardCharsets.UTF_8) + "=" + serviceKey); /*Service Key*/
//        urlBuilder.append("&" + URLEncoder.encode("ServiceKey",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("-", StandardCharsets.UTF_8)); /*공공데이터포털에서 받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("1", StandardCharsets.UTF_8)); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("10", StandardCharsets.UTF_8)); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType",StandardCharsets.UTF_8) + "=" + URLEncoder.encode(dataType, StandardCharsets.UTF_8)); /*요청자료형식(XML/JSON)Default: XML*/
        Date date = DateUtil.getDateAfterHours(-1);
        urlBuilder.append("&" + URLEncoder.encode("base_date",StandardCharsets.UTF_8) + "=" + URLEncoder.encode(DateUtil.dateToString(date, "yyyyMMdd"), StandardCharsets.UTF_8)); /*15년 12월 1일 발표*/
        urlBuilder.append("&" + URLEncoder.encode("base_time",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("0630", StandardCharsets.UTF_8)); /*06시30분 발표(30분 단위)- 매시각 45분 이후 호출*/
        urlBuilder.append("&" + URLEncoder.encode("nx",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("55", StandardCharsets.UTF_8)); /*예보지점 X 좌표값*/
        urlBuilder.append("&" + URLEncoder.encode("ny",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("127", StandardCharsets.UTF_8)); /*예보지점 Y 좌표값*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        Assertions.assertEquals(200, conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());

        // 인증 검증
        Assertions.assertFalse(sb.toString().contains("SERVICE_KEY_IS_NOT_REGISTERED_ERROR"));
    }

    /**
     * 초단기실황조회 테스트
     * http://apis.data.go.kr/1360000/VilageFcstInfoService/getUltraSrtNcst
     */
    @Test
    public void testGetUltraSrcNcst() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService/getUltraSrtNcst"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey",StandardCharsets.UTF_8) + "=" + serviceKey); /*Service Key*/
//        urlBuilder.append("&" + URLEncoder.encode("ServiceKey",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("-", StandardCharsets.UTF_8)); /*공공데이터포털에서 받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("1", StandardCharsets.UTF_8)); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("10", StandardCharsets.UTF_8)); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType",StandardCharsets.UTF_8) + "=" + URLEncoder.encode(dataType, StandardCharsets.UTF_8)); /*요청자료형식(XML/JSON)Default: XML*/
        Date date = DateUtil.getDateAfterHours(-1);
        urlBuilder.append("&" + URLEncoder.encode("base_date",StandardCharsets.UTF_8) + "=" + URLEncoder.encode(DateUtil.dateToString(date, "yyyyMMdd"), StandardCharsets.UTF_8)); /*15년 12월 1일 발표*/
        urlBuilder.append("&" + URLEncoder.encode("base_time",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("0600", StandardCharsets.UTF_8)); /*06시 발표(정시단위)*/
        urlBuilder.append("&" + URLEncoder.encode("nx",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("18", StandardCharsets.UTF_8)); /*예보지점의 X 좌표값*/
        urlBuilder.append("&" + URLEncoder.encode("ny",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("1", StandardCharsets.UTF_8)); /*예보지점 Y 좌표*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        Assertions.assertEquals(200, conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());

        // 인증 검증
        Assertions.assertFalse(sb.toString().contains("SERVICE_KEY_IS_NOT_REGISTERED_ERROR"));
    }
}
