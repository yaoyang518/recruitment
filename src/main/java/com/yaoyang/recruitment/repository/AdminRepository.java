package com.yaoyang.recruitment.repository;

import com.yaoyang.recruitment.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AdminRepository extends JpaRepository<Admin, Long>,JpaSpecificationExecutor<Admin> {}
