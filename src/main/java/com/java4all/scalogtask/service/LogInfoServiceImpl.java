package com.java4all.scalogtask.service;

import com.java4all.scalogtask.dao.LogInfoDao;
import com.java4all.scalogtask.entity.HourMetric;
import com.java4all.scalogtask.entity.LogInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangzhongxiang
 */
@Service
public class LogInfoServiceImpl implements LogInfoService{

    @Autowired
    private LogInfoDao logInfoDao;

    @Override
    public List<LogInfo> getAll() {
        return logInfoDao.getAll();
    }

    @Override
    public List<HourMetric> countActiveUserAndRequestEveryHour() {
        List<HourMetric> hourMetrics = logInfoDao.countActiveUserAndRequestEveryHour();
        return hourMetrics;
    }

    @Override
    public List<HourMetric> countActiveUserAndRequestEveryHourYesterday() {
        List<HourMetric> hourMetrics = logInfoDao.countActiveUserAndRequestEveryHourYesterday();
        return hourMetrics;
    }
}
