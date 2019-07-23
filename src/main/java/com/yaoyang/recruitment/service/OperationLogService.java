package com.yaoyang.recruitment.service;

import com.yaoyang.recruitment.entity.OperationLog;
import org.springframework.data.domain.Page;

public interface OperationLogService {

    OperationLog findById(Long id);

    OperationLog save(OperationLog operationlog);

    OperationLog update(OperationLog operationlog);

    void delete(OperationLog operationlog);

    Page<OperationLog> findAll(int page, int size);
}
