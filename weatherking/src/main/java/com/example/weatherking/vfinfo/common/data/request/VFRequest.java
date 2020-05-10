package com.example.weatherking.vfinfo.common.data.request;

import com.example.weatherking.vfinfo.common.data.VFDataType;

public class VFRequest {
    // 서비스키
    private String ServiceKey;
    // 페이지번호
    private int pageNo;
    // 페이지당 결과 수
    private int numOfRows;
    // 응답 데이터 타입
    private VFDataType dataType;
    // 추가 파라미터
    private VFRequestParam vfRequestParam;

    public String getServiceKey() {
        return ServiceKey;
    }

    public void setServiceKey(String serviceKey) {
        ServiceKey = serviceKey;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getNumOfRows() {
        return numOfRows;
    }

    public void setNumOfRows(int numOfRows) {
        this.numOfRows = numOfRows;
    }

    public VFDataType getDataType() {
        return dataType;
    }

    public void setDataType(VFDataType dataType) {
        this.dataType = dataType;
    }

    public VFRequestParam getVfRequestParam() {
        return vfRequestParam;
    }

    public void setVfRequestParam(VFRequestParam vfRequestParam) {
        this.vfRequestParam = vfRequestParam;
    }

    @Override
    public String toString() {
        return "VFRequest{" +
                "ServiceKey='" + ServiceKey + '\'' +
                ", pageNo=" + pageNo +
                ", numOfRows=" + numOfRows +
                ", dataType=" + dataType +
                ", vfRequestParam=" + vfRequestParam +
                '}';
    }
}
