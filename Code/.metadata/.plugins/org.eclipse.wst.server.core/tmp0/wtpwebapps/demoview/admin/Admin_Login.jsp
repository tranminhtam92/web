<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="admin_login">
<h2>${error }</h2>
<form action="${pageContext.request.contextPath}/Adminlogin" method="post">
<table>
<tr>
<td>Tên đăng nhập:</td>
<td><input type="text" name="adminusername"></td>
</tr>
<tr>
<td>Mật khẩu:</td>
<td><input type="password" name="adminpassword" ></td>
</tr>
<tr>
<td></td>
<td><input type="submit" name="sm" value="đăng nhập"></td>
</tr>
</table>
</form>
</div>
</body>
</html>