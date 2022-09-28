package com.chunfeng.service.ex.order;

import com.chunfeng.service.ServiceEnum;

/**
 * 添加的订单已经存在
 *
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class InsertOrderExistsException extends OrderException {
    public InsertOrderExistsException(ServiceEnum serviceEnum) {
        super(serviceEnum);
    }
}
