package com.java4all.scalogtask.service;

import com.java4all.scalogtask.entity.HourMetric;
import com.java4all.scalogtask.entity.LogInfo;
import java.util.List;

/**
 * @author wangzhongxiang
 */
public interface LogInfoService {

    List<LogInfo> getAll();

    /**
     * 统计历史数据进入hour_metric
     * @param projectNames 项目名称，以英文逗号分隔： eg: middle_user,middle_message,middle_credit
     *                     项目名称对应scalog.projectName的值
     */
    void countActiveUserAndRequestEveryHour(String projectNames);
    List<HourMetric> countActiveUserAndRequestEveryHourYesterday();

}
