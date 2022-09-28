package com.chunfeng.service.ex.user;

import com.chunfeng.service.ServiceEnum;

/**
 * 查询的用户为空
 *
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class SelectUserNotExistsException extends UserException {

    public SelectUserNotExistsException(ServiceEnum serviceEnum) {
        super(serviceEnum);
    }
}
