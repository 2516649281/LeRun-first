package com.chunfeng.service.ex.account;

import com.chunfeng.service.ServiceEnum;

/**
 * 修改账号时遇到问题
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class UpdateAccountErrorException extends AccountException{
    public UpdateAccountErrorException(ServiceEnum serviceEnum) {
        super(serviceEnum);
    }
}
