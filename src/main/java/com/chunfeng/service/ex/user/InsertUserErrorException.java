package com.chunfeng.service.ex.user;

import com.chunfeng.service.ServiceEnum;

/**
 * 添加用户时遇到错误
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class InsertUserErrorException extends UserException {
    public InsertUserErrorException(ServiceEnum serviceEnum) {
        super(serviceEnum);
    }
}
