package com.chunfeng.service.ex.order;

import com.chunfeng.service.ServiceEnum;

/**
 * 查询的订单为空
 *
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
public class SelectOrderNotExistsException extends OrderException {

    public SelectOrderNotExistsException(ServiceEnum serviceEnum) {
        super(serviceEnum);
    }
}
