<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/9
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
   <%
       String name = (String) session.getAttribute("username");
       out.write("欢迎你" + name);
   %>
    <a href="logout.jsp">安全退出</a>
</body>
</html>
