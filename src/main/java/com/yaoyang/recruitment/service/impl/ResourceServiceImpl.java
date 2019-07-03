package com.yaoyang.recruitment.service.impl;

import com.yaoyang.recruitment.entity.Resource;
import com.yaoyang.recruitment.enumeration.EntityStatus;
import com.yaoyang.recruitment.repository.ResourceRepository;
import com.yaoyang.recruitment.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public Resource findById(Long id) {
        Optional<Resource> optional = resourceRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public Resource save(Resource resource) {
        return resourceRepository.saveAndFlush(resource);
    }

    @Override
    public Resource update(Resource resource) {
        resource.setUpdateDate(new Date());
        return resourceRepository.saveAndFlush(resource);
    }

    @Override
    public void delete(Resource resource) {
        resource.setUpdateDate(new Date());
        resource.setEntityStatus(EntityStatus.DELETE);
        resourceRepository.saveAndFlush(resource);
    }
}
