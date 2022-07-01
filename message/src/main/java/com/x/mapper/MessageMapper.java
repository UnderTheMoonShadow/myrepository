package com.x.mapper;


import com.x.entity.Message;

import java.util.List;

public interface MessageMapper {
    //添加留言
    int add(Message message);
    //分页查询留言
    List<Message> findAll();
}
