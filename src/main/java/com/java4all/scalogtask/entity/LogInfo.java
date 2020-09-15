package com.java4all.scalogtask.entity;

import lombok.Data;

/**
 * @author wangzhongxiang
 */
@Data
public class LogInfo {
    /**id*/
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
    /**模块名称*/
    private String moduleName;
    /**功能名称*/
    private String functionName;
    /**接口所在类名称*/
    private String className;
    /**方法名称*/
    private String methodName;
    /**方法类型*/
    private String methodType;
    /**接口url*/
    private String url;
    /**接口入参*/
    private String requestParams;
    /**接口返回值*/
    private String result;
    /**备注*/
    private String remark;
    /**接口耗时*/
    private Long cost;
    /**用户ip*/
    private String ip;
    /**用户id*/
    private String userId;
    /**用户名称*/
    private String userName;
    /**客户端类型*/
    private String clientType;
    /**客户端信息*/
    private String userAgent;
    /**此条操作状态：0 正常  1 异常'*/
    private Integer logType;
    /**操作开始时间*/
    private String gmtStart;
    /**操作结束时间*/
    private String gmtEnd;
    /**创建时间*/
    private String gmtCreate;
    /**修改时间*/
    private String gmtModified;
    /**错误信息*/
    private String errorMessage;
    /**错误堆栈*/
    private String errorStackTrace;

}
