package com.x.service.impl;

import com.x.entity.Item;
import com.x.entity.Order;
import com.x.mapper.ItemMapper;
import com.x.mapper.OrderMapper;
import com.x.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public List<Map<String, Object>> user(String user) {
        List<Order> list = orderMapper.user(user);
        List<Map<String, Object>> ll = new ArrayList<>();
        for (Order order : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", order.getId());
            map.put("title", order.getTitle());
            map.put("houseType", order.getHouseType());
            map.put("price", order.getPrice());
            map.put("rentType", order.getRentType());
            map.put("commentState", order.getCommentState());
            map.put("img", order.getImg());
            ll.add(map);
        }
        return ll;
    }

    @Override
    public Map<String, Object> add(Integer id, String user) {
        Map<String, Object> result = new HashMap<String, Object>();
        Item item = itemMapper.item(id).get(0);
        return null;
    }

    @Override
    public Map<String, Object> yuyue(String user, Integer id) {
        Map<String, Object> result = new HashMap<String, Object>();
        Order order = new Order();
        Item item = itemMapper.item(id).get(0);
        if (item.getIsRented()==null){
            itemMapper.isrent(id);
            order.setUsername(user);
            order.setItemId(item.getId());
            order.setTitle(item.getTitle());
            order.setHouseType(item.getHouseType());
            order.setRentType(item.getRentType());
            order.setPrice(item.getPrice());
            order.setImg(item.getImgs());
            orderMapper.add(order);
            result.put("status",200);
            result.put("msg","预订成功");
        }else {
            result.put("status",500);
            result.put("msg","手太慢，已经被抢订，预订失败");
        }
        return result;
    }
}
