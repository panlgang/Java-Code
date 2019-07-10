<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/9
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>安全退出</title>
</head>
<body>
  <%
        session.invalidate();
        response.sendRedirect("/test.jsp");
  %>
</body>
</html>
