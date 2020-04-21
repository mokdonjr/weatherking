package com.example.weatherking.util;

import com.example.weatherking.StaticBaseBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class JsonUtil extends StaticBaseBean {

    private static ObjectMapper objectMapper = new ObjectMapper();
    static {
        objectMapper.setDateFormat(new SimpleDateFormat(DateUtil.DEFAULT_DATE_FORMAT));
    }

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

    /**
     * 자식 노드 가져오기
     * @param jsonNode
     * @param fieldName
     * @return
     */
    public static JsonNode getJsonNode(JsonNode jsonNode, String fieldName) {
        if (!jsonNode.has(fieldName))
            return null;

        var child = jsonNode.get(fieldName);
        if (child.isNull())
            return null;

        return child;
    }

    public static String getJsonString(JsonNode jsonNode, String fieldName) {
        var child = getJsonNode(jsonNode, fieldName);
        return child == null ? null : child.asText();
    }

    public static Integer getJsonInt(JsonNode jsonNode, String fieldName) {
        var child = getJsonNode(jsonNode, fieldName);
        return child == null ? null : child.asInt();
    }

    public static Long getJsonLong(JsonNode jsonNode, String fieldName) {
        var child = getJsonNode(jsonNode, fieldName);
        return child == null ? null : child.asLong();
    }

    public static Boolean getJsonBoolean(JsonNode jsonNode, String fieldName) {
        var child = getJsonNode(jsonNode, fieldName);
        return child == null ? null : child.asBoolean();
    }

    public static Double getJsonDouble(JsonNode jsonNode, String fieldName) {
        var child = getJsonNode(jsonNode, fieldName);
        return child == null ? null : child.asDouble();
    }

    public static Date getJsonDate(JsonNode jsonNode, String fieldName, String format) {
        String date = getJsonString(jsonNode, fieldName);
        if (date != null) {
            return DateUtil.stringToDate(date, format);
        }
        return null;
    }

    public static Date getJsonDate(JsonNode jsonNode, String fieldName) {
        return getJsonDate(jsonNode, fieldName, DateUtil.DEFAULT_DATE_FORMAT);
    }
}
