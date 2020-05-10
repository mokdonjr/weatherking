package com.example.weatherking.vfinfo.repository;

import com.example.weatherking.vfinfo.odam.VFCategoryOdam;
import com.example.weatherking.vfinfo.odam.VFDataOdam;
import com.example.weatherking.vfinfo.shrt.VFCategoryShrt;
import com.example.weatherking.vfinfo.shrt.VFDataShrt;
import com.example.weatherking.vfinfo.vsrt.VFCategoryVsrt;
import com.example.weatherking.vfinfo.vsrt.VFDataVsrt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * 공공데이터 기상청 동네예보 api 매퍼
 */
@Mapper
public interface VFInfoMapper {

    /**
     * VF_ODAM
     * 초단기실황기록
     */
    VFDataOdam getVFDataOdam(@Param("noticeTime") Long noticeTime, @Param("nx") int nx, @Param("ny") int ny, @Param("category") VFCategoryOdam category);
    VFDataOdam getVFDataOdamForUpdate(@Param("noticeTime") Long noticeTime, @Param("nx") int nx, @Param("ny") int ny, @Param("category") VFCategoryOdam category);
    int insVFDataOdam(@Param("vfDataOdam") VFDataOdam vfDataOdam);
    int insupdVFDataOdam(@Param("vfDataOdam") VFDataOdam vfDataOdam);
    int updVFDataOdam(@Param("vfDataOdam") VFDataOdam vfDataOdam);
    int delVFDataOdam(@Param("noticeTime") Long noticeTime, @Param("nx") int nx, @Param("ny") int ny, @Param("category") VFCategoryOdam category);

    /**
     * VF_VSRT
     * 초단기예보기록
     */
    VFDataVsrt getVFDataVsrt(@Param("noticeTime") Long noticeTime, @Param("forecastTime") Long forecastTime, @Param("nx") int nx, @Param("ny") int ny, @Param("category") VFCategoryVsrt category);
    VFDataVsrt getVFDataVsrtForUpdate(@Param("noticeTime") Long noticeTime, @Param("forecastTime") Long forecastTime, @Param("nx") int nx, @Param("ny") int ny, @Param("category") VFCategoryVsrt category);
    int insVFDataVsrt(@Param("vfDataVsrt") VFDataVsrt vfDataVsrt);
    int insupdVFDataVsrt(@Param("vfDataVsrt") VFDataVsrt vfDataVsrt);
    int updVFDataVsrt(@Param("vfDataVsrt") VFDataVsrt vfDataVsrt);
    int delVFDataVsrt(@Param("noticeTime") Long noticeTime, @Param("forecastTime") Long forecastTime, @Param("nx") int nx, @Param("ny") int ny, @Param("category") VFCategoryVsrt category);

    /**
     * VF_SHRT
     * 동네예보기록
     */
    VFDataShrt getVFDataShrt(@Param("noticeTime") Long noticeTime, @Param("forecastTime") Long forecastTime, @Param("nx") int nx, @Param("ny") int ny, @Param("category") VFCategoryShrt category);
    VFDataShrt getVFDataShrtForUpdate(@Param("noticeTime") Long noticeTime, @Param("forecastTime") Long forecastTime, @Param("nx") int nx, @Param("ny") int ny, @Param("category") VFCategoryShrt category);
    int insVFDataShrt(@Param("vfDataShrt") VFDataShrt vfDataShrt);
    int insupdVFDataShrt(@Param("vfDataShrt") VFDataShrt vfDataShrt);
    int updVFDataShrt(@Param("vfDataShrt") VFDataShrt vfDataShrt);
    int delVFDataShrt(@Param("noticeTime") Long noticeTime, @Param("forecastTime") Long forecastTime, @Param("nx") int nx, @Param("ny") int ny, @Param("category") VFCategoryShrt category);

}
