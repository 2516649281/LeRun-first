package com.chunfeng.Login.dao;

import com.chunfeng.service.inter.IOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderTest {

    @Autowired
    private IOrderService IOrderService;

    @Test
    void selectAll() {
        System.out.println(IOrderService.selectAllOrder(1, 10));
    }
}
