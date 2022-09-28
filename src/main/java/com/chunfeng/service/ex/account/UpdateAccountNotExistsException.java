package com.chunfeng.service.ex.account;

import com.chunfeng.service.ServiceEnum;

/**
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class UpdateAccountNotExistsException extends AccountException{
    public UpdateAccountNotExistsException(ServiceEnum serviceEnum) {
        super(serviceEnum);
    }
}
