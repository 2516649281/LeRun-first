package com.chunfeng.controller;

import com.chunfeng.dao.entity.Json;
import com.chunfeng.service.ServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 业务层异常捕获类
 *
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class ServiceController {

    /**
     * 全局异常捕获
     *
     * @param serviceException 业务层异常
     * @return JSON
     */
    @ExceptionHandler
    public Json<Void> getException(ServiceException serviceException) {
        return new Json<>(serviceException.serviceEnum.getStatus(), serviceException.getMessage());
    }
}
