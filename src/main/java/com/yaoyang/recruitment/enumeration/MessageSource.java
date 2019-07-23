package com.yaoyang.recruitment.enumeration;

/**
 * 数据状态
 *
 * @author yaoyang
 * @date 2018-01-24
 */
public enum MessageSource {
    WEB("网络"), INNER("内部员工"),
    ;

    private String name;

    MessageSource(String _name) {
        this.name = _name;
    }
}