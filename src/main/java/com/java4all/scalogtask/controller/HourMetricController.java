package com.java4all.scalogtask.controller;

import com.java4all.scalogtask.entity.LogInfo;
import com.java4all.scalogtask.service.LogInfoService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangzhongxiang
 */
@RestController
@RequestMapping("hourMetric")
public class HourMetricController {
    @Autowired
    private LogInfoService logInfoService;

    @GetMapping("test")
    public String test(String v){
        return v + LocalDateTime.now().toString();
    }

    /**
     * 测试接口
     * @param v
     * @return
     */
    @GetMapping("getAll")
    public List<LogInfo> getAll(String v){
        System.out.println(v);
        List<LogInfo> all = logInfoService.getAll();
        return all;
    }

    /**
     * 获取所有的项目名称
     * @return
     */
    @GetMapping("getProjectNames")
    public List<String> getProjectNames(){
        return logInfoService.getProjectNames();
    }

    /**
     * 统计历史数据进入hour_metric
     */
    @GetMapping("countActiveUserAndRequestEveryHour")
    public void countActiveUserAndRequestEveryHour(){
        logInfoService.countActiveUserAndRequestEveryHour();
    }

    /**
     * 统计前一天数据进入hour_metric
     */
    @GetMapping("countActiveUserAndRequestEveryHourYesterday")
    public void countActiveUserAndRequestEveryHourYesterday(){
        logInfoService.countActiveUserAndRequestEveryHourYesterday();
    }
}
