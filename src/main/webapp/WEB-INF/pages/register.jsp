<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xianglei
  Date: 2019-02-25
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link href="${pageContext.request.contextPath}/css/common.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/regcss.css" type="text/css" rel="stylesheet">
    <script type="text/javascript">
        function validate() {
            if(document.getElementById("ip_username").value == "") {
                alert("用户名不能为空");
                document.getElementById("ip_username").focus();
                return false;
            } else if(document.getElementById("ip_password").value == "") {
                alert("密码不能为空");
                document.getElementById("ip_password").focus();
                return false;
            } else if(document.getElementById("ip_name").value == "") {
                alert("姓名不能为空");
                document.getElementById("ip_name").focus();
                return false;
            } else if(document.getElementById("ip_telephone").value == "" ||
                    !(/^1[34578]\d{9}$/.test(document.getElementById("ip_telephone").value))) {
                alert("手机号格式有误");
                document.getElementById("ip_telephone").focus();
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <div id="content">
        <div id="form">
            <h1>用户注册</h1><br>
            <form action="register.action" method="post" id="myform" onsubmit="return validate()">
                用户名<input id="ip_username" type="text" name="username"><br>
                密码<input id="ip_password" type="password" name="password"><br>
                姓名<input id="ip_name" type="text" name="name"><br>
                手机号<input id="ip_telephone" type="text" name="telephone"><br>
                <input id="ip_submit" type="submit" value="注册">
                <a href="toLogin.action">返回登录</a>
            </form>
            <c:if test="${errorMsg != null}">
                <b>${errorMsg}</b>
            </c:if>
        </div>
    </div>
</body>
</html>
