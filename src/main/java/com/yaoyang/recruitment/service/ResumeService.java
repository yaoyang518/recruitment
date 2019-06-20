package com.yaoyang.recruitment.service;

import com.yaoyang.recruitment.entity.Resume;

public interface ResumeService {

    Resume findById(Long id);

    Resume save(Resume resume);

    Resume update(Resume resume);

    void delete(Resume resume);
}
