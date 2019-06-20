package com.yaoyang.recruitment.enumeration;

/**
 * 数据状态
 *
 * @author yaoyang
 * @date 2018-01-24
 */
public enum Sex {
    MALE("男"),
    FEMALE("女");

    private String name;

    Sex(String _name) {
        this.name = _name;
    }
}