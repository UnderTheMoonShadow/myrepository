package com.x.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;

public class SendMessage {
    public static void send(String phone,String code) {
        try{
            DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI5tK5mBjEnGngAxM1WjEL", "GOZ37c9ER06i4zCEZUcNVNW7dkfrMP");
            DefaultProfile.addEndpoint("","cn-hangzhou","Dysmsapi","dysmsapi.aliyuncs.com");
            IAcsClient client = new DefaultAcsClient(profile);
            SendSmsRequest request = new SendSmsRequest();
            request.setSignName("阿里云短信测试");
            request.setTemplateCode("SMS_154950909");
            request.setPhoneNumbers(phone);
            request.setTemplateParam("{\"code\":\""+code+"\"}");
            SendSmsResponse response = client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
