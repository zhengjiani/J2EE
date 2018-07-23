<%--
  Created by IntelliJ IDEA.
  User: zjn
  Date: 2018/7/7
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
<h1>修改客户</h1>
<div class="show">
    <form action="${pageContext.request.contextPath}/servlet/UpdateManagerServlet" method="post">
        <input type="hidden" name="id" value="${manager.id}">
        <table>
            <tr>
                <td>客户姓名</td>
                <td><input type="text" name="name" value="${manager.name}" readonly="readonly" style="background: gray"></td>
            </tr>
            <tr>
                <td>客户性别</td>
                <td>
                    <input type="radio" name="gender" value="男"
                        <c:if test="${manager.gender=='男'}">checked='checked'</c:if>
                    />男
                    <input type="radio" name="gender" value="女"
                    <c:if test="${manager.gender=='男'}">checked='checked'</c:if>
                    />女
                </td>
            </tr>
            <tr>
                <td>出生日期</td>
                <td><input type="text" name="birthday" value="${manager.birthday}"></td>
            </tr>
            <tr>
                <td>手机号码</td>
                <td><input type="text" name="cellphone" value="${manager.cellphone}"></td>
            </tr>
            <tr>
                <td>电子邮箱</td>
                <td><input type="text" name="email" value="${manager.email}"></td>
            </tr>
            <tr>
                <td>客户爱好</td>
                <td>

                    <input type="checkbox" name="preference" value="篮球"
                            <c:forTokens items="${manager.preference}" delims="," var="pref">
                                    <c:if test="${pref == '篮球'}">
                                        checked="checked"
                                    </c:if>
                            </c:forTokens>
                    />篮球
                    <input type="checkbox" name="preference" value="足球"
                            <c:if test="${fn:contains(manager.preference,'足球')}">
                                checked='checked'
                            </c:if>
                    />足球
                    <input type="checkbox" name="preference" value="排球"
                            <c:if test="${fn:contains (manager.preference,'排球')}">
                                checked='checked'
                            </c:if>
                    />排球
                    <input type="checkbox" name="preference" value="乒乓球"
                            <c:if test="${fn:contains (manager.preference,'乒乓球')}">
                                checked='checked'
                            </c:if>
                    />乒乓球
                    <input type="checkbox" name="preference" value="玻璃球"
                            <c:if test="${fn:contains (manager.preference,'玻璃球')}">
                                checked='checked'
                            </c:if>
                    />玻璃球
                </td>
            </tr>
            <tr>
                <td>客户类型</td>
                <td>
                    <select name="type">
                        <option value="钻石客户"
                            <c:if test="${manager.type=='钻石客户'}">
                                selected="selected"
                            </c:if>
                        >钻石客户</option>
                        <option value="白金客户"
                            <c:if test="${manager.type=='白金客户'}">
                                selected="selected"
                            </c:if>
                        >白金客户</option>
                        <option value="黄金客户"
                                <c:if test="${manager.type=='黄金客户'}">
                                    selected="selected"
                                </c:if>
                        >黄金客户</option>
                        <option value="白银客户"
                                <c:if test="${manager.type=='白银客户'}">
                                    selected="selected"
                                </c:if>
                        >白银客户</option>
                        <option value="青铜客户"
                                <c:if test="${manager.type=='青铜客户'}">
                                    selected="selected"
                                </c:if>
                        >青铜客户</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>描述信息</td>
                <td><textarea name="description" rows="6" cols="40">${manager.description}</textarea></td>
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
