package com.chunfeng.service.ex.order;

import com.chunfeng.service.ServiceEnum;

/**
 * 添加订单时遇到错误
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class InsertOrderErrorException extends OrderException {
    public InsertOrderErrorException(ServiceEnum serviceEnum) {
        super(serviceEnum);
    }
}
