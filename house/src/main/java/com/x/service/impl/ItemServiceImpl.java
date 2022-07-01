package com.x.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.x.entity.Item;
import com.x.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("itemService")
public class ItemServiceImpl implements com.x.service.ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public Map<String, Object> hots(String city) {
        Map<String, Object> result = new HashMap<>();
        PageHelper.startPage(0, 4);
        List<Item> citys = itemMapper.findByCity(city);
        List<Map> list = new ArrayList<>();
        result.put("status", 200);
        for (Item item : citys) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", item.getId());
            map.put("title", item.getTitle());
            map.put("img", item.getImgs());
            map.put("link", "");
            list.add(map);
        }
        result.put("data", list);
        return result;
    }

    @Override
    public Map<String, Object> reco(String city) {
        Map<String, Object> result = new HashMap<>();
        PageHelper.startPage(0, 4);
        List<Item> citys = itemMapper.reco(city);
        List<Map<String, Object>> list = new ArrayList<>();
        result.put("status", 200);
        for (Item item : citys) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", item.getId());
            map.put("title", item.getTitle());
            map.put("img", item.getImgs());
            map.put("link", "");
            list.add(map);
        }
        result.put("data", list);
        return result;
    }

    @Override
    public Map<String, Object> search(String city, String content, Integer page) {
        Map<String, Object> result = new HashMap<>();
        List<Item> items = itemMapper.search(city, content);
        if (items.size() > 0) {
            result.put("status", 200);
            Page<Object> objectPage = PageHelper.startPage(page, 4);
            if (objectPage.getPages() > page) {
                result.put("hasMore", true);
            } else {
                result.put("hasMore", false);
            }
            List<Map> list = new ArrayList<>();
            for (Item item : items) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", item.getId());
                map.put("title", item.getTitle());
                map.put("houseType", item.getHouseType());
                map.put("price", item.getPrice());
                map.put("rentType", item.getRentType());
                map.put("img", item.getImgs());
                list.add(map);
            }
            result.put("data", list);
            return result;
        } else {
            return null;
        }

    }

    @Override
    public Map<String, Object> item(Integer id) {
        Map<String, Object> result = new HashMap<>();
        Item item = itemMapper.item(id).get(0);
        result.put("title", item.getTitle());
        result.put("price", item.getPrice());
        result.put("rentType", item.getRentType());
        result.put("houseType", item.getHouseType());
        String info = item.getInfo();
        ObjectMapper om =new ObjectMapper();
        try {
            Map map = om.readValue(info, Map.class);
            result.put("info",map);
        }catch (IOException e){
            e.printStackTrace();
        }
        /*String[] split = item.getInfo().split(",");
        for (int i = 0; i < split.length; i++) {
            map.put(split[i].split(":")[0].toLowerCase(),split[i].split(":")[1]);
        }*/
        result.put("imgs",item.getImg().split(","));
        return result;
    }
}
