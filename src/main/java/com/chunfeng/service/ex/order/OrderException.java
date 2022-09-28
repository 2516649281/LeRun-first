package com.chunfeng.service.ex.order;

import com.chunfeng.service.ServiceEnum;
import com.chunfeng.service.ServiceException;

/**
 * 订单业务层异常超类
 *
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class OrderException extends ServiceException {
    public OrderException(ServiceEnum serviceEnum) {
        super(serviceEnum);
    }
}
