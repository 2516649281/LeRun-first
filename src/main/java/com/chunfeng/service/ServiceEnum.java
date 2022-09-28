package com.chunfeng.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 业务层注解类
 *
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
@AllArgsConstructor
@NoArgsConstructor
public enum ServiceEnum {

    //账号异常
    SELECT_ACCOUNT_NOT_EXISTS(101, "查询的账号为空!"),
    SELECT_ACCOUNT_ERROR(102, "账号查询失败!"),
    USER_LOGIN_ERROR(103, "登录失败!"),

    INSERT_ACCOUNT_EXISTS(301, "添加的账号已经存在!"),
    INSERT_ACCOUNT_ERROR(302, "添加账号时遇到异常!"),
    USER_REGISTER_ERROR(303, "注册失败!"),

    DELETE_ACCOUNT_NOT_EXISTS(401, "删除的账号不存在!"),
    DELETE_ACCOUNT_ERROR(402, "删除账号时遇到错误!"),

    UPDATE_ACCOUNT_NOT_EXISTS(501, "修改的账号不存在!"),
    UPDATE_ACCOUNT_ERROR(502, "修改账号失败!"),

    //用户异常
    SELECT_USER_NOT_EXISTS(104, "查询的用户为空!"),
    SELECT_USER_ERROR(105, "用户查询失败!"),

    INSERT_USER_EXISTS(304, "添加的用户已经存在!"),
    INSERT_USER_ERROR(305, "添加用户时遇到异常!"),

    DELETE_USER_NOT_EXISTS(403, "删除的用户不存在!"),
    DELETE_USER_ERROR(404, "删除用户时遇到错误!"),

    UPDATE_USER_NOT_EXISTS(503, "修改的用户不存在!"),
    UPDATE_USER_ERROR(504, "修改用户失败!"),

    //订单异常
    SELECT_ORDER_NOT_EXISTS(106, "查询的订单为空!"),
    SELECT_ORDER_ERROR(107, "订单查询失败!"),

    INSERT_ORDER_EXISTS(306, "添加的订单已经存在!"),
    INSERT_ORDER_ERROR(307, "添加订单时遇到异常!"),

    DELETE_ORDER_NOT_EXISTS(405, "删除的订单不存在!"),
    DELETE_ORDER_ERROR(406, "删除订单时遇到错误!"),

    UPDATE_ORDER_NOT_EXISTS(505, "修改的订单不存在!"),
    UPDATE_ORDER_ERROR(506, "修改订单失败!");

    /**
     * 状态吗
     */
    private Integer status;

    /**
     * 消息
     */
    private String message;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
