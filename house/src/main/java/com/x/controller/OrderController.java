package com.x.controller;

import com.x.service.OcService;
import com.x.service.OrderService;
import com.x.utils.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    private String code;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OcService ocService;

    @RequestMapping("/order.do")
    public List<Map<String,Object>> order(String user){
        return orderService.user(user);
    }

    @RequestMapping("/pl.do")
    public Map<String, Object> pl(String feelback,Integer orderId){
        return ocService.add(feelback, orderId);
    }

    @RequestMapping("/syzm.do")
    public String syzm(String phone){
        this.code=(int)(Math.random()*10000)+"";//随机产生一个验证码
        //将验证码发送给手机
        /*SendMessage.send(phone,code);*/
        //阿里云短信服务
        System.out.println(code);
        return code;
    }

    @RequestMapping("login.do")
    public Map<String,Object> login(String code){
        System.out.println(this.code+"--"+code);
        Map<String,Object> result = new HashMap<String,Object>();
        if (this.code.equals(code)){
            result.put("status",200);
            result.put("msg","登陆成功");
        }else {
            result.put("status",500);
            result.put("msg","登陆失败");
        }
        return result;
    }

    @RequestMapping("/yuyue.do")
    public Map<String, Object> yy(String user,Integer id){
       return orderService.yuyue(user, id);
    }

    @RequestMapping("/time.do")
    public Map<String,Object> time(){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("status",200);
        result.put("time",(new Date().getTime()+20000));
        return result;
    }
}
