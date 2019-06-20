package com.yaoyang.recruitment.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yaoyang.recruitment.base.BaseEntity;
import com.yaoyang.recruitment.enumeration.Education;
import com.yaoyang.recruitment.enumeration.Sex;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import java.util.Date;

/**
 * 管理员
 *
 * @author yaoyang
 * @date 2018-01-25
 */
@ApiModel(value = "简历")
@Entity
@Data
public class Resume extends BaseEntity {

    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "性别")
    @Enumerated(EnumType.STRING)
    private Sex sex = Sex.MALE;
    @ApiModelProperty(value = "年龄")
    private int age;
    @ApiModelProperty(value = "手机号码")
    private String mobile;
    @ApiModelProperty(value = "第一学历")
    @Enumerated(EnumType.STRING)
    private Education firstEducation = Education.BACHELOR;
    @ApiModelProperty(value = "最高学历")
    @Enumerated(EnumType.STRING)
    private Education highEducation = Education.BACHELOR;
    @ApiModelProperty(value = "毕业时间")
    private Date graduateDate;
    @ApiModelProperty(value = "专业")
    private String courses;
    @ApiModelProperty(value = "全日制")
    private boolean fullTime;
    @ApiModelProperty(value = "当前所在地")
    private String currentAddress;
    @ApiModelProperty(value = "期望工作地")
    private String hopeAddress;

    @ApiModelProperty(value = "当前工作单位")
    private String company;
    @ApiModelProperty(value = "当前职位")
    private String position;
    @ApiModelProperty(value = "岗位类型")
    private String jobType;
    @ApiModelProperty(value = "工作年限")
    private String workHours;
    @ApiModelProperty(value = "目前薪资")
    private String currentSalary;
    @ApiModelProperty(value = "期望薪资")
    private String hopeSalary;
    @ApiModelProperty(value = "应聘岗位")
    private String applyJob;
}
