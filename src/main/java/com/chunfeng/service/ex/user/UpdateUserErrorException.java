package com.chunfeng.service.ex.user;

import com.chunfeng.service.ServiceEnum;

/**
 * 修改用户时遇到问题
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class UpdateUserErrorException extends UserException {
    public UpdateUserErrorException(ServiceEnum serviceEnum) {
        super(serviceEnum);
    }
}
