package com.yaoyang.recruitment.controller;

import com.yaoyang.recruitment.base.ApiResult;
import com.yaoyang.recruitment.base.ApiResultBuilder;
import com.yaoyang.recruitment.constant.SiteConstants;
import com.yaoyang.recruitment.entity.User;
import com.yaoyang.recruitment.enumeration.ResponseCode;
import com.yaoyang.recruitment.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    @ApiOperation(value = "用户登陆-前端")
    public ApiResult login(String loginName,String password) {
        User user = userService.findByLoginNameAndPassword(loginName,password);
        if (user == null) {
            return ApiResultBuilder.buildFailedResult(ResponseCode.NO_USER);
        }
        String token = Jwts.builder()
                .setSubject(loginName)
                .signWith(SignatureAlgorithm.HS512, SiteConstants.TOKEN_KEY)
                .setExpiration(new DateTime().plusHours(8).toDate())
                .compact();
        user.setToken(token);
        return ApiResultBuilder.buildSuccessResult(ResponseCode.OPT_SUCCESS, user);
    }
}
