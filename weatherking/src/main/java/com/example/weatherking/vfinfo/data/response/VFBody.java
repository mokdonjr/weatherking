package com.example.weatherking.vfinfo.data.response;

import com.example.weatherking.vfinfo.data.VFDataType;

import java.util.List;

public class VFBody {
    private VFDataType dataType;
    private List<VFItem> items;
    private Integer pageNo;
    private Integer numOfRows;
    private Integer totalCount;

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
