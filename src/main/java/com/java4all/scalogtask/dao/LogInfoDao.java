package com.java4all.scalogtask.dao;

import com.java4all.scalogtask.entity.HourMetric;
import com.java4all.scalogtask.entity.LogInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author wangzhongxiang
 */
@Repository
public interface LogInfoDao extends Mapper<LogInfo> {
    List<LogInfo>  getAll();

    List<HourMetric> countActiveUserAndRequestEveryHour(@Param("projectName") String projectName,@Param("day") Integer day);

    List<String> getProjectNames();
}
