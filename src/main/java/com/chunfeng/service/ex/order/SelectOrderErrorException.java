package com.chunfeng.service.ex.order;

import com.chunfeng.service.ServiceEnum;

/**
 * 查询订单出现问题
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class SelectOrderErrorException extends OrderException {
    public SelectOrderErrorException(ServiceEnum serviceEnum) {
        super(serviceEnum);
    }
}
