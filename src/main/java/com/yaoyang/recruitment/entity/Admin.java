package com.yaoyang.recruitment.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yaoyang.recruitment.base.BaseEntity;
import com.yaoyang.recruitment.enumeration.Role;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;

/**
 * 管理员
 *
 * @author yaoyang
 * @date 2018-01-25
 */
@ApiModel(value = "管理员")
@Entity
@Data
public class Admin extends BaseEntity {

    @ApiModelProperty(value = "管理员昵称")
    private String nickName;
    @ApiModelProperty(value = "登录名")
    private String loginName;
    @Lob
    @Type(type = "text")
    @ApiModelProperty(value = "登录密码")
    private String password;
    @ApiModelProperty(value = "角色")
    @Enumerated(EnumType.STRING)
    private Role role;
    @Type(type = "text")
    private String description;
    @ApiModelProperty(value = "头像路径")
    @Type(type = "text")
    private String image;
    @ApiModelProperty(value = "通行令牌")
    @Type(type = "text")
    @JsonIgnore
    private String token;

}
