package com.x.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OcMapper {
    //添加评论
    int add(@Param("fb") String feelback, @Param("oi") Integer orderId );
}
