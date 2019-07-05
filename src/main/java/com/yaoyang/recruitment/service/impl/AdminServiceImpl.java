package com.yaoyang.recruitment.service.impl;

import com.yaoyang.recruitment.base.ApiResult;
import com.yaoyang.recruitment.base.ApiResultBuilder;
import com.yaoyang.recruitment.constant.SiteConstants;
import com.yaoyang.recruitment.entity.Admin;
import com.yaoyang.recruitment.enumeration.EntityStatus;
import com.yaoyang.recruitment.enumeration.ResponseCode;
import com.yaoyang.recruitment.enumeration.Role;
import com.yaoyang.recruitment.repository.AdminRepository;
import com.yaoyang.recruitment.service.AdminService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin findById(Long id) {
        Optional<Admin> optional = adminRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public Admin findByLoginName(String loginName) {
        return adminRepository.findByLoginName(loginName);
    }

    @Override
    public Admin save(Admin admin) {
        return adminRepository.saveAndFlush(admin);
    }

    @Override
    public Admin update(Admin admin) {
        admin.setUpdateDate(new Date());
        return adminRepository.saveAndFlush(admin);
    }

    @Override
    public void delete(Admin admin) {
        admin.setUpdateDate(new Date());
        admin.setEntityStatus(EntityStatus.DELETE);
        adminRepository.saveAndFlush(admin);
    }

    @Override
    public Admin findAdminByLoginNameAndPassword(String loginName, String password) {
        return adminRepository.findAdminByLoginNameAndPassword(loginName, password);
    }

    @Override
    public Page<Admin> findAdminByRole(Role role, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return adminRepository.findAdminByRole(role, pageable);
    }

    @Override
    public ApiResult validateToken(String token) {
        if (StringUtils.isEmpty(token)) {
            return ApiResultBuilder.buildFailedResult(ResponseCode.TOKEN_NULL);
        }
        Admin tokenAdmin = null;
        try {
            String loginName = Jwts.parser().setSigningKey(SiteConstants.TOKEN_KEY).parseClaimsJws(token).getBody().getSubject();
            if (StringUtils.isEmpty(loginName)) {
                return ApiResultBuilder.buildFailedResult(ResponseCode.LOGIN_EXPIRE);
            }
            tokenAdmin = findByLoginName(loginName);
        } catch (SignatureException e) {
            return ApiResultBuilder.buildFailedResult(ResponseCode.QUERY_FAIL, "无效令牌");
        } catch (ExpiredJwtException e) {
            return ApiResultBuilder.buildFailedResult(ResponseCode.QUERY_FAIL, "登录已过期");
        }
        if (tokenAdmin == null) {
            return ApiResultBuilder.buildFailedResult(ResponseCode.TOKEN_ERROR);
        }
        return ApiResultBuilder.buildSuccessResult(ResponseCode.QUERY_SUCCESS, tokenAdmin);
    }
}
