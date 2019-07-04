package com.yaoyang.recruitment.service.impl;

import com.yaoyang.recruitment.enumeration.EntityStatus;
import com.yaoyang.recruitment.enumeration.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.yaoyang.recruitment.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import com.yaoyang.recruitment.repository.AdminRepository;
import com.yaoyang.recruitment.entity.Admin;

import java.util.Optional;
import java.util.Date;

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
        return findAdminByLoginNameAndPassword(loginName, password);
    }

    @Override
    public Page<Admin> findAdminByRole(Role role, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return adminRepository.findAdminByRole(role, pageable);
    }
}
