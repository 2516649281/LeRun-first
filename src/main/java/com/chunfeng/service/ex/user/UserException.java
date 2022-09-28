package com.chunfeng.service.ex.user;

import com.chunfeng.service.ServiceEnum;
import com.chunfeng.service.ServiceException;

/**
 * 用户业务层异常超类
 *
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class UserException extends ServiceException {
    public UserException(ServiceEnum serviceEnum) {
        super(serviceEnum);
    }
}
