package com.yaoyang.recruitment.repository;

import com.yaoyang.recruitment.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ResumeRepository extends JpaRepository<Resume, Long>,JpaSpecificationExecutor<Resume> {}
