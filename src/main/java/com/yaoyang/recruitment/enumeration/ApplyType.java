package com.yaoyang.recruitment.enumeration;

/**
 * 数据状态
 *
 * @author yaoyang
 * @date 2018-01-24
 */
public enum ApplyType {
    INTERPOLATE("内推"), HEADHUNTING("猎头推荐"), SELF("自己应聘");

    private String name;

    ApplyType(String _name) {
        this.name = _name;
    }
}