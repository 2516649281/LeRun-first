package com.chunfeng.service.ex.account;

import com.chunfeng.service.ServiceEnum;

/**
 * 添加账号时遇到错误
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class InsertAccountErrorException extends AccountException{
    public InsertAccountErrorException(ServiceEnum serviceEnum) {
        super(serviceEnum);
    }
}
