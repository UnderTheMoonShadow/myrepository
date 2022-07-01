package com.x.servlet;


import com.x.entity.Message;
import com.x.service.MessageService;
import com.x.service.impl.MessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = "/AddMessageServlet")
public class AddMessageServlet extends HttpServlet {
    private MessageService ms = new MessageServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决请求的中文乱码问题
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("author");
        String content = (String) request.getParameter("message");
        Message message=new Message(name,content);
        System.out.println(message.toString());
        if (ms.add(message)>0){
            response.sendRedirect("/PageMessageServlet");
        }else {
            response.sendRedirect("error.jsp");
        }
    }
}
