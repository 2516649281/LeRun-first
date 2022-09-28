package com.chunfeng.service.ex.account;

import com.chunfeng.service.ServiceEnum;
import com.chunfeng.service.ServiceException;

/**
 * 账号业务层异常超类
 *
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class AccountException extends ServiceException {
    public AccountException(ServiceEnum serviceEnum) {
        super(serviceEnum);
    }
}
