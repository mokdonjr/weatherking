package com.example.weatherking.vfinfo.common.data.response;

public class VFResponse {
    private VFHeader header;
    private VFBody body;

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
