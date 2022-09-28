package com.chunfeng.service.ex.order;

import com.chunfeng.service.ServiceEnum;

/**
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class UpdateOrderNotExistsException extends OrderException {
    public UpdateOrderNotExistsException(ServiceEnum serviceEnum) {
        super(serviceEnum);
    }
}
