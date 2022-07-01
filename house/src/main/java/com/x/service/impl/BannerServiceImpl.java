package com.x.service.impl;

import com.github.pagehelper.PageHelper;
import com.x.entity.Banner;
import com.x.mapper.BannerMapper;
import com.x.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("bannerService")
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;
    @Override
    public Map<String, Object> load() {
        Map<String, Object> result= new HashMap<>();
        PageHelper.startPage(0,4);
        List<String> imgs=new ArrayList<>();
        List<Banner> list = bannerMapper.findAll();
        for (Banner banner:list){
            imgs.add(banner.getUrl());
        }
        result.put("status",200);
        result.put("results",imgs);
        return result;
    }
}
