package com.x.servlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet(name = "DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
    //设置Servlet自动注入
    @Override
    public void init() throws ServletException {
        WebApplicationContext wac= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        wac.getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String op = request.getParameter("op");
        try {
            Method method = this.getClass().getDeclaredMethod(op, HttpServletRequest.class, HttpServletResponse.class);
            Object o = method.invoke(this, request, response);
            if (o != null) {//如果结果为空，为异步方式，Servlet的方法返回void
                String path = o.toString();
                String action = path.substring(0, path.indexOf(":"));
                String url = path.substring(path.indexOf(":") + 1);
                if (action.equals("forward")) {
                    request.getRequestDispatcher(url).forward(request, response);
                } else if (action.equals("redirect")) {
                    response.sendRedirect(url);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
