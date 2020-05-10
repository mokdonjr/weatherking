package com.example.weatherking.vfinfo.common.data;

public interface JsonConvertible<T> {

    /**
     * Object to Json
     * @return
     */
    String serializeJson();

    /**
     * Json to Object
     * @param json
     * @return
     */
    T deserializeJson(String json);
}
