package com.example.weatherking.vfinfo.data.response;

import com.example.weatherking.vfinfo.data.JsonConvertible;

import java.util.List;

public class VFBody implements JsonConvertible<VFBody> {
    private String dataType;
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
        return null;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
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
