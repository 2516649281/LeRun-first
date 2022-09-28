package com.chunfeng.service.ex.user;

import com.chunfeng.service.ServiceEnum;

/**
 * 删除用户时遇到问题
 *
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class DeleteUserErrorException extends UserException {
    public DeleteUserErrorException(ServiceEnum serviceEnum) {
        super(serviceEnum);
    }
}
