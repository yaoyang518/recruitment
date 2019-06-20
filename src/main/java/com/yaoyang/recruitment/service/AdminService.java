package com.yaoyang.recruitment.service;

import com.yaoyang.recruitment.entity.Admin;

public interface AdminService {

    Admin findById(Long id);

    Admin save(Admin admin);

    Admin update(Admin admin);

    void delete(Admin admin);
}
