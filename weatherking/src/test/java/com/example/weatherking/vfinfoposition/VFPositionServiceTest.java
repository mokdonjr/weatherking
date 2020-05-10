package com.example.weatherking.vfinfoposition;

import com.example.weatherking.BaseBeanTest;
import com.example.weatherking.vfinfo.common.config.VFConfig;
import com.example.weatherking.vfinfoposition.VFPositionService.LatXLngY;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class VFPositionServiceTest extends BaseBeanTest {

    @Autowired
    private VFPositionService vfPositionService;

    /**
     * 위경도 <-> 기상청 격자 변환 테스트
     */
    @Test
    public void testConvertGPSWithGRID() {
        logger.info("[1] {}", vfPositionService.convertGPS_GRID(37.579871128849334, 126.98935225645432));
        logger.info("[2] {}", vfPositionService.convertGPS_GRID(35.101148844565955, 129.02478725562108));
        logger.info("[3] {}", vfPositionService.convertGPS_GRID(33.500946412305076, 126.54663058817043));

        LatXLngY before = vfPositionService.convertGRID_GPS(VFConfig.NX_DEFAULT_VALUE, VFConfig.NY_DEFAULT_VALUE);
        logger.info("[BEFORE] {}", before);
        LatXLngY after = vfPositionService.convertGPS_GRID(before.lat, before.lng);
        logger.info("[AFTER] {}", after);
        Assertions.assertAll(
                () -> Assertions.assertEquals(VFConfig.NX_DEFAULT_VALUE, before.x),
                () -> Assertions.assertEquals(VFConfig.NY_DEFAULT_VALUE, before.y),
                () -> Assertions.assertEquals(VFConfig.NX_DEFAULT_VALUE, after.x),
                () -> Assertions.assertEquals(VFConfig.NY_DEFAULT_VALUE, after.y),
                () -> Assertions.assertEquals(before, after)
        );
    }

}