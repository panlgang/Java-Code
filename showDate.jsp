<%@ page import="java.util.Date" %>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/3
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>第一个JSP页面</title>
</head>
    <body>
        <h2>您好！</h2>
        <%
           Date date = new Date();
           System.out.println("当前时间：" + date.toLocaleString());
           out.println("当前时间：" + date.toLocaleString());
        %>

    </body>
</html>
