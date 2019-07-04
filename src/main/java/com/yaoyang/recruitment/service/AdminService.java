package com.yaoyang.recruitment.service;

import com.yaoyang.recruitment.entity.Admin;
import com.yaoyang.recruitment.enumeration.Role;
import org.springframework.data.domain.Page;

public interface AdminService {

    Admin findById(Long id);

    Admin save(Admin admin);

    Admin update(Admin admin);

    void delete(Admin admin);

    Admin findAdminByLoginNameAndPassword(String loginName, String password);

    Page<Admin> findAdminByRole(Role role, int page, int size);


}
