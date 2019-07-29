package com.yaoyang.recruitment.controller;

import com.yaoyang.recruitment.base.ApiResult;
import com.yaoyang.recruitment.base.ApiResultBuilder;
import com.yaoyang.recruitment.entity.Resource;
import com.yaoyang.recruitment.enumeration.ResponseCode;
import com.yaoyang.recruitment.service.ResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "资源")
@RestController
@RequestMapping("/api/resource")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    @GetMapping("/resource")
    @ApiOperation(value = "根据简历id找资源-前段")
    public ApiResult creatResume(Long resumeId) {
        Resource resource = resourceService.findByResumeId(resumeId);
        return ApiResultBuilder.buildSuccessResult(ResponseCode.OPT_SUCCESS, resource);
    }

}
