<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/9
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <%
        String message = (String) request.getAttribute("message");
        if(message != null){
            out.write("<h1>");
            out.write(message);
            out.write("</h1>");
        }else{
            out.write("oooooo");
        }
    %>
    <div>
        <form action="/login.jsp" method="post">
            用户名：<input type="text" name="username">
            密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password">
            <input type="submit" value="登录">
        </form>
    </div>
</body>
</html>
