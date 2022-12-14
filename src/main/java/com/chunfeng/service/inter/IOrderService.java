package com.chunfeng.service.inter;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chunfeng.dao.entity.Json;
import com.chunfeng.dao.entity.Order;

import java.util.List;

/**
 * 账单业务
 */
public interface IOrderService extends IService<Order> {
    /**
     * 查询所有订单
     *
     * @param current 页码
     * @param size    每页显示数
     * @return Json
     */
    Json<List<Order>> selectAllOrder(int current, int size);

    /**
     * 模糊查询订单
     *
     * @param current   页码
     * @param size      每页显示数
     * @param orderName 订单名
     * @return Json
     */
    Json<List<Order>> selectLikeOrder(int current, int size, String orderName);

    /**
     * 根据跑腿员编号查询订单
     *
     * @param current 页码
     * @param size    每页显示数
     * @param runId   跑腿员编号
     * @return Json
     */
    Json<List<Order>> selectAllByRunId(int current, int size, Long runId);

    /**
     * 根据客户编号查询订单
     *
     * @param current 页码
     * @param size    每页显示数
     * @param userId  用户编号
     * @return Json
     */
    Json<List<Order>> selectAllUserId(int current, int size, Long userId);

    /**
     * 添加订单
     *
     * @param order 需提供:订单名,发起人编号;可提供:管理员(接单员)编号,跑腿员编号
     * @return Json
     */
    Json<Integer> insertOrder(Order order);

    /**
     * 修改订单
     *
     * @param order 需提供:订单编号;可提供:订单名,管理员(接单员)编号,跑腿员编号,发起人编号
     * @return Json
     */
    Json<Integer> updateOrderById(Order order);

    /**
     * 删除订单
     *
     * @param order 需提供:订单编号
     * @return Json
     */
    Json<Integer> deleteOrderById(Order order);
}
