<%--
  Created by IntelliJ IDEA.
  User: zjn
  Date: 2018/7/7
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        .show{
            width:500px;
            height: 500px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<h1>添加客户</h1>
<div class="show">
<form action="${pageContext.request.contextPath}/servlet/AddManagerServlet" method="post">
    <table>
        <tr>
            <td>客户姓名</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>客户性别</td>
            <td>
                <input type="radio" name="gender" value="男">男
                <input type="radio" name="gender" value="女">女
            </td>
        </tr>
        <tr>
            <td>出生日期</td>
            <td><input type="text" name="birthday"></td>
        </tr>
        <tr>
            <td>手机号码</td>
            <td><input type="text" name="cellphone"></td>
        </tr>
        <tr>
            <td>电子邮箱</td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td>客户爱好</td>
            <td>
                <input type="checkbox" name="preference" value="篮球" />篮球
                <input type="checkbox" name="preference" value="足球" />足球
                <input type="checkbox" name="preference" value="排球" />排球
                <input type="checkbox" name="preference" value="乒乓球" />乒乓球
                <input type="checkbox" name="preference" value="玻璃球" />玻璃球
            </td>
        </tr>
        <tr>
            <td>客户类型</td>
            <td>
                <select name="type">
                    <option value="钻石客户">钻石客户</option>
                    <option value="白金客户">白金客户</option>
                    <option value="黄金客户">黄金客户</option>
                    <option value="白银客户">白银客户</option>
                    <option value="青铜客户">青铜客户</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>描述信息</td>
            <td><textarea name="description" rows="6" cols="40"></textarea></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="添加客户" />
            </td>
        </tr>
    </table>
</form>
</div>
</body>
</html>
