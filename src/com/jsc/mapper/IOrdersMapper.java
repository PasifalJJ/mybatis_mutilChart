package com.jsc.mapper;

import com.jsc.model.User;

import java.util.List;

public interface IOrdersMapper {

    /**
     * 根据商品ID查找定单信息，包括用户名和地址
     */
    List<User> findOrdersByItemid(int itemsId);

    /**
     * 根据定单ID查找定单信息、用户信息和定单明细信息
     */
    User findOrdersByOrdersId(int ordersId);

    /**
     * 查询用户信息及用户购买的商品信息，要求将关联信息映射到主pojo的pojo属性中
     */
    List<User> findUserAndItems();



}
