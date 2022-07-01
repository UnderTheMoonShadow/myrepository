package com.x.mapper;

import com.x.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    //用户订单
    List<Order> user(String user);
    //修改订单状态
    int update(Integer orderId );
    //添加一条预定
    int add(Order order);
}
