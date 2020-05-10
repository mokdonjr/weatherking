package com.example.weatherking.vfinfo.common.data;

public enum VFType {
    // 예보버전조회
    VF_VERSION("http://apis.data.go.kr/1360000/VilageFcstInfoService/getFcstVersion", null),
    // 동네예보조회
    VF_SHRT("http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst", VFFileType.SHRT),
    // 초단기예보조회
    VF_VSRT("http://apis.data.go.kr/1360000/VilageFcstInfoService/getUltraSrtFcst", VFFileType.VSRT),
    // 초단기실황조회
    VF_ODAM("http://apis.data.go.kr/1360000/VilageFcstInfoService/getUltraSrtNcst", VFFileType.ODAM),
    ;

    private String requestUrl;
    private VFFileType fileType;

    VFType(String requestUrl, VFFileType fileType) {
        this.requestUrl = requestUrl;
        this.fileType = fileType;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public VFFileType getFileType() {
        return fileType;
    }
}
