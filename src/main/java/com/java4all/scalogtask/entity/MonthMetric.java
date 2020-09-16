package com.java4all.scalogtask.entity;

import lombok.Data;

/**
 * @author wangzhongxiang
 */
@Data
@Deprecated
public class MonthMetric {
    private Long id;

    /**国家*/
    private String countryName;
    /**集团*/
    private String groupName;
    /**组织*/
    private String organizationName;
    /**公司名称*/
    private String companyName;
    /**项目名称*/
    private String projectName;
    /**月活跃用户数量*/
    private String MAU;
    /**月请求数量*/
    private String MR;
    /**时间 eg:2020-02*/
    private String  time;
}
