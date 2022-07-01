package com.x.controller;

import com.x.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/banner")
@RestController
@CrossOrigin
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("load.do")
    public Map<String, Object> load(){
        return bannerService.load();
    }
}
