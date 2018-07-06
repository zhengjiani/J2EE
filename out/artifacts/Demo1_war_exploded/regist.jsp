<%--
  Created by IntelliJ IDEA.
  User: zjn
  Date: 2018/6/23
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function changeImg(img) {
            img.src=img.src+"?time="+new Date().getTime();
        }
    </script>
</head>
<body style="text-align: center;">
    <h1>学生教育大数据网站_注册功能</h1>
    <span style="color: red; ">${msg}</span>
    <form action="${pageContext.request.contextPath}/servlet/RegistServlet" method="post">
        <table border="1">
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username" value="${param.username}"/></td>

            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password" /></td>
            </tr>
            <tr>
                <td>确认密码</td>
                <td><input type="password" name="password" /></td>
            </tr>
            <%--<tr>--%>
                <%--<td>昵称</td>--%>
                <%--<td><input type="text" name="nickname" value="${param.nickname}"/></td>--%>
            <%--</tr>--%>
            <tr>
                <td>类型</td>
                <td><input type="radio" checked="checked" value="${param.tyname}"/></td>
            </tr>
            <tr>
                <td>验证码</td>
                <td><input type="text" name="valistr" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="注册" /></td>
                <td><img src="${pageContext.request.contextPath}/servlet/ValiImg" style="cursor:pointer" onclick="changeImg(this)"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
