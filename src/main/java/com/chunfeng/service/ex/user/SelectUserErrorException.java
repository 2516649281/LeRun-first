package com.chunfeng.service.ex.user;

import com.chunfeng.service.ServiceEnum;

/**
 * 查询用户出现问题
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class SelectUserErrorException extends UserException {
    public SelectUserErrorException(ServiceEnum serviceEnum) {
        super(serviceEnum);
    }
}
