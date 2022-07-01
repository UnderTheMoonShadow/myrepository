package com.x.service;

import com.x.entity.Item;

import java.util.Map;

public interface ItemService {
    Map<String,Object> hots(String  city);//热销产品
    Map<String, Object> reco(String city);//热门推荐
    Map<String, Object> search(String city,String content,Integer page);//搜索
    Map<String, Object> item(Integer id);//商品详情
}
