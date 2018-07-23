<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %><%--
  Created by IntelliJ IDEA.
  User: zjn
  Date: 2018/7/7
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

</head>
<body>
    <h1>java方式实现的页面国际化</h1>
    <%
        Locale local=request.getLocale();
        ResourceBundle bundle=ResourceBundle.getBundle("resource",local);
    %>
    <h1>客户管理系统</h1>
    <a href="${pageContext.request.contextPath}/addManager.jsp">添加客户</a>
    <a href="${pageContext.request.contextPath}/servlet/ListManagerServlet">客户列表</a>
    <a href="${pageContext.request.contextPath}/servlet/PageManagerServlet?thispage=1">分页查询客户</a>
    <form action="#">
        <%=bundle.getString("username") %>:<input type="text"/>
        <%=bundle.getString("password") %>：<input type="password"/>
        <input type="submit" value="<%=bundle.getString("submit") %>"/>
    </form>
    <h1>fmt标签方式实现的页面国际化</h1>
    <fmt:setBundle basename="resource" var="bundle" scope="page"/>
    <form action="#">
        <fmt:message bundle="${bundle}" key="username"/>:<input type="text"/>
        <fmt:message bundle="${bundle}" key="password"/>:<input type="password">
        <input type="submit" value="<fmt:message bundle="${bundle}" key="submit"/>"/>
    </form>
</body>
</html>
