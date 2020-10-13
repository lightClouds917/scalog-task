package com.java4all.scalogtask;

import com.java4all.scalogtask.dao.HourMetricDao;
import com.java4all.scalogtask.entity.HourMetric;
import com.java4all.scalogtask.entity.LogInfo;
import com.java4all.scalogtask.service.LogInfoService;
import com.java4all.scalogtask.util.SourceUtil;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ScalogTaskApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScalogTaskApplicationTests.class);


    @Autowired
    private LogInfoService logInfoService;
    @Autowired
    private HourMetricDao hourMetricDao;

    @Test
    void contextLoads() {
    }

    @Test
    void getAll(){
        List<LogInfo> all = logInfoService.getAll();
        Assertions.assertTrue(all.size() > 0);
    }

    /**
     * 统计历史数据
     */
    @Test
    void testCountActiveUserAndRequestEveryHour(){
        logInfoService.countActiveUserAndRequestEveryHour();
    }

    /**
     * 统计昨天数据
     */
    @Test
    void testCountActiveUserAndRequestEveryHourYesterday(){
        logInfoService.countActiveUserAndRequestEveryHourYesterday();
    }

    @Test
    void testInsert(){
        HourMetric hourMetric = new HourMetric();
        hourMetric.setId(SourceUtil.generateId());
        hourMetric.setCompanyName("兰亮");
        hourMetricDao.insert(hourMetric);
        LOGGER.info("服务[{}]{}统计数据已经生成：{}","金融项目",
                LocalDate.now().minusDays(1).toString(),hourMetric.toString());
    }
}
