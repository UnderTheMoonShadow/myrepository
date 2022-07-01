package com.x.servlet;

import com.x.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BankServlet", value = "/BankServlet")
public class BankServlet extends DispatcherServlet {
    @Autowired
    private BankService bankService;

    protected String transMoney(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String in = request.getParameter("in");
        String out = request.getParameter("out");
        double money = Double.parseDouble(request.getParameter("money"));
        try {
            bankService.transMoney(in, out, money);
            return "redirect:ok.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:error.jsp";
        }
    }
}
