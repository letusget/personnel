<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<h1>用户注册</h1>
<form action="${pageContext.request.contextPath}/registServlet" method="post">
    <p>用户名:<input type="text" name="username"></p>
    <p>密码:<input type="password" name="password"></p>
    <p><input type="submit" value="注册" onclick="alert('注册成功')"> <input type="reset" value="重置"></p>
    <p><a href="login.jsp">登录</a></p>
</form>
</body>
</html>