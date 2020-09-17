package com.java4all.scalogtask.service.impl;

import com.java4all.scalogtask.dao.HourMetricDao;
import com.java4all.scalogtask.dao.LogInfoDao;
import com.java4all.scalogtask.entity.HourMetric;
import com.java4all.scalogtask.entity.LogInfo;
import com.java4all.scalogtask.service.LogInfoService;
import com.java4all.scalogtask.util.SourceUtil;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangzhongxiang
 */
@Service
public class LogInfoServiceImpl implements LogInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogInfoServiceImpl.class);

    @Autowired
    private LogInfoDao logInfoDao;
    @Autowired
    private HourMetricDao hourMetricDao;

    @Override
    public List<LogInfo> getAll() {
        return logInfoDao.getAll();
    }

    @Override
    public void countActiveUserAndRequestEveryHour(String projectNames) {
        String[] names = projectNames.split(",");
        Arrays.asList(names).parallelStream().forEach(name ->{
            Integer num = 1;
            while (true) {
                List<HourMetric> hourMetrics = logInfoDao.countActiveUserAndRequestEveryHour(name,num);
                if(hourMetrics.size() > 0){
                    hourMetrics.parallelStream().forEach(hourMetric -> {
                        hourMetric.setId(SourceUtil.generateId());
                        hourMetric.setGmtCreate(new Date());
                        hourMetric.setGmtModified(new Date());
                        hourMetricDao.insert(hourMetric);
                    });
                    num ++;
                } else {
                    break;
                }
            }
        });
    }

    @Override
    public void countActiveUserAndRequestEveryHourYesterday(String projectNames) {
        String[] names = projectNames.split(",");
        Arrays.asList(names).parallelStream().forEach(name->{
            LOGGER.info("scalog-task-----------开始统计 {}:{} 项目日志数据-------------", LocalDate.now().minusDays(1).toString(),name);
            List<HourMetric> hourMetrics = logInfoDao.countActiveUserAndRequestEveryHour(name,1);
            if(hourMetrics.size() > 0){
                hourMetrics.parallelStream().forEach(hourMetric -> {
                    hourMetric.setId(SourceUtil.generateId());
                    hourMetric.setGmtCreate(new Date());
                    hourMetric.setGmtModified(new Date());
                    hourMetricDao.insert(hourMetric);
                });
            }
            LOGGER.info("scalog-task----------- {}:{} 项目日志数据统计结束-------------", LocalDate.now().minusDays(1).toString(),name);
        });
    }
}
