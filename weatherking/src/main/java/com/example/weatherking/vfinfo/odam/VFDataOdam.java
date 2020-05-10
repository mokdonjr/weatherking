package com.example.weatherking.vfinfo.odam;

import java.util.Date;

/**
 * VF_ODAM 테이블
 * 초단기실황기록
 */
public class VFDataOdam {
    private Date noticeAt; // pk
    private Integer nx; // pk
    private Integer ny; // pk
    private VFCategoryOdam category; // pk
    private String value;
    private Date createAt;

    public Date getNoticeAt() {
        return noticeAt;
    }

    public void setNoticeAt(Date noticeAt) {
        this.noticeAt = noticeAt;
    }

    public Integer getNx() {
        return nx;
    }

    public void setNx(Integer nx) {
        this.nx = nx;
    }

    public Integer getNy() {
        return ny;
    }

    public void setNy(Integer ny) {
        this.ny = ny;
    }

    public VFCategoryOdam getCategory() {
        return category;
    }

    public void setCategory(VFCategoryOdam category) {
        this.category = category;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
