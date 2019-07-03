<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/3
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>九九乘法表</title>
</head>
    <body>
        <%
            for(int i = 1; i <= 9; i++){
        %>
        <p>
        <%
            for(int j = 1;j <= i; j++){
        %>
        <%= j + "*" + i + "=" + (j * i) %>
        <%
            }
        %>
        <%
            }
        %>
    </body>
</html>
