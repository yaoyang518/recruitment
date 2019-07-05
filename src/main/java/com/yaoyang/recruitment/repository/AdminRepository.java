package com.yaoyang.recruitment.repository;

import com.yaoyang.recruitment.entity.Admin;
import com.yaoyang.recruitment.enumeration.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AdminRepository extends JpaRepository<Admin, Long>, JpaSpecificationExecutor<Admin> {

    Page<Admin> findAdminByRole(Role role, Pageable pageable);

    Admin findByLoginName(String loginName);

    Admin findAdminByLoginNameAndPassword(String loginName, String password);
}
