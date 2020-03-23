package com.yaoyang.recruitment.entity;


import com.yaoyang.recruitment.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;

/**
 * 用户
 *
 * @author yaoyang
 * @date 2020-03-23
 */
@ApiModel(value = "用户")
@Entity
@Data
public class User extends BaseEntity {

    @ApiModelProperty(value = "登录名")
    private String loginName;
    @ApiModelProperty(value = "登录密码")
    private String password;
    @Type(type = "text")
    @ApiModelProperty(value = "描述")
    private String description;
    @ApiModelProperty(value = "头像路径")
    private String image;
    @ApiModelProperty(value = "通行令牌")
    @Type(type = "text")
    private String token;

}
