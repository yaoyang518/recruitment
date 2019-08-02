package com.yaoyang.recruitment.dto;


import com.yaoyang.recruitment.enumeration.ApplyType;
import com.yaoyang.recruitment.enumeration.Education;
import com.yaoyang.recruitment.enumeration.MessageSource;
import com.yaoyang.recruitment.enumeration.Sex;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 简历
 *
 * @author yaoyang
 * @date 2018-01-25
 */
@Data
@ApiModel(value = "简历")
public class ResumeDto {

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "姓名")
    @NotBlank(message = "姓名不能为空")
    private String name;
    @ApiModelProperty(value = "性别")
    private Sex sex;
    @ApiModelProperty(value = "年龄")
    private int age;
    @ApiModelProperty(value = "手机号码")
    private String mobile;
    @ApiModelProperty(value = "第一学历")
    private Education firstEducation;
    @ApiModelProperty(value = "最高学历")
    private Education highEducation;
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
    @ApiModelProperty(value = "招聘信息来源")
    private MessageSource messageSource;
    @ApiModelProperty(value = "应聘方式")
    private ApplyType applyType;
    @ApiModelProperty(value = "推荐人")
    private String referrer;
    @ApiModelProperty(value = "猎头")
    private String headhunter;

}
