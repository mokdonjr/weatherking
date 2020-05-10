package com.example.weatherking.vfinfo.shrt;

import com.example.weatherking.vfinfo.common.data.response.VFCategory;

/**
 * 기상청 동네예보조회 응답 카테고리
 * 'POP', 'PTY', 'R06', 'REH', 'S06', 'SKY', 'T3H', 'TMN', 'TMX', 'UUU', 'VVV', 'WAV', 'VEC', 'WSD'
 */
public enum VFCategoryShrt implements VFCategory {
    POP("강수확률", "%", 8),
    PTY("강수형태", "코드값", 4),
    R06("6시간 강수량", "범주 (1 mm)", 8),
    REH("습도", "%", 8),
    S06("6시간 신적설", "범주(1 cm)", 8),
    SKY("하늘상태", "코드값", 4),
    T3H("3시간 기온", "℃", 10),
    TMN("아침 최저기온", "℃", 10),
    TMX("낮 최고기온", "℃", 10),
    UUU("풍속(동서성분)", "m/s", 12),
    VVV("풍속(남북성분)", "m/s", 12),
    WAV("파고", "M", 8),
    VEC("풍향", "m/s", 10),
    WSD("풍속", "1", 10),
    ;

    // 항목명
    private String name;
    // 단위
    private String unit;
    // 압축 bit 수
    private int bitNum;

    VFCategoryShrt(String name, String unit, int bitNum) {
        this.name = name;
        this.unit = unit;
        this.bitNum = bitNum;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public int getBitNum() {
        return bitNum;
    }
}
