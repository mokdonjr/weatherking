package com.example.weatherking.vfinfo.data.response;

import com.example.weatherking.vfinfo.data.JsonConvertible;
import com.example.weatherking.vfinfo.data.VFDataType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class VFBody implements JsonConvertible<VFBody> {
    private VFDataType dataType;
    private List<VFItem> items;
    private Integer pageNo;
    private Integer numOfRows;
    private Integer totalCount;

    @Override
    public String serializeJson() {
        return null;
    }

    @Override
    public VFBody deserializeJson(String json) {
        try {
            var om = new ObjectMapper();
            JsonNode jsonNode = om.readTree(json);
            if (jsonNode.has("dataType")) {
                dataType = VFDataType.valueOf(jsonNode.get("dataType").toString());
            }
            if (jsonNode.has("items")) {
                // TODO : 추상화 불가
//                List<VFItem> list = new ArrayList<>();
//                Iterator<JsonNode> iter = jsonNode.get("items").elements();
//                while (iter.hasNext()) {
//                    JsonNode n = iter.next();
//                    n.
//                    new VFItem().deserializeJson(iter.next().toString());
//                    list.add(iter.next())
//                }
            }
            if (jsonNode.has("pageNo")) {
                pageNo = jsonNode.get("pageNo").asInt();
            }
            if (jsonNode.has("numOfRows")) {
                numOfRows = jsonNode.get("numOfRows").asInt();
            }
            if (jsonNode.has("totalCount")) {
                totalCount = jsonNode.get("totalCount").asInt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public VFDataType getDataType() {
        return dataType;
    }

    public void setDataType(VFDataType dataType) {
        this.dataType = dataType;
    }

    public List<VFItem> getItems() {
        return items;
    }

    public void setItems(List<VFItem> items) {
        this.items = items;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getNumOfRows() {
        return numOfRows;
    }

    public void setNumOfRows(Integer numOfRows) {
        this.numOfRows = numOfRows;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "VFBody{" +
                "dataType='" + dataType + '\'' +
                ", items=" + items +
                ", pageNo=" + pageNo +
                ", numOfRows=" + numOfRows +
                ", totalCount=" + totalCount +
                '}';
    }
}
