package com.example.weatherking.vfinfo.data.response;

import com.example.weatherking.vfinfo.data.JsonConvertible;
import com.example.weatherking.vfinfo.data.VFFileType;
import com.example.weatherking.vfinfo.service.AbsVFService.VFType;

public class VFItemVersion extends AbsVFItem implements JsonConvertible<VFItemVersion> {

    @Override
    public VFType getVFType() {
        return VFType.VF_VERSION;
    }

    // 파일 버전 (파일 생성 시간)
    private String version; // ex) 20170117082027
    // 파일 구분
    private VFFileType filetype;

    @Override
    public String serializeJson() {
        return null;
    }

    @Override
    public VFItemVersion deserializeJson(String json) {
        return null;
    }

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
