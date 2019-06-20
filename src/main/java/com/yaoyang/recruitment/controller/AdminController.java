package com.yaoyang.recruitment.controller;

import com.yaoyang.recruitment.base.ApiResult;
import com.yaoyang.recruitment.base.ApiResultBuilder;
import com.yaoyang.recruitment.dto.AdminDto;
import com.yaoyang.recruitment.enumeration.ResponseCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(tags = "管理员")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @PostMapping("/create")
    @ApiOperation(value = "创建管理员-后台")
    public ApiResult applyFinish(@RequestHeader("x-access-token") String token, @RequestBody AdminDto adminDto) {

        return ApiResultBuilder.buildSuccessResult(ResponseCode.OPT_SUCCESS);
    }
}
