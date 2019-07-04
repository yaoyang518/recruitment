package com.yaoyang.recruitment.controller;

import com.yaoyang.recruitment.base.ApiResult;
import com.yaoyang.recruitment.base.ApiResultBuilder;
import com.yaoyang.recruitment.dto.ResumeDto;
import com.yaoyang.recruitment.entity.Resume;
import com.yaoyang.recruitment.enumeration.ResponseCode;
import com.yaoyang.recruitment.service.ResumeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "简历")
@RestController
@RequestMapping("/api/resume")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

    @PostMapping("/create")
    @ApiOperation(value = "创建简历-前段")
    public ApiResult creatResume(@RequestBody ResumeDto resumeDto) {
        Resume resume = new Resume();
        BeanUtils.copyProperties(resumeDto, resume);
        resumeService.save(resume);
        return ApiResultBuilder.buildSuccessResult(ResponseCode.OPT_SUCCESS);
    }
}
