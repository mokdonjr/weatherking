package com.example.weatherking.vfinfo.data;

import com.example.weatherking.vfinfo.service.AbsVFService.VFType;

public class VFItemVersion extends AbsVFItem implements JsonConvertible<VFItemVersion> {

    @Override
    public VFType getVFType() {
        return VFType.VF_VERSION;
    }

    public enum VFFileType {
        // 초단기실황
        ODAM,
        // 초단기예보
        VSRT,
        // 동네예보
        SHRT,
        ;
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
}
