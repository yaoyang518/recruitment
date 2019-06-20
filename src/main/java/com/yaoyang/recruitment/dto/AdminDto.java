package com.yaoyang.recruitment.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yaoyang.recruitment.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Lob;

/**
 * 管理员
 *
 * @author yaoyang
 * @date 2018-01-25
 */
@Data
@ApiModel(value = "管理员")
public class AdminDto extends BaseEntity {

    @ApiModelProperty(value = "管理员昵称")
    private String nickName;
    @ApiModelProperty(value = "登录名")
    private String loginName;
    @ApiModelProperty(value = "登录密码")
    private String password;
    @ApiModelProperty(value = "描述")
    private String description;

}
