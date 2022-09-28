package com.chunfeng.service.ex.user;

import com.chunfeng.service.ServiceEnum;

/**
 * 添加的用户已经存在
 *
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class InsertUserExistsException extends UserException {
    public InsertUserExistsException(ServiceEnum serviceEnum) {
        super(serviceEnum);
    }
}
