package com.x.mapper;

import com.x.entity.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemMapper {
    //热销产品
    List<Item> findByCity(String city);
    //热门推荐
    List<Item> reco(String city);
    //搜索
    List<Item> search(@Param("city") String city,@Param("content") String content);
    //商品详情
    List<Item> item(Integer id);
    //根据订单ID修改订单是否预约
    int isrent(Integer id);
}
