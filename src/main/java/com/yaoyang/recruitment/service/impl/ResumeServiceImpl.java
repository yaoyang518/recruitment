package com.yaoyang.recruitment.service.impl;

import com.yaoyang.recruitment.enumeration.EntityStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.yaoyang.recruitment.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import com.yaoyang.recruitment.repository.ResumeRepository;
import com.yaoyang.recruitment.entity.Resume;

import java.util.Optional;
import java.util.Date;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    @Override
    public Resume findById(Long id) {
        Optional<Resume> optional = resumeRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public Resume save(Resume resume) {
        return resumeRepository.saveAndFlush(resume);
    }

    @Override
    public Resume update(Resume resume) {
        resume.setUpdateDate(new Date());
        return resumeRepository.saveAndFlush(resume);
    }

    @Override
    public void delete(Resume resume) {
        resume.setUpdateDate(new Date());
        resume.setEntityStatus(EntityStatus.DELETE);
        resumeRepository.saveAndFlush(resume);
    }

    @Override
    public Page<Resume> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return resumeRepository.findAll(pageable);
    }
}
