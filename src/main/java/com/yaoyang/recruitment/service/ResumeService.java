package com.yaoyang.recruitment.service;

import com.yaoyang.recruitment.entity.Resume;
import org.springframework.data.domain.Page;

public interface ResumeService {

    Resume findById(Long id);

    Resume save(Resume resume);

    Resume update(Resume resume);

    void delete(Resume resume);

    Page<Resume> findAll(int page,int size);
}
