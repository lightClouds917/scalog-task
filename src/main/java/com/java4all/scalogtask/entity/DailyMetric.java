package com.java4all.scalogtask.entity;

import lombok.Data;

/**
 * @author wangzhongxiang
 */
@Data
public class DailyMetric {
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
    /**日活跃用户数量*/
    private String DAU;
    /**日请求数量*/
    private String DR;
    /**时间*/
    private Integer year;
    private Integer month;
    private Integer day;
    private Integer hour;

}
