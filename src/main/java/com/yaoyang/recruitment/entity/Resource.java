package com.yaoyang.recruitment.entity;


import com.yaoyang.recruitment.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;

/**
 * 资源
 *
 * @author yaoyang
 * @date 2019-07-03
 */
@ApiModel(value = "资源")
@Entity
@Data
public class Resource extends BaseEntity {

    @ApiModelProperty(value = "简历id")
    private Long resumeId;

    @ApiModelProperty(value = "资源路径")
    private String url;
}
