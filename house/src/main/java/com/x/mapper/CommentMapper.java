package com.x.mapper;

import com.x.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CommentMapper {
    //商品評論
    List<Comment> com(Integer id);
}
