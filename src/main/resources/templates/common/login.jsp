<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1>用户登录</h1>
<form action="${pageContext.request.contextPath}/loginServlet" method="post">
    <p>用户名:<input type="test" name="username"></p>
    <p>密码:<input type="password" name="password"></p>
    <p><input type="submit" value="登录"> <input type="reset" value="重置"></p>
    <p><a href="register.jsp">注册</a></p>
</form>
</body>
</html>