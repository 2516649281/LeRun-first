package com.chunfeng.service.ex.account;

import com.chunfeng.service.ServiceEnum;

/**
 * 用户登录异常
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class UserLoginErrorException extends AccountException{
    public UserLoginErrorException(ServiceEnum serviceEnum) {
        super(serviceEnum);
    }
}
