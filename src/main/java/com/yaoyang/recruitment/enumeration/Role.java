package com.yaoyang.recruitment.enumeration;

/**
 * 数据状态
 *
 * @author yaoyang
 * @date 2018-01-24
 */
public enum Role {
    ADMIN("超级管理员"),
    WRITE("可操作"),
    READ("只读");

    private String name;

    Role(String _name) {
        this.name = _name;
    }
}