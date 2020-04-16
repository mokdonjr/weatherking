package com.example.weatherking.vfinfo.data.response;

import com.example.weatherking.vfinfo.data.JsonConvertible;

public class VFResponse implements JsonConvertible<VFResponse> {
    private VFHeader header;
    private VFBody body;

    @Override
    public String serializeJson() {
        return null;
    }

    @Override
    public VFResponse deserializeJson(String json) {
        return null;
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
