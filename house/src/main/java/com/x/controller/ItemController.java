package com.x.controller;

import com.x.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/item")
@CrossOrigin
public class ItemController {
    @Autowired
    private ItemService itemService;

    //热销商品
    @RequestMapping("/hots.do")
    public Map<String, Object> hots(String city) {
        return itemService.hots(city);
    }

    //热门推荐
    @RequestMapping("/reco.do")
    public Map<String, Object> reco(String city) {
        return itemService.reco(city);
    }

    //搜索
    @RequestMapping("/search.do")
    public Map<String, Object> search(String city,String content,Integer page){
        return itemService.search(city, content,page);
    }

    //商品詳情
    @RequestMapping("/item.do")
    public Map<String, Object> item(Integer id){
        return itemService.item(id);
    }
}
