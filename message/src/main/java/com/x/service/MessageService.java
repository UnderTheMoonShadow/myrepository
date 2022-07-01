package com.x.service;

import com.x.entity.Message;

import java.util.List;

public interface MessageService {
    //添加留言
    int add(Message message);
    //分页查询留言
    List<Message> findAll();

}
