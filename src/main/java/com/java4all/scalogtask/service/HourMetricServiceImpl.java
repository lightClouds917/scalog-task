package com.java4all.scalogtask.service;

import com.java4all.scalogtask.dao.HourMetricDao;
import com.java4all.scalogtask.entity.HourMetric;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangzhongxiang
 */
@Service
public class HourMetricServiceImpl implements HourMetricService{

    @Autowired
    private HourMetricDao hourMetricDao;

    @Override
    public void insert(List<HourMetric> list){
        list.parallelStream().forEach(hourMetric -> hourMetricDao.insert(hourMetric));
    }

}
