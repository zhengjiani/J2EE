<%--
  Created by IntelliJ IDEA.
  User: zjn
  Date: 2018/7/13
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

</head>
<body>
    <h1>客户列表页面</h1>
    <table border="1" width="100%">
        <tr>
            <th>客户姓名</th>
            <th>客户性别</th>
            <th>出生日期</th>
            <th>手机号码</th>
            <th>电子邮箱</th>
            <th>客户爱好</th>
            <th>客户类型</th>
            <th>描述信息</th>
        </tr>
        <c:forEach items="${requestScope.list}" var="Manager"></c:forEach>
        <tr>
            <td>${Manager.name}</td>
            <td>${Manager.gender}</td>
            <td>${Manager.birthday}</td>
            <td>${Manager.cellphone}</td>
            <td>${Manager.email}</td>
            <td>${Manager.preference}</td>
            <td>${Manager.type}</td>
            <td>${Manager.description}</td>

        </tr>
    </table>

</body>
</html>
