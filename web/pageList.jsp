<%--
  Created by IntelliJ IDEA.
  User: zjn
  Date: 2018/7/18
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <script type="text/javascript">
        function changePage(obj){
            if(isNaN(obj.value)){
                alert("必须是数字!");
                obj.value=${page.thispage}
                return;
            }else if(obj.value<=0 || obj.value>${page.countpage} ){
                alert("页码必须在有效范围内!");
                obj.value=${page.thispage}
                return;
            }else{
                window.location.href="${pageContext.request.contextPath }/servlet/PageCustServlet?thispage="+obj.value;
            }
        }
    </script>
</head>
<body style="text-align: center">
    <h1>分页查询客户信息</h1>
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
            <th>修改</th>
            <th>删除</th>
        </tr>
        <c:forEach items="${requestScope.page.list}" var="Manager">
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
    共${page.countrow}条记录！
    共${page.countpage}页记录！
    <a href="${pageContext.request.contextPath}/servlet/PageManagerServlet?thispage=${page.firstpage}">首页</a>
    <a href="${pageContext.request.contextPath}/servlet/PageManagerServlet?thispage=${page.prepage}">上一页</a>

    <!--分页逻辑开始-->
    <c:if test="${page.countpage<=5}">
        <c:set var="begin" value="1" scope="page"></c:set>
        <c:set var="end" value="${page.countpage}" scope="page"></c:set>
    </c:if>
    <c:if test="${page.countpage>5}">
        <c:choose>
            <c:when test="${page.thispage<=3}">
                <c:set var="begin" value="1" scope="page"></c:set>
                <c:set var="end" value="5" scope="page"></c:set>
            </c:when>
            <c:when test="${page.thispage>=page.countpage-2}">
                <c:set var="begin" value="${page.countpage-4}" scope="page"></c:set>
                <c:set var="end" value="${page.countpage}" scope="page"></c:set>
            </c:when>
            <c:otherwise>
                <c:set var="begin" value="${page.thispage-2}" scope="page"></c:set>
                <c:set var="end" value="${page.thispage+2}" scope="page"></c:set>
            </c:otherwise>
        </c:choose>
    </c:if>

    <c:forEach begin="${begin}" end="${end}" step="1" var="i">
        <c:if test="${i == page.thispage}">
            ${i }
        </c:if>
        <c:if test="${i != page.thispage}">
            <a href="${pageContext.request.contextPath }/servlet/PageManagerServlet?thispage=${i}">${i }</a>
        </c:if>
    </c:forEach>
    <!--分页逻辑结束-->
    <a href="${pageContext.request.contextPath}/servlet/PageManagerServlet?thispage=${page.nextpage}">下一页</a>
    <a href="${pageContext.request.contextPath}/servlet/PageManagerServlet?thispage=${page.lastpage}">尾页</a>
    跳到<input type="text" value="${page.thispage }" style="width: 40px" onchange="changePage(this)"/>页
</body>
</html>
