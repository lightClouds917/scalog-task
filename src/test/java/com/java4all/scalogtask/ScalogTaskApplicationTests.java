package com.java4all.scalogtask;

import com.java4all.scalogtask.dao.HourMetricDao;
import com.java4all.scalogtask.entity.HourMetric;
import com.java4all.scalogtask.entity.LogInfo;
import com.java4all.scalogtask.service.LogInfoService;
import com.java4all.scalogtask.util.SourceUtil;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ScalogTaskApplicationTests {

    @Autowired
    private LogInfoService logInfoService;
    @Autowired
    private HourMetricDao hourMetricDao;

    private final String projectNames = "middleground-pro-message,middleground-pro-user,middleground-pro-approval,"
            + "middleground-pro-thirdpt,middleground-pro-common-service,middleground-pro-business-analysis";

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
        logInfoService.countActiveUserAndRequestEveryHour(projectNames);
    }

    @Test
    void testCountActiveUserAndRequestEveryHourYesterday(){
        logInfoService.countActiveUserAndRequestEveryHourYesterday(projectNames);
    }

    @Test
    void testInsert(){
        HourMetric hourMetric = new HourMetric();
        hourMetric.setId(SourceUtil.generateId());
        hourMetric.setCompanyName("兰亮");
        hourMetricDao.insert(hourMetric);
    }

}
