package com.java4all.scalogtask.entity;

import java.util.Date;
import lombok.Data;

/**
 * @author wangzhongxiang
 */
@Data
public class HourMetric {

    private String id;

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
    private Integer activeUser;
    /**请求数量*/
    private Integer request;
    /**时间*/
    private Date createTime;

    private Date gmtCreate;
    private Date gmtModified;


}
