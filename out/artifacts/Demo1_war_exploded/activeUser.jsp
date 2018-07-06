<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="com.waxx.impl.UserDaoImpl" %>
<%@ page import="com.waxx.service.UserService" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>写数据库</title>
</head>
<body  bgcolor="#DAF9FE">
<%
    String uid=request.getParameter("uid");
    String validateCode=request.getParameter("validateCode");
    UserService userService=new UserService();
    if(userService.validateUser(uid,validateCode)){
%>
<center><font color="Blue">您的帐号已经激活，现在可以登录了！</font><a href="login.jsp">登陆</a></center>
<%
}else{
%>
<center><font color="red">验证失败!</a></center>
<%
    }
%>
</body>
</html>