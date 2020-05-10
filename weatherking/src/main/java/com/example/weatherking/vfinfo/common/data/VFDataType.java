package com.example.weatherking.vfinfo.common.data;

public enum  VFDataType {
    XML("XML"),
    JSON("JSON"),
    ;

    private String value;

    VFDataType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
