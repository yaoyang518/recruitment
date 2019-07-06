package com.yaoyang.recruitment.entity;


import com.yaoyang.recruitment.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

/**
 * 操作日志
 *
 * @author yaoyang
 * @date 2018-01-25
 */
@ApiModel(value = "操作日志")
@Entity
@Data
public class OperationLog extends BaseEntity {

    @ApiModelProperty(value = "操作人")
    @ManyToOne
    @JoinColumn(name = "adminId")
    private Admin admin;
    @Lob
    @Type(type = "text")
    @ApiModelProperty(value = "操作接口")
    private String context;

}
