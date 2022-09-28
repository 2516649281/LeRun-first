package com.chunfeng.service.ex.user;

import com.chunfeng.service.ServiceEnum;

/**
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class UpdateUserNotExistsException extends UserException {
    public UpdateUserNotExistsException(ServiceEnum serviceEnum) {
        super(serviceEnum);
    }
}
