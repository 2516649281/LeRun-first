package com.chunfeng.service.ex.account;

import com.chunfeng.service.ServiceEnum;

/**
 * 查询账号出现问题
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class SelectAccountErrorException extends AccountException{
    public SelectAccountErrorException(ServiceEnum serviceEnum) {
        super(serviceEnum);
    }
}
