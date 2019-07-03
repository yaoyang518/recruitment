package com.yaoyang.recruitment.service;

import com.yaoyang.recruitment.entity.Resource;
import com.yaoyang.recruitment.entity.Resume;

public interface ResourceService {

    Resource findById(Long id);

    Resource save(Resource resource);

    Resource update(Resource resource);

    void delete(Resource resource);
}
