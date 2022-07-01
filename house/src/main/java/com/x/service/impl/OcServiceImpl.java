package com.x.service.impl;

import com.x.mapper.OcMapper;
import com.x.mapper.OrderMapper;
import com.x.service.OcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("ocService")
public class OcServiceImpl implements OcService {
    @Autowired
    private OcMapper ocMapper;
    @Autowired
    private OrderMapper orderMapper;


    @Override
    public Map<String, Object>add(String feelback, Integer orderId ) {
        Map<String, Object> result = new HashMap<>();
        try {
            ocMapper.add(feelback, orderId );
            orderMapper.update(orderId );
            result.put("status",200);
            result.put("msg","留言成功");
        } catch (Exception e) {
            result.put("status",500);
            result.put("msg","留言失败");
            throw new RuntimeException();
        }finally {
            return result;
        }
    }
}