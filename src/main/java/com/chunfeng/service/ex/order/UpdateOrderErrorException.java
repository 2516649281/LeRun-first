package com.chunfeng.service.ex.order;

import com.chunfeng.service.ServiceEnum;

/**
 * 修改订单时遇到问题
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class UpdateOrderErrorException extends OrderException {
    public UpdateOrderErrorException(ServiceEnum serviceEnum) {
        super(serviceEnum);
    }
}
