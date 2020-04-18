package com.example.weatherking.vfinfo.data.response;

import com.example.weatherking.vfinfo.data.JsonConvertible;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VFResponse implements JsonConvertible<VFResponse> {
    private VFHeader header;
    private VFBody body;

    @Override
    public String serializeJson() {
        return null;
    }

    @Override
    public VFResponse deserializeJson(String json) {
        try {
            var om = new ObjectMapper();
            JsonNode jsonNode = om.readTree(json);
            if (jsonNode.has("header")) {
                header = new VFHeader().deserializeJson(jsonNode.get("header").toString());
            }
            if (jsonNode.has("body")) {
                body = new VFBody().deserializeJson(jsonNode.get("body").toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public VFHeader getHeader() {
        return header;
    }

    public void setHeader(VFHeader header) {
        this.header = header;
    }

    public VFBody getBody() {
        return body;
    }

    public void setBody(VFBody body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "VFResponse{" +
                "header=" + header +
                ", body=" + body +
                '}';
    }
}
