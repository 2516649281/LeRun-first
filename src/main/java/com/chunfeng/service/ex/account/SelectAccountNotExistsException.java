package com.chunfeng.service.ex.account;

import com.chunfeng.service.ServiceEnum;

/**
 * 查询的账号为空
 *
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class SelectAccountNotExistsException extends AccountException {

    public SelectAccountNotExistsException(ServiceEnum serviceEnum) {
        super(serviceEnum);
    }
}
