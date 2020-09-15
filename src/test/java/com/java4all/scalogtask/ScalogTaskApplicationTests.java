package com.java4all.scalogtask;

import com.java4all.scalogtask.entity.HourMetric;
import com.java4all.scalogtask.entity.LogInfo;
import com.java4all.scalogtask.service.LogInfoService;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ScalogTaskApplicationTests {

    @Autowired
    private LogInfoService logInfoService;


    @Test
    void contextLoads() {
    }

    @Test
    void getAll(){
        List<LogInfo> all = logInfoService.getAll();
        Assertions.assertTrue(all.size() > 0);
    }
    
    @Test
    void testCountActiveUserAndRequestEveryHour(){
        List<HourMetric> hourMetrics = logInfoService.countActiveUserAndRequestEveryHour();
        Assertions.assertTrue(hourMetrics.size() > 0);
    }

    @Test
    void testCountActiveUserAndRequestEveryHourYesterday(){
        List<HourMetric> hourMetrics = logInfoService.countActiveUserAndRequestEveryHourYesterday();
        Assertions.assertTrue(hourMetrics.size() > 0);
    }

}
