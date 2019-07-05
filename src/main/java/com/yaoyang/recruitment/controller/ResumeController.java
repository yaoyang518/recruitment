package com.yaoyang.recruitment.controller;

import com.yaoyang.recruitment.annotation.FilterRequest;
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
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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

    @FilterRequest(role = "WRITE")
    @PostMapping("/list")
    @ApiOperation(value = "简历列表-后台")
    public ApiResult list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        Page<Resume> resumes = resumeService.findAll(page, size);
        return ApiResultBuilder.buildSuccessResult(ResponseCode.OPT_SUCCESS, resumes);
    }


}
