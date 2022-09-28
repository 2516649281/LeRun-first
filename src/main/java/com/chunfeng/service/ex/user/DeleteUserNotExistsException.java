package com.chunfeng.service.ex.user;

import com.chunfeng.service.ServiceEnum;

/**
 * 删除的用户不存在
 *
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class DeleteUserNotExistsException extends UserException {
    public DeleteUserNotExistsException(ServiceEnum serviceEnum) {
        super(serviceEnum);
    }
}
