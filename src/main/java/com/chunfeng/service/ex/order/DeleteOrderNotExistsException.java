package com.chunfeng.service.ex.order;

import com.chunfeng.service.ServiceEnum;

/**
 * 删除的订单不存在
 *
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class DeleteOrderNotExistsException extends OrderException {
    public DeleteOrderNotExistsException(ServiceEnum serviceEnum) {
        super(serviceEnum);
    }
}
