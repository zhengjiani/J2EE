<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: zjn
  Date: 2018/6/23
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.zjn.com/UserTag" prefix="UserTag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div align="center">
    <h1>学生教育大数据网站_登录</h1><hr>
        <span style="color: red; ">${msg}</span>
    <form action="${pageContext.request.contextPath}/servlet/LoginServlet" method="post">
        <table border="1">
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="username" value="<UserTag:URLDecoder content="${cookie.remname.value}" encode="Utf-8"/>"/></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password"/></td>
            </tr>

            <tr>

                <td colspan="2"><input type="submit" value="登录"/></td>
                <td><input type="checkbox" value="ok" name="remname"
                        <c:if test="${cookie.remname!=null}">
                            checked="checked"
                        </c:if>
                />记住用户名</td>

            </tr>
        </table>
    </form>
    </div>
</body>
</html>
