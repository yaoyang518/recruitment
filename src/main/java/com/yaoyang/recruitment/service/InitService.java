package com.yaoyang.recruitment.service;

import com.yaoyang.recruitment.constant.SiteConstants;
import com.yaoyang.recruitment.entity.Admin;
import com.yaoyang.recruitment.enumeration.Role;
import com.yaoyang.recruitment.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitService {

    @Autowired
    private AdminService adminService;

    @PostConstruct
    public void init() {
        initAdmin();
    }

    private void initAdmin() {
        Page<Admin> admins = adminService.findAdminByRole(Role.ADMIN,1,100);
        if(admins.isEmpty()){
            Admin admin = new Admin();
            admin.setLoginName(SiteConstants.ADMIN_NAME);
            admin.setPassword(Md5Util.MD5(SiteConstants.ADMIN_PASSWORD));
            admin.setRole(Role.ADMIN);
            adminService.save(admin);
        }
    }
}
