package com.yaoyang.recruitment.service.impl;

import com.yaoyang.recruitment.enumeration.EntityStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.yaoyang.recruitment.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import com.yaoyang.recruitment.repository.OperationLogRepository;
import com.yaoyang.recruitment.entity.OperationLog;

import java.util.Optional;
import java.util.Date;

@Service
public class OperationLogServiceImpl implements OperationLogService {

    @Autowired
    private OperationLogRepository operationlogRepository;

    @Override
    public OperationLog findById(Long id) {
        Optional<OperationLog> optional = operationlogRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public OperationLog save(OperationLog operationlog) {
        return operationlogRepository.saveAndFlush(operationlog);
    }

    @Override
    public OperationLog update(OperationLog operationlog) {
        operationlog.setUpdateDate(new Date());
        return operationlogRepository.saveAndFlush(operationlog);
    }

    @Override
    public void delete(OperationLog operationlog) {
        operationlog.setUpdateDate(new Date());
        operationlog.setEntityStatus(EntityStatus.DELETE);
        operationlogRepository.saveAndFlush(operationlog);
    }

    @Override
    public Page<OperationLog> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return operationlogRepository.findAll(pageable);
    }
}
