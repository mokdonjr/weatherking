package com.example.weatherking.vfinfo.data.request;

import com.example.weatherking.vfinfo.data.VFFileType;
import com.example.weatherking.vfinfo.data.VFType;

public class VFRequestParamVersion extends AbsVFRequestParam {
    @Override
    public VFType getVFType() {
        return VFType.VF_VERSION;
    }

    // 파일구분
    private VFFileType ftype;
    // 발표시각 (yyyyMMddHHmm)
    private String basedatetime;

    public VFFileType getFtype() {
        return ftype;
    }

    public void setFtype(VFFileType ftype) {
        this.ftype = ftype;
    }

    public String getBasedatetime() {
        return basedatetime;
    }

    public void setBasedatetime(String basedatetime) {
        this.basedatetime = basedatetime;
    }

    @Override
    public String toString() {
        return "VFRequestParamVersion{" +
                "ftype=" + ftype +
                ", basedatetime='" + basedatetime + '\'' +
                '}';
    }
}
