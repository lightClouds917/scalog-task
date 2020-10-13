package com.java4all.scalogtask.service.impl;

import com.java4all.scalogtask.dao.HourMetricDao;
import com.java4all.scalogtask.dao.LogInfoDao;
import com.java4all.scalogtask.entity.HourMetric;
import com.java4all.scalogtask.entity.LogInfo;
import com.java4all.scalogtask.service.LogInfoService;
import com.java4all.scalogtask.util.SourceUtil;
import java.time.LocalDate;
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

    /**
     * 获取所有的项目名称
     */
    @Override
    public List<String> getProjectNames() {
        List<String> names = logInfoDao.getProjectNames();
        return names;
    }

    @Override
    public List<LogInfo> getAll() {
        return logInfoDao.getAll();
    }

    @Override
    public void countActiveUserAndRequestEveryHour() {
        List<String> names = this.getProjectNames();
        names.parallelStream().forEach(name ->{
            LOGGER.info("【scalog-task】开始统计 {} 项目日志数据",name);
            Integer num = 1;
            while (true) {
                List<HourMetric> hourMetrics = logInfoDao.countActiveUserAndRequestEveryHour(name,num);
                if(hourMetrics.size() > 0){
                    hourMetrics.parallelStream().forEach(hourMetric -> {
                        hourMetric.setId(SourceUtil.generateId());
                        hourMetric.setGmtCreate(new Date());
                        hourMetric.setGmtModified(new Date());
                        LOGGER.info("服务[{}]{}统计数据已经生成",name,hourMetric.getCreateTime().toString());
                        hourMetricDao.insert(hourMetric);
                    });
                }
                num++;
                //最多向前统计30天
                if(num > 30){
                    break;
                }
            }
        });
        LOGGER.info("历史数据统计结束");
    }

    @Override
    public void countActiveUserAndRequestEveryHourYesterday() {
        List<String> names = this.getProjectNames();
        names.parallelStream().forEach(name->{
            LOGGER.info("【scalog-task】开始统计 {} 项目 {} 日志数据",name,LocalDate.now().minusDays(1));
            List<HourMetric> hourMetrics = logInfoDao.countActiveUserAndRequestEveryHour(name,1);
            if(hourMetrics.size() > 0){
                hourMetrics.parallelStream().forEach(hourMetric -> {
                    hourMetric.setId(SourceUtil.generateId());
                    hourMetric.setGmtCreate(new Date());
                    hourMetric.setGmtModified(new Date());
                    LOGGER.info("服务[{}]{}统计数据已经生成 ",name,hourMetric.getCreateTime().toString());
                    hourMetricDao.insert(hourMetric);
                });
            }
        });
        LOGGER.info("{} 数据统计结束",LocalDate.now().minusDays(1));
    }
}
