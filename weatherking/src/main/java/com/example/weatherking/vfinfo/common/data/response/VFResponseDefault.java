package com.example.weatherking.vfinfo.common.data.response;

public class VFResponseDefault {

    private VFResponse response;

    public VFResponse getResponse() {
        return response;
    }

    public void setResponse(VFResponse response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "VFResponseDefault{" +
                "response=" + response +
                '}';
    }
}
