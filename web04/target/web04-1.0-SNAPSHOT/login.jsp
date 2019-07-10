<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/9
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录验证</title>
</head>
<body>
    <%
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if("like".equals(username) && "123456".equals(password)){
            session.setAttribute("username",username);
            request.setAttribute("message","成功");
            response.sendRedirect("/welcome.jsp");
        }else{
            request.setAttribute("message","失败");
            request.getRequestDispatcher("/test.jsp").forward(request,response);
        }

    %>
</body>
</html>
