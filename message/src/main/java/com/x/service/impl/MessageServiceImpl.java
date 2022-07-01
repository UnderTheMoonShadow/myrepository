package com.x.service.impl;

import com.x.entity.Message;
import com.x.mapper.MessageMapper;
import com.x.service.MessageService;
import com.x.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class MessageServiceImpl implements MessageService {
    int p;

    @Override
    public int add(Message message) {
        try {
            SqlSession session = MybatisUtils.getSession();
            MessageMapper mapper = session.getMapper(MessageMapper.class);
            int i = mapper.add(message);
            session.commit();
            return i;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            MybatisUtils.closeSession();
        }

    }

    @Override
    public List<Message> findAll() {
        try {
            SqlSession session = MybatisUtils.getSession();
            MessageMapper mapper = session.getMapper(MessageMapper.class);
            List<Message> messages = mapper.findAll();
            return messages;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            MybatisUtils.closeSession();
        }

    }

}
