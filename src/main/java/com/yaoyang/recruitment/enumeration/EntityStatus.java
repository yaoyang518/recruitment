package com.yaoyang.recruitment.enumeration;

/**
 * 数据状态
 *
 * @author yaoyang
 * @date 2018-01-24
 */
public enum EntityStatus {
    ENABLE,
    DISABLE,
    DELETE;

    public static EntityStatus getEnumByName(String name) {
        for (EntityStatus entityStatus : EntityStatus.values()) {
            if (entityStatus.name().equalsIgnoreCase(name)) {
                return entityStatus;
            }
        }
        return null;
    }
}