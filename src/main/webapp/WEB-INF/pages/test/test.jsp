<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xianglei
  Date: 2019-02-24
  Time: 08:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>test</title>
</head>
<body>
    <form action="findUser.action" method="post">
        用户姓名:<input type="text" name="name"/><br>
        <input type="submit" value="查询">
    </form>
    <table width="300px;" border="1">
        <tr>
            <th>序号</th>
            <th>姓名</th>
            <th>账号</th>
            <th>电话</th>
        </tr>
        <c:forEach items="${userList}" var="fruit" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${fruit.name}</td>
                <td>${fruit.username}</td>
                <td>${fruit.telephone}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
