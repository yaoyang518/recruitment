package com.yaoyang.recruitment.controller;

import ch.ethz.ssh2.Connection;
import com.yaoyang.recruitment.annotation.FilterRequest;
import com.yaoyang.recruitment.base.ApiResult;
import com.yaoyang.recruitment.base.ApiResultBuilder;
import com.yaoyang.recruitment.enumeration.ResponseCode;
import com.yaoyang.recruitment.util.CtrCommondUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "系统")
@RestController
@RequestMapping("/api/admin")
public class SysController {


    @FilterRequest(role = "ADMIN")
    @PostMapping("/deploy")
    @ApiOperation(value = "重启系统-后台")
    public ApiResult deploy() {
        Connection connection = CtrCommondUtil.getConn("101.36.153.228", "root", 22, "yhDN489KiZ");
        CtrCommondUtil.doCommond(connection,"/root/deploy.sh");
        return ApiResultBuilder.buildSuccessResult(ResponseCode.OPT_SUCCESS);
    }
}
