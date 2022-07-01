package com.x.service.impl;

import com.x.entity.Comment;
import com.x.mapper.CommentMapper;
import com.x.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public Map<String, Object> com(Integer id) {
        Map<String, Object> result = new HashMap<>();
        result.put("status",200);
        result.put("hasMore",false);
        List<Comment> list = commentMapper.com(id);
        result.put("data",list);
        return result;
    }
}
