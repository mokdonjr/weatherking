package com.example.weatherking.vfinfoschedule;

import com.example.weatherking.BaseBeanTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;

public class VFScheduleServiceTest extends BaseBeanTest {

    @Autowired
    private VFScheduleService vfScheduleService;

    @Test
    public void testSchedule() throws JSONException {
        vfScheduleService.scheduleAll();
    }
}