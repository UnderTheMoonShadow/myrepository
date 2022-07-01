package com.x.service;

import java.util.List;
import java.util.Map;

public interface OrderService {
    //用户订单
    List<Map<String, Object>> user(String user);
    //添加一份订单
    Map<String, Object> add(Integer id,String user);
    //订单预约
    Map<String, Object> yuyue(String user,Integer id);
}
