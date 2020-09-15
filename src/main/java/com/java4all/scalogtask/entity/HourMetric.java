package com.java4all.scalogtask.entity;

import java.util.Date;
import lombok.Data;

/**
 * @author wangzhongxiang
 */
@Data
public class HourMetric {

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
    /**活跃用户数量*/
    private String activeUser;
    /**请求数量*/
    private String request;
    /**时间*/
    private Date time;
    private Integer year;
    private Integer month;
    private Integer day;
    private Integer hour;

    private Date gmtCreate;
    private Date gmtModified;


}
