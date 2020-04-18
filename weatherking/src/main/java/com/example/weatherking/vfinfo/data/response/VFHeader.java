package com.example.weatherking.vfinfo.data.response;

import com.example.weatherking.vfinfo.data.JsonConvertible;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VFHeader implements JsonConvertible<VFHeader> {
    private String resultCode;
    private String resultMsg;

    @Override
    public String serializeJson() {
        return null;
    }

    @Override
    public VFHeader deserializeJson(String json) {
        try {
            var om = new ObjectMapper();
            JsonNode jsonNode = om.readTree(json);
            if (jsonNode.has("resultCode")) {
                resultCode = jsonNode.get("resultCode").toString();
            }
            if (jsonNode.has("resultMsg")) {
                resultMsg = jsonNode.get("resultMsg").toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    @Override
    public String toString() {
        return "VFHeader{" +
                "resultCode='" + resultCode + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                '}';
    }
}
