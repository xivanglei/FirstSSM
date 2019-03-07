<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xianglei
  Date: 2019-02-25
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link href="${pageContext.request.contextPath}/css/common.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/regcss.css" type="text/css" rel="stylesheet">
    <script type="text/javascript">
        function validate() {
            if(document.getElementById("ip_username").value == "") {
                alert("用户名不能为空");
                document.getElementById("ip_username").focus();
                return false;
            } else if(document.getElementById("ip_password".value == "")) {
                alert("密码不能为空");
                document.getElementById("ip_password").focus();
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <div id="content">
        <div id="form">
            <h1>用户登录</h1><br>
            <form action="login.action" method="post" id="myform" onsubmit="return validate()">
                用户名<input id="ip_username" type="text" name="username"><br>
                密码<input id="ip_password" type="password" name="password"><br>
                <input id="ip_submit" type="submit" value="登录">
                <a href="registerPage.action">注册</a>
            </form>
            <c:if test="${errorMsg != null}">
                <b>${errorMsg}</b>
            </c:if>
            <c:if test="${noticeMsg != null}">
                <b>${noticeMsg}</b>
            </c:if>
        </div>
    </div>
</body>
</html>
