package com.yaoyang.recruitment.controller;

import com.yaoyang.recruitment.annotation.FilterRequest;
import com.yaoyang.recruitment.base.ApiResult;
import com.yaoyang.recruitment.base.ApiResultBuilder;
import com.yaoyang.recruitment.constant.SiteConstants;
import com.yaoyang.recruitment.dto.AdminDto;
import com.yaoyang.recruitment.entity.Admin;
import com.yaoyang.recruitment.enumeration.ResponseCode;
import com.yaoyang.recruitment.service.AdminService;
import com.yaoyang.recruitment.util.Md5Util;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "管理员")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/login")
    @ApiOperation(value = "管理员登陆-后台")
    public ApiResult login(@Validated AdminDto adminDto) {
        String password = Md5Util.MD5(adminDto.getPassword());
        Admin admin = adminService.findAdminByLoginNameAndPassword(adminDto.getLoginName(), password);
        if (admin == null) {
            return ApiResultBuilder.buildFailedResult(ResponseCode.NO_ADMIN);
        }
        String token = Jwts.builder()
                .setSubject(adminDto.getLoginName())
                .signWith(SignatureAlgorithm.HS512, SiteConstants.TOKEN_KEY)
                .setExpiration(new DateTime().plusHours(8).toDate())
                .compact();
        admin.setToken(token);
        return ApiResultBuilder.buildSuccessResult(ResponseCode.OPT_SUCCESS, admin);
    }

    @FilterRequest(role = "WRITE")
    @PostMapping("/create")
    @ApiOperation(value = "创建管理员-后台")
    public ApiResult applyFinish(@RequestHeader("x-access-token") String token, @Validated @RequestBody AdminDto adminDto) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminDto, admin);
        adminService.save(admin);
        return ApiResultBuilder.buildSuccessResult(ResponseCode.OPT_SUCCESS);
    }

    @GetMapping("/list")
    @ApiOperation(value = "管理员列表-后台")
    public ApiResult list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        Page<Admin> admins = adminService.findAll(page, size);
        return ApiResultBuilder.buildSuccessResult(ResponseCode.OPT_SUCCESS, admins);
    }
}
