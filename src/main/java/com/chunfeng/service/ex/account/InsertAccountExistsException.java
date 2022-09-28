package com.chunfeng.service.ex.account;

import com.chunfeng.service.ServiceEnum;

/**
 * 添加的账号已经存在
 *
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class InsertAccountExistsException extends AccountException {
    public InsertAccountExistsException(ServiceEnum serviceEnum) {
        super(serviceEnum);
    }
}
