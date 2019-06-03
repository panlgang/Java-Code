package com.github.excellent01;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @auther plg
 * @date 2019/6/3 20:02
 */

/**
 * 自定义类，继承HttpServlet
 * 覆写doGet方法  （默认get方法提交）
 */
public class MyFirstServlet extends HttpServlet {
    public MyFirstServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决中文乱码
        resp.setContentType("text/html;Charset=utf-8");
        // 返回一个打印流对象,向浏览器输出内容
        resp.getWriter().print("Hello Servlet ");
        resp.getWriter().print("你好，Servlet");
    }

}
