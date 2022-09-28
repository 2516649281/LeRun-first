package com.chunfeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chunfeng.dao.entity.Account;
import com.chunfeng.dao.entity.Json;
import com.chunfeng.dao.entity.User;
import com.chunfeng.dao.mapper.AccountMapper;
import com.chunfeng.dao.mapper.UserMapper;
import com.chunfeng.service.ServiceEnum;
import com.chunfeng.service.ex.account.*;
import com.chunfeng.service.inter.IAccountService;
import com.chunfeng.util.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 账号业务实现
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

    /**
     * 账号数据层
     */
    @Autowired
    private AccountMapper accountMapper;

    /**
     * 用户数据层
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * 永久删除账号(注销)
     *
     * @param account 需提供:用户编号
     * @return 影响行数
     */
    @Override
    public Json<Integer> deleteByAccountId(Account account) {
        Account selectById = accountMapper.selectById(account.getAccountId());
        if (Objects.isNull(selectById)) {
            throw new SelectAccountNotExistsException(ServiceEnum.DELETE_ACCOUNT_NOT_EXISTS);
        }
        Integer integer = accountMapper.deleteByAccountId(account);
        if (integer < 1) {
            throw new DeleteAccountErrorException(ServiceEnum.DELETE_ACCOUNT_ERROR);
        }
        return new Json<>(integer);
    }

    /**
     * 查询所有账号(包含已注销用户)
     *
     * @param current 页码
     * @param size    每页显示数
     * @return page
     */
    @Override
    public Json<List<Account>> selectAllAccount(int current, int size) {
        Page<Account> accountPage = accountMapper.selectAllAccount(new Page<>(current, size));
        if (accountPage.getRecords().isEmpty()) {
            throw new SelectAccountNotExistsException(ServiceEnum.SELECT_ACCOUNT_NOT_EXISTS);
        }
        return new Json<>(accountPage.getRecords(), accountPage.getTotal());
    }

    /**
     * 条件查询用户(包含已注销的用户)
     *
     * @param current     页码
     * @param size        每页显示数
     * @param accountName 账号
     * @return Account
     */
    @Override
    public Json<List<Account>> selectAccountWrapper(int current, int size, String accountName) {

        Page<Account> accountPage = accountMapper.selectAccountWrapper(new Page<>(current, size), new QueryWrapper<Account>().like("account_Name", accountName));
        if (accountPage.getRecords().isEmpty()) {
            throw new SelectAccountNotExistsException(ServiceEnum.SELECT_ACCOUNT_NOT_EXISTS);
        }
        return new Json<>(accountPage.getRecords(), accountPage.getTotal());
    }

    /**
     * 添加账号
     *
     * @param account 需提供:账号,密码
     * @return Json
     */
    @Override
    public Json<Integer> insertAccount(Account account) {
        Account selectOne = accountMapper.selectOne(new LambdaQueryWrapper<Account>()
                .eq(Account::getAccountName, account.getAccountName()));
        if (!Objects.isNull(selectOne)) {
            throw new InsertAccountExistsException(ServiceEnum.INSERT_ACCOUNT_EXISTS);
        }
        int insert = accountMapper.insert(account);
        if (insert < 1) {
            throw new InsertAccountErrorException(ServiceEnum.INSERT_ACCOUNT_ERROR);
        }
        return new Json<>(insert);
    }

    /**
     * 修改账号
     *
     * @param account 需提供:账号编号,可提供:账号,密码
     * @return Json
     */
    @Override
    public Json<Integer> updateAccountById(Account account) {
        Account account1 = accountMapper.selectById(account.getAccountId());
        if (Objects.isNull(account1)) {
            throw new UpdateAccountNotExistsException(ServiceEnum.UPDATE_ACCOUNT_NOT_EXISTS);
        }
        int updateById = accountMapper.updateById(account);
        if (updateById < 1) {
            throw new UpdateAccountErrorException(ServiceEnum.UPDATE_ACCOUNT_ERROR);
        }
        return new Json<>(updateById);
    }

    /**
     * 冻结账号
     *
     * @param account 需提供:账号编号
     * @return Json
     */
    @Override
    public Json<Integer> freezeAccountById(Account account) {
        Account account1 = accountMapper.selectById(account.getAccountId());
        if (Objects.isNull(account1)) {
            throw new DeleteAccountNotExistsException(ServiceEnum.DELETE_ACCOUNT_NOT_EXISTS);
        }
        int deleteById = accountMapper.deleteById(account.getAccountId());
        if (deleteById < 1) {
            throw new UpdateAccountErrorException(ServiceEnum.DELETE_ACCOUNT_ERROR);
        }
        return new Json<>(deleteById);
    }

    /**
     * 解冻账号
     *
     * @param account 需提供:账号编号
     * @return Json
     */
    @Override
    public Json<Integer> unfreezeAccountById(Account account) {
        //Account account1 = accountMapper.selectById(account.getAccountId());
        //if (Objects.isNull(account1)) {
        //    throw new DeleteAccountNotExistsException(ServiceEnum.DELETE_ACCOUNT_NOT_EXISTS);
        //}
        int deleteById = accountMapper.updateAccountDeleted(account);
        if (deleteById < 1) {
            throw new UpdateAccountErrorException(ServiceEnum.DELETE_ACCOUNT_ERROR);
        }
        return new Json<>(deleteById);
    }

    /**
     * 登录
     *
     * @param account 需提供:账号,密码
     * @return Json
     */
    @Override
    public Json<String> login(Account account) {
        Account accountObject = accountMapper.selectOne(new LambdaQueryWrapper<Account>()
                .eq(Account::getAccountName, account.getAccountName())
                .eq(Account::getAccountPassword, account.getAccountPassword()));
        if (Objects.isNull(accountObject)) {
            throw new UserLoginErrorException(ServiceEnum.USER_LOGIN_ERROR);
        }
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>()
                .eq(User::getAccountId, accountObject.getAccountId()));
        accountObject.setUser(user);
        String token = JwtToken.createToken(accountObject);
        return new Json<>(token);
    }
}
