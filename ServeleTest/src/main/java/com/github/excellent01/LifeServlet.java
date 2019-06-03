package com.github.excellent01;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet的生命周期
 *   初始化：init
 *   服务方法：service
 *
 *   到底覆写哪个方法？
 */
public class LifeServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("初始化了。。。。");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调用了服务方法");
    }
    //post方式提交
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
   // get方式提交
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet方法。。。。。");
    }
}
