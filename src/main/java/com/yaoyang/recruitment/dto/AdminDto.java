package com.yaoyang.recruitment.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 管理员
 *
 * @author yaoyang
 * @date 2018-01-25
 */
@Data
@ApiModel(value = "管理员")
public class AdminDto{

    @ApiModelProperty(value = "管理员昵称")
    private String nickName;
    @ApiModelProperty(value = "登录名")
    @NotBlank(message = "登录名不能为空")
    private String loginName;
    @ApiModelProperty(value = "登录密码")
    @NotBlank(message = "密码不能为空")
    private String password;
    @ApiModelProperty(value = "描述")
    private String description;

}
