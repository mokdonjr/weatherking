package com.example.weatherking.vfinfo.data.response;

import com.example.weatherking.vfinfo.data.JsonConvertible;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VFResponseDefault implements JsonConvertible<VFResponseDefault> {

    private VFResponse response;

    @Override
    public String serializeJson() {
        return null;
    }

    @Override
    public VFResponseDefault deserializeJson(String json) {
        try {
            var om = new ObjectMapper();
            JsonNode jsonNode = om.readTree(json);
            if (jsonNode.has("response")) {
                response = new VFResponse().deserializeJson(jsonNode.get("response").toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public VFResponse getResponse() {
        return response;
    }

    public void setResponse(VFResponse response) {
        this.response = response;
    }
}
