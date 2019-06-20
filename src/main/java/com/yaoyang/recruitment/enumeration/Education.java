package com.yaoyang.recruitment.enumeration;

/**
 * 数据状态
 *
 * @author yaoyang
 * @date 2018-01-24
 */
public enum Education {
    DOCTOR("博士"), MASTER("硕士"), BACHELOR("本科"), COLLEGE("专科"), HIGH_SCHOOL("高中"), MIDDLE_SCHOOL("初中"), PRIMARY_SCHOOL("小学"),;

    private String name;

    Education(String _name) {
        this.name = _name;
    }
}