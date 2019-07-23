package com.yaoyang.recruitment.service;

import com.yaoyang.recruitment.entity.Resource;

public interface ResourceService {

    Resource findById(Long id);

    Resource findByResumeId(Long resumeId);

    Resource save(Resource resource);

    Resource update(Resource resource);

    void delete(Resource resource);
}
