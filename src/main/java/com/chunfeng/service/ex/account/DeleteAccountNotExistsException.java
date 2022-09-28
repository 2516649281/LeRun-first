package com.chunfeng.service.ex.account;

import com.chunfeng.service.ServiceEnum;

/**
 * 删除的用户不存在
 *
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class DeleteAccountNotExistsException extends AccountException {
    public DeleteAccountNotExistsException(ServiceEnum serviceEnum) {
        super(serviceEnum);
    }
}
