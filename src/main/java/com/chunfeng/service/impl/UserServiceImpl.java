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
import com.chunfeng.service.ex.user.*;
import com.chunfeng.service.inter.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 用户业务实现
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    /**
     * 用户数据层
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * 账号数据层
     */
    @Autowired
    private AccountMapper accountMapper;

    /**
     * 查询所有用户
     *
     * @param current 页码
     * @param size    每页显示数
     * @return Json
     */
    @Override
    public Json<List<User>> selectAllUser(int current, int size) {
        Page<User> userPage = userMapper.selectPage(new Page<>(current, size), null);
        if (userPage.getRecords().isEmpty()) {
            throw new SelectUserNotExistsException(ServiceEnum.SELECT_USER_NOT_EXISTS);
        }
        return new Json<>(userPage.getRecords(), userPage.getTotal());
    }

    /**
     * 按照职务查询用户
     *
     * @param current 页码
     * @param size    每页显示数
     * @param duty    职务
     * @return Json
     */
    @Override
    public Json<List<User>> selectAllUserByDuty(int current, int size, String duty) {
        Page<User> userPage = userMapper.selectPage(new Page<>(current, size), new QueryWrapper<User>().eq("user_duty", duty));
        if (userPage.getRecords().isEmpty()) {
            throw new SelectUserNotExistsException(ServiceEnum.SELECT_USER_NOT_EXISTS);
        }
        return new Json<>(userPage.getRecords(), userPage.getTotal());
    }

    /**
     * 添加用户信息
     *
     * @param user 需提供:姓名,年龄,性别,住址,电话号码,账号编号
     * @return Json
     */
    @Override
    public Json<Integer> insertUser(User user) {
        int insert = userMapper.insert(user);
        if (insert < 1) {
            throw new InsertUserErrorException(ServiceEnum.INSERT_USER_ERROR);
        }
        return new Json<>(insert);
    }

    /**
     * 删除用户信息
     *
     * @param user 用户编号
     * @return Json
     */
    @Override
    public Json<Integer> deleteUser(User user) {
        Account account = new Account();
        account.setAccountId(user.getAccountId());
        Page<Account> accountPage = accountMapper.selectAccountWrapper(
                new Page<>(1, 10),
                new LambdaQueryWrapper<Account>()
                        .eq(Account::getAccountId, user.getUserId()));
        if (accountPage.getRecords().isEmpty()) {//判断用户是否存在
            throw new DeleteUserNotExistsException(ServiceEnum.DELETE_USER_NOT_EXISTS);
        }
        Integer integer = accountMapper.deleteByAccountId(account);//删除账号
        if (integer < 1) {
            throw new DeleteUserErrorException(ServiceEnum.DELETE_USER_ERROR);
        }
        return new Json<>(integer);
    }

    /**
     * 修改用户信息
     *
     * @param user 需提供:用户编号,可提供:姓名,年龄,性别,住址,电话号码
     * @return Json
     */
    @Override
    public Json<Integer> updateUser(User user) {
        User user1 = userMapper.selectById(user.getUserId());
        if (Objects.isNull(user1)) {
            throw new UpdateUserNotExistsException(ServiceEnum.UPDATE_USER_NOT_EXISTS);
        }
        int updateById = userMapper.updateById(user);
        if (updateById < 1) {
            throw new UpdateUserErrorException(ServiceEnum.UPDATE_USER_ERROR);
        }
        return new Json<>(updateById);
    }
}