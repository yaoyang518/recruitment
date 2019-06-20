package com.yaoyang.recruitment.service;

import com.yaoyang.recruitment.entity.OperationLog;

public interface OperationLogService {

    OperationLog findById(Long id);

    OperationLog save(OperationLog operationlog);

    OperationLog update(OperationLog operationlog);

    void delete(OperationLog operationlog);
}
