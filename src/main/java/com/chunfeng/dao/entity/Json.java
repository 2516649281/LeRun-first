package com.chunfeng.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Json包装类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Json<T> {
    private Integer status = 200;//状态
    private String message;//消息
    private T data = null;//数据
    private Long pageSize = 0L;//查询结果数

    public Json(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Json(T data) {
        this.data = data;
    }

    public Json(T data, Long pageSize) {
        this.data = data;
        this.pageSize = pageSize;
    }
}
