package com.java4all.scalogtask.service;

import com.java4all.scalogtask.entity.HourMetric;
import com.java4all.scalogtask.entity.LogInfo;
import java.util.List;

/**
 * @author wangzhongxiang
 */
public interface LogInfoService {

    List<LogInfo> getAll();

    List<HourMetric> countActiveUserAndRequestEveryHour();
    List<HourMetric> countActiveUserAndRequestEveryHourYesterday();

}
