package com.chunfeng.service.ex.account;

import com.chunfeng.service.ServiceEnum;

/**
 * 删除账号时遇到问题
 *
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class DeleteAccountErrorException extends  AccountException{
    public DeleteAccountErrorException(ServiceEnum serviceEnum) {
        super(serviceEnum);
    }
}
