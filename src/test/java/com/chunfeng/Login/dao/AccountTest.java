package com.chunfeng.Login.dao;

import com.chunfeng.service.inter.IAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AccountTest {

    @Autowired
    private IAccountService IAccountService;

    @Test
    void selectAll() {
        System.out.println(IAccountService.selectAllAccount(1, 10));
    }

    @Test
    void selectWrapper() {
        System.out.println(IAccountService.selectAccountWrapper(1, 10, "2"));
    }
}
