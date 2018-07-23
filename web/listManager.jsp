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
    <script type="text/javascript">
        function checkAll(allC) {
            //allC.checked
            var otherCs=document.getElementsByName("delId");
            for(var i=0;i<otherCs.length;i++){
                otherCs[i].checked=allC.checked;
            }
        }
    </script>
</head>
<body style="text-align: center">
    <h1>客户列表页面</h1>
    <form action="${pageContext.request.contextPath}/servlet/FindManagerByCondServlet" method="post">
        客户姓名：<input type="text" name="name" value="${param.name }"/>
        客户性别：
        <input type="radio" name="gender" value="男"
               <c:if test="${param.gender=='男'}">checked='checked'</c:if>
        />男
        <input type="radio" name="gender" value="女"
               <c:if test="${param.gender=='男'}">checked='checked'</c:if>
        />女

        客户类型：
        <select name="type">
            <option value=" "
                    <c:if test="${param.type==' '}">
                        selected="selected"
                    </c:if>
            ></option>
        <option value="钻石客户"
                <c:if test="${param.type=='钻石客户'}">
                    selected="selected"
                </c:if>
        >钻石客户</option>
        <option value="白金客户"
                <c:if test="${param.type=='白金客户'}">
                    selected="selected"
                </c:if>
        >白金客户</option>
        <option value="黄金客户"
                <c:if test="${param.type=='黄金客户'}">
                    selected="selected"
                </c:if>
        >黄金客户</option>
        <option value="白银客户"
                <c:if test="${param.type=='白银客户'}">
                    selected="selected"
                </c:if>
        >白银客户</option>
        <option value="青铜客户"
                <c:if test="${param.type=='青铜客户'}">
                    selected="selected"
                </c:if>
        >青铜客户</option>
    </select>
        <input type="submit" value="条件查询客户"/>
    </form>
    <form action="${pageContext.request.contextPath}/servlet/BatchDelServlet" method="post">
    <table border="1" width="100%">
        <tr>
            <th><input type="checkbox" onclick="checkAll(this)"/>全选</th>
            <th>客户姓名</th>
            <th>客户性别</th>
            <th>出生日期</th>
            <th>手机号码</th>
            <th>电子邮箱</th>
            <th>客户爱好</th>
            <th>客户类型</th>
            <th>描述信息</th>
            <th>修改</th>
            <th>删除</th>
        </tr>
        <c:forEach items="${requestScope.list}" var="Manager">
        <tr>
            <td><input type="checkbox" name="delId" value="${Manager.id}"></td>
            <!--c:out转义防止js入侵-->
            <td><c:out value="${Manager.name}"/> </td>
            <td><c:out value="${Manager.gender}"/> </td>
            <td><c:out value="${Manager.birthday}"/></td>
            <td><c:out value="${Manager.cellphone}"/></td>
            <td><c:out value="${Manager.email}"/></td>
            <td><c:out value="${Manager.preference}"/></td>
            <td><c:out value="${Manager.type}"/></td>
            <td><c:out value="${Manager.description}"/></td>
            <td><a href="${pageContext.request.contextPath}/servlet/ManagerInfoServlet?id=${Manager.id}">修改</a></td>
            <td><a href="${pageContext.request.contextPath}/servlet/DelManagerServlet?id=${Manager.id}">删除</a></td>
        </tr>
        </c:forEach>
    </table>
    <input type="submit" value="批量删除"/>
</form>
</body>
</html>
