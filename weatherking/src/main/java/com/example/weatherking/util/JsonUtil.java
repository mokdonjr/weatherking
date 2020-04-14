package com.example.weatherking.util;

import com.example.weatherking.StaticBaseBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.List;

public class JsonUtil extends StaticBaseBean {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String prettyIndentJson(Object o) throws JSONException {
        int indentNum = 4;
        String result = null;
        try {
            result = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        if (o instanceof List) {
            JSONArray jsonArray = new JSONArray(result);
            return jsonArray.toString(indentNum);
        } else {
            JSONObject jsonObject = new JSONObject(result);
            return jsonObject.toString(indentNum);
        }
    }
}
