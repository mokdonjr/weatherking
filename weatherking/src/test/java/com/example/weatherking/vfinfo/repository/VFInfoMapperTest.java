package com.example.weatherking.vfinfo.repository;

import com.example.weatherking.BaseBeanTest;
import com.example.weatherking.util.DateUtil;
import com.example.weatherking.vfinfo.odam.VFCategoryOdam;
import com.example.weatherking.vfinfo.odam.VFDataOdam;
import com.example.weatherking.vfinfo.shrt.VFCategoryShrt;
import com.example.weatherking.vfinfo.shrt.VFDataShrt;
import com.example.weatherking.vfinfo.vsrt.VFCategoryVsrt;
import com.example.weatherking.vfinfo.vsrt.VFDataVsrt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class VFInfoMapperTest extends BaseBeanTest {

    @Autowired
    private VFInfoMapper vfInfoMapper;

    @Test
    public void testVFDataOdam() {

        // insert
        VFDataOdam vfDataOdam = new VFDataOdam();
        vfDataOdam.setNoticeTime(DateUtil.getCurrentDate().getTime());
        vfDataOdam.setNx(1);
        vfDataOdam.setNy(1);
        vfDataOdam.setCategory(VFCategoryOdam.PTY);
        vfDataOdam.setValue("INIT");
        vfDataOdam.setCreateAt(DateUtil.getCurrentDate());
        vfInfoMapper.insVFDataOdam(vfDataOdam);

        // select for update
        VFDataOdam selectForUpdate = vfInfoMapper.getVFDataOdamForUpdate(vfDataOdam.getNoticeTime(), vfDataOdam.getNx(), vfDataOdam.getNy(), vfDataOdam.getCategory());
        Assertions.assertNotNull(selectForUpdate);

        // update
        String expectedValue = "TEST";
        selectForUpdate.setValue(expectedValue);
        vfInfoMapper.updVFDataOdam(selectForUpdate);

        // select
        VFDataOdam select = vfInfoMapper.getVFDataOdam(vfDataOdam.getNoticeTime(), vfDataOdam.getNx(), vfDataOdam.getNy(), vfDataOdam.getCategory());
        Assertions.assertEquals(expectedValue, select.getValue());

        // delete
        vfInfoMapper.delVFDataOdam(vfDataOdam.getNoticeTime(), vfDataOdam.getNx(), vfDataOdam.getNy(), vfDataOdam.getCategory());
        Assertions.assertNull(vfInfoMapper.getVFDataOdam(vfDataOdam.getNoticeTime(), vfDataOdam.getNx(), vfDataOdam.getNy(), vfDataOdam.getCategory()));
    }

    @Test
    public void testVFDataVsrt() {

        // insert
        VFDataVsrt vfDataVsrt = new VFDataVsrt();
        vfDataVsrt.setNoticeTime(DateUtil.getCurrentDate().getTime());
        vfDataVsrt.setForecastTime(DateUtil.getCurrentDate().getTime());
        vfDataVsrt.setNx(1);
        vfDataVsrt.setNy(1);
        vfDataVsrt.setCategory(VFCategoryVsrt.PTY);
        vfDataVsrt.setValue("INIT");
        vfDataVsrt.setCreateAt(DateUtil.getCurrentDate());
        vfInfoMapper.insVFDataVsrt(vfDataVsrt);

        // select for update
        VFDataVsrt selectForUpdate = vfInfoMapper.getVFDataVsrtForUpdate(vfDataVsrt.getNoticeTime(), vfDataVsrt.getForecastTime(), vfDataVsrt.getNx(), vfDataVsrt.getNy(), vfDataVsrt.getCategory());
        Assertions.assertNotNull(selectForUpdate);

        // update
        String expectedValue = "TEST";
        selectForUpdate.setValue(expectedValue);
        vfInfoMapper.updVFDataVsrt(selectForUpdate);

        // select
        VFDataVsrt select = vfInfoMapper.getVFDataVsrt(vfDataVsrt.getNoticeTime(), vfDataVsrt.getForecastTime(), vfDataVsrt.getNx(), vfDataVsrt.getNy(), vfDataVsrt.getCategory());
        Assertions.assertEquals(expectedValue, select.getValue());

        // delete
        vfInfoMapper.delVFDataVsrt(vfDataVsrt.getNoticeTime(), vfDataVsrt.getForecastTime(), vfDataVsrt.getNx(), vfDataVsrt.getNy(), vfDataVsrt.getCategory());
        Assertions.assertNull(vfInfoMapper.getVFDataVsrt(vfDataVsrt.getNoticeTime(), vfDataVsrt.getForecastTime(), vfDataVsrt.getNx(), vfDataVsrt.getNy(), vfDataVsrt.getCategory()));
    }

    @Test
    public void testVFDataShrt() {

        // insert
        VFDataShrt vfDataShrt = new VFDataShrt();
        vfDataShrt.setNoticeTime(DateUtil.getCurrentDate().getTime());
        vfDataShrt.setForecastTime(DateUtil.getCurrentDate().getTime());
        vfDataShrt.setNx(1);
        vfDataShrt.setNy(1);
        vfDataShrt.setCategory(VFCategoryShrt.POP);
        vfDataShrt.setValue("INIT");
        vfDataShrt.setCreateAt(DateUtil.getCurrentDate());
        vfInfoMapper.insVFDataShrt(vfDataShrt);

        // select for update
        VFDataShrt selectForUpdate = vfInfoMapper.getVFDataShrtForUpdate(vfDataShrt.getNoticeTime(), vfDataShrt.getForecastTime(), vfDataShrt.getNx(), vfDataShrt.getNy(), vfDataShrt.getCategory());
        Assertions.assertNotNull(selectForUpdate);

        // update
        String expectedValue = "TEST";
        selectForUpdate.setValue(expectedValue);
        vfInfoMapper.updVFDataShrt(selectForUpdate);

        // select
        VFDataShrt select = vfInfoMapper.getVFDataShrt(vfDataShrt.getNoticeTime(), vfDataShrt.getForecastTime(), vfDataShrt.getNx(), vfDataShrt.getNy(), vfDataShrt.getCategory());
        Assertions.assertEquals(expectedValue, select.getValue());

        // delete
        vfInfoMapper.delVFDataShrt(vfDataShrt.getNoticeTime(), vfDataShrt.getForecastTime(), vfDataShrt.getNx(), vfDataShrt.getNy(), vfDataShrt.getCategory());
        Assertions.assertNull(vfInfoMapper.getVFDataShrt(vfDataShrt.getNoticeTime(), vfDataShrt.getForecastTime(), vfDataShrt.getNx(), vfDataShrt.getNy(), vfDataShrt.getCategory()));
    }
}