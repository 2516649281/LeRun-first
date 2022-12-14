package com.chunfeng.controller;

import com.chunfeng.dao.entity.Account;
import com.chunfeng.dao.entity.Json;
import com.chunfeng.service.inter.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 账号接口类
 */
@RestController
@RequestMapping("/account")
public class AccountController extends ServiceController {

    /**
     * 账号业务层
     */
    @Autowired
    private IAccountService accountService;

    /**
     * 查询所有账号(包含已注销用户)
     *
     * @param current 页码
     * @param size    每页显示数
     * @return Json
     */
    @GetMapping("/{current}/{size}")
    Json<List<Account>> selectAllAccount(@PathVariable int current, @PathVariable int size) {
        return accountService.selectAllAccount(current, size);
    }

    /**
     * 指定查询用户(包含已注销的用户)
     *
     * @param current     页码
     * @param size        每页显示数
     * @param accountName 账号
     * @return Json
     */
    @GetMapping("/{current}/{size}/{accountName}")
    Json<List<Account>> selectAllLikeName(@PathVariable int current, @PathVariable int size, @PathVariable String accountName) {
        return accountService.selectAccountWrapper(current, size, accountName);
    }

    /**
     * 添加账号
     *
     * @param account 需提供:账号,密码
     * @return Json
     */
    @PostMapping("/register")
    Json<Integer> insertAccount(@RequestBody Account account) {
        return accountService.insertAccount(account);
    }

    /**
     * 修改账号
     *
     * @param account 需提供:账号编号,可提供:账号,密码
     * @return Json
     */
    @PutMapping(params = "ud")
    Json<Integer> updateAccountById(@RequestBody Account account) {
        return accountService.updateAccountById(account);
    }

    /**
     * 冻结账号
     *
     * @param account 需提供:账号编号
     * @return Json
     */
    @DeleteMapping
    Json<Integer> deleteAccountById(@RequestBody Account account) {
        return accountService.freezeAccountById(account);
    }

    /**
     * 解冻账号
     *
     * @param account 需提供:账号编号
     * @return Json
     */
    @PutMapping(params = "ufz")
    Json<Integer> unfreezeAccountById(@RequestBody Account account) {
        return accountService.unfreezeAccountById(account);
    }

    /**
     * 登录
     *
     * @param account 需提供:账号,密码
     * @return Json
     */
    @PostMapping("/login")
    Json<String> Login(@RequestBody Account account) {
        return accountService.login(account);
    }
}
