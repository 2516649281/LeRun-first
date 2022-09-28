package com.chunfeng.service;

/**
 * 业务层异常超类
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class ServiceException extends RuntimeException {

    /**
     * 业务层异常枚举
     */
    public ServiceEnum serviceEnum;

    public ServiceException() {
        super();
    }

    public ServiceException(ServiceEnum serviceEnum) {
        super(serviceEnum.getMessage());
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(ServiceEnum serviceEnum, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(serviceEnum.getMessage(), cause, enableSuppression, writableStackTrace);
    }
}
