package com.example.weatherking.vfinfo.data.response;

import com.example.weatherking.vfinfo.data.JsonConvertible;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbsVFItemData extends AbsVFItem implements JsonConvertible<VFItem> {
    // 발표일자 (yyyyMMdd)
    protected String baseDate;
    // 발표시각 (HHmm)
    protected String baseTime;
    // 예보일자 (yyyyMMdd)
    protected String fcstDate;
    // 예보시각 (HHmm)
    protected String fcstTime;
    // 자료구분문자
    protected String category;
    // 예보값
    protected String fcstValue; // optional
    // 예보지점 x좌표
    protected Integer nx; // optional
    // 예보지점 y좌표
    protected Integer ny; // optional

    @Override
    public String serializeJson() {
        return null;
    }

    @Override
    public VFItem deserializeJson(String json) {
        try {
            var om = new ObjectMapper();
            JsonNode jsonNode = om.readTree(json);
            if (jsonNode.has("baseDate")) {
                baseDate = jsonNode.get("baseDate").toString();
            }
            if (jsonNode.has("baseTime")) {
                baseTime = jsonNode.get("baseTime").toString();
            }
            if (jsonNode.has("fcstDate")) {
                fcstDate = jsonNode.get("fcstDate").toString();
            }
            if (jsonNode.has("fcstTime")) {
                fcstTime = jsonNode.get("fcstTime").toString();
            }
            if (jsonNode.has("category")) {
                category = jsonNode.get("category").toString();
            }
            if (jsonNode.has("fcstValue")) {
                fcstValue = jsonNode.get("fcstValue").toString();
            }
            if (jsonNode.has("nx")) {
                nx = jsonNode.get("nx").asInt();
            }
            if (jsonNode.has("ny")) {
                ny = jsonNode.get("ny").asInt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public String getBaseDate() {
        return baseDate;
    }

    public void setBaseDate(String baseDate) {
        this.baseDate = baseDate;
    }

    public String getBaseTime() {
        return baseTime;
    }

    public void setBaseTime(String baseTime) {
        this.baseTime = baseTime;
    }

    public String getFcstDate() {
        return fcstDate;
    }

    public void setFcstDate(String fcstDate) {
        this.fcstDate = fcstDate;
    }

    public String getFcstTime() {
        return fcstTime;
    }

    public void setFcstTime(String fcstTime) {
        this.fcstTime = fcstTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFcstValue() {
        return fcstValue;
    }

    public void setFcstValue(String fcstValue) {
        this.fcstValue = fcstValue;
    }

    public Integer getNx() {
        return nx;
    }

    public void setNx(Integer nx) {
        this.nx = nx;
    }

    public Integer getNy() {
        return ny;
    }

    public void setNy(Integer ny) {
        this.ny = ny;
    }

    @Override
    public String toString() {
        return "AbsVFItemData{" +
                "baseDate='" + baseDate + '\'' +
                ", baseTime='" + baseTime + '\'' +
                ", fcstDate='" + fcstDate + '\'' +
                ", fcstTime='" + fcstTime + '\'' +
                ", category='" + category + '\'' +
                ", fcstValue='" + fcstValue + '\'' +
                ", nx=" + nx +
                ", ny=" + ny +
                '}';
    }
}
