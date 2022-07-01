package com.x.servlet;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.x.entity.Message;
import com.x.service.MessageService;
import com.x.service.impl.MessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/PageMessageServlet")
public class PageMessageServlet extends HttpServlet {
    private MessageService messageService = new MessageServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        int size = 5;
        String p = request.getParameter("page");
        if (p != null) {
            page = Integer.parseInt(p);
            System.out.println(page);
        }
        Page<Message> objectPage = PageHelper.startPage(page, size);
        List<Message> list = messageService.findAll();
        int count = objectPage.getPages();
        request.setAttribute("list", list);
        request.setAttribute("page", page);
        request.setAttribute("total", count);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
