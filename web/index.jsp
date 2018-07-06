<%--
  Created by IntelliJ IDEA.
  User: zjn
  Date: 5/11/2018
  Time: 7:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>第一个web项目</title>
  </head>
  <body>
        <h1>学生大数据网站注册</h1>
        <c:if test="$(sessionScope.user==null)">
            欢迎光临，游客！
            <a href="${pageContext.request.contextPath}/regist.jsp">注册</a>
            <a href="${pageContext.request.contextPath}/login.jsp">登录</a>
        </c:if>
        <c:if test="$(sessionScope.user!=null)">
            欢迎回来$(sessionScope.user.username)!<a href="${pageContext.request.contextPath}/servlet/LogoutServlet">注销</a>
        </c:if>
  </body>
</html>
