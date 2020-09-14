package com.java4all.scalogtask.service;

import com.java4all.scalogtask.dao.LogInfoDao;
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
}
