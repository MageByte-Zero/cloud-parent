package com.zero.common.constant;

/**
 * @author jianqing.li
 * @date 2018/6/7
 */
public enum HandlerTaskType {
    ORDER("order", "订单创建");
    private String jobType;
    private String description;

    HandlerTaskType(String jobType, String description) {
        this.jobType = jobType;
        this.description = description;
    }

    public String getJobType() {
        return jobType;
    }
}
