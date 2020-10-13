package com.java4all.scalogtask.service;

import com.java4all.scalogtask.entity.LogInfo;
import java.util.List;

/**
 * @author wangzhongxiang
 */
public interface LogInfoService {

    /**
     * 获取所有的项目名称
     * @return
     */
    List<String> getProjectNames();

    /**
     * 测试接口
     * @return
     */
    List<LogInfo> getAll();

    /**
     * 统计历史数据进入hour_metric
     */
    void countActiveUserAndRequestEveryHour();

    /**
     * 统计前一天数据进入hour_metric
     */
    void countActiveUserAndRequestEveryHourYesterday();

}
