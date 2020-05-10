package com.example.weatherking.vfinfo.version;

import com.example.weatherking.vfinfo.common.data.VFFileType;
import com.example.weatherking.vfinfo.common.data.VFType;
import com.example.weatherking.vfinfo.common.data.response.AbsVFResponseItem;

public class VFResponseItemVersion extends AbsVFResponseItem {

    @Override
    public VFType getVFType() {
        return VFType.VF_VERSION;
    }

    // 파일 버전 (파일 생성 시간)
    private String version; // ex) 20170117082027
    // 파일 구분
    private VFFileType filetype;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public VFFileType getFiletype() {
        return filetype;
    }

    public void setFiletype(VFFileType filetype) {
        this.filetype = filetype;
    }

    @Override
    public String toString() {
        return "VFItemVersion{" +
                "version='" + version + '\'' +
                ", filetype=" + filetype +
                '}';
    }
}
