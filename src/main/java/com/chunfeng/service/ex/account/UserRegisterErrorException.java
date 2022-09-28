package com.chunfeng.service.ex.account;

import com.chunfeng.service.ServiceEnum;

/**
 * 用户注册异常
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class UserRegisterErrorException extends AccountException{
    public UserRegisterErrorException(ServiceEnum serviceEnum) {
        super(serviceEnum);
    }
}
