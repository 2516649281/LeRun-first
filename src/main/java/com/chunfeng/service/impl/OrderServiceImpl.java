package com.chunfeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chunfeng.dao.entity.Json;
import com.chunfeng.dao.entity.Order;
import com.chunfeng.dao.mapper.OrderMapper;
import com.chunfeng.dao.mapper.UserMapper;
import com.chunfeng.service.ServiceEnum;
import com.chunfeng.service.ex.order.*;
import com.chunfeng.service.inter.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 账单业务实现
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    /**
     * 订单业务层
     */
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 用户编号
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有订单
     *
     * @param current 页码
     * @param size    每页显示数
     * @return Json
     */
    @Override
    public Json<List<Order>> selectAllOrder(int current, int size) {
        Page<Order> orderPage = orderMapper.selectPage(new Page<>(current, size), null);
        if (orderPage.getRecords().isEmpty()) {
            throw new SelectOrderNotExistsException(ServiceEnum.SELECT_ORDER_NOT_EXISTS);
        }
        getUserName(orderPage);
        return new Json<>(orderPage.getRecords(), orderPage.getTotal());
    }

    /**
     * 模糊查询订单
     *
     * @param current   页码
     * @param size      每页显示数
     * @param orderName 订单名
     * @return Json
     */
    @Override
    public Json<List<Order>> selectLikeOrder(int current, int size, String orderName) {
        Page<Order> orderPage = orderMapper.selectPage(new Page<>(current, size),
                new LambdaQueryWrapper<Order>()
                        .like(Order::getOrderName, orderName));
        if (orderPage.getRecords().isEmpty()) {
            throw new SelectOrderNotExistsException(ServiceEnum.SELECT_ORDER_NOT_EXISTS);
        }
        getUserName(orderPage);
        return new Json<>(orderPage.getRecords(), orderPage.getTotal());
    }

    /**
     * 根据跑腿员编号查询订单
     *
     * @param current 页码
     * @param size    每页显示数
     * @param runId   跑腿员编号
     * @return Json
     */
    @Override
    public Json<List<Order>> selectAllByRunId(int current, int size, Long runId) {
        Page<Order> orderPage = orderMapper.selectPage(new Page<>(current, size),
                new LambdaQueryWrapper<Order>()
                        .eq(Order::getRunId, runId));
        getUserName(orderPage);
        return new Json<>(orderPage.getRecords(), orderPage.getTotal());
    }

    /**
     * 根据客户编号查询订单
     *
     * @param current 页码
     * @param size    每页显示数
     * @param userId  用户编号
     * @return Json
     */
    @Override
    public Json<List<Order>> selectAllUserId(int current, int size, Long userId) {
        Page<Order> orderPage = orderMapper.selectPage(new Page<>(current, size),
                new LambdaQueryWrapper<Order>()
                        .eq(Order::getUserId, userId));
        getUserName(orderPage);
        return new Json<>(orderPage.getRecords(), orderPage.getTotal());
    }

    /**
     * 添加订单
     *
     * @param order 需提供:订单名,发起人编号;可提供:管理员(接单员)编号,跑腿员编号
     * @return Json
     */
    @Override
    public Json<Integer> insertOrder(Order order) {
        int insert = orderMapper.insert(order);
        if (insert < 1) {
            throw new InsertOrderErrorException(ServiceEnum.INSERT_ORDER_ERROR);
        }
        return new Json<>(insert);
    }

    /**
     * 修改订单
     *
     * @param order 需提供:订单编号;可提供:订单名,管理员(接单员)编号,跑腿员编号,发起人编号
     * @return Json
     */
    @Override
    public Json<Integer> updateOrderById(Order order) {
        Order order1 = orderMapper.selectById(order.getOrderId());
        if (Objects.isNull(order1)) {
            throw new UpdateOrderNotExistsException(ServiceEnum.UPDATE_ORDER_NOT_EXISTS);
        }
        int updateById = orderMapper.updateById(order);
        if (updateById < 1) {
            throw new UpdateOrderErrorException(ServiceEnum.UPDATE_ORDER_ERROR);
        }
        return new Json<>(updateById);
    }

    /**
     * 删除订单
     *
     * @param order 需提供:订单编号
     * @return Json
     */
    @Override
    public Json<Integer> deleteOrderById(Order order) {
        Order order1 = orderMapper.selectById(order.getOrderId());
        if (Objects.isNull(order1)) {
            throw new DeleteOrderNotExistsException(ServiceEnum.DELETE_ORDER_NOT_EXISTS);
        }
        int deleteById = orderMapper.deleteById(order.getOrderId());
        if (deleteById < 1) {
            throw new DeleteOrderErrorException(ServiceEnum.DELETE_ORDER_ERROR);
        }
        return new Json<>(deleteById);
    }

    /**
     * 以编号获取名称
     *
     * @param orderPage 分页类
     */
    private void getUserName(Page<Order> orderPage) {
        List<Order> records = orderPage.getRecords();
        for (Order record : records) {
            if (record.getUserId() != null) {//获取发起人
                record.setUser(userMapper.selectById(record.getUserId()));
            }
            if (record.getAdminId() != null) {//获取接单员
                record.setAdmin(userMapper.selectById(record.getAdminId()));
            }
            if (record.getRunId() != null) {//获取跑腿员
                record.setRun(userMapper.selectById(record.getRunId()));
            }
        }
    }
}
