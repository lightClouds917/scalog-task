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

    @GetMapping("getAll")
    public List<LogInfo> getAll(String v){
        System.out.println(v);
        List<LogInfo> all = logInfoService.getAll();
        return all;
    }

}
