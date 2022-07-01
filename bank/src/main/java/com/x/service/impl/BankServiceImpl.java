package com.x.service.impl;

import com.x.entity.Bank;
import com.x.mapper.BankMapper;
import com.x.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bankService")
public class BankServiceImpl implements BankService {
    @Autowired
    private BankMapper bankMapper;

    @Override
    public boolean transMoney(String in, String out, Double money) {
        boolean flag = false;
        try {
            Bank bankIn = new Bank(in, money);
            bankMapper.update(bankIn);
            Bank bankOut = new Bank(out, -money);
            bankMapper.update(bankOut);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return flag;
    }
}
