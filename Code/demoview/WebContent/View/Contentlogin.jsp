<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="content">
<div color="red"><h2>${error}</h2></div>
<div id="login">
<form action="${pageContext.request.contextPath}/Login" method="post">
<table>
<tr>
<td>tên đăng nhập*</td>
<td><input type="text" name="username"></td>
</tr>
<tr>
<td>Mật khẩu *</td>
<td> <input type="password" name="password"></td>
</tr>
<tr>
<td></td>
<td> <input type="submit" value="đăng nhập"> <a href="${pageContext.request.contextPath}/View/Register.jsp"> đăng ký </a></td>

</tr>
</table>

</form>
</div>

</div>
</body>
</html>