<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="Style.css" rel="stylesheet" type="text/css">
<title>Register</title>
</head>
<body>
<div class="wrapper">
<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="Nav.jsp"></jsp:include>
<div class="content">
<h2>${error}</h2>
${user.hoten}
${hoten}
<form action="${pageContext.request.contextPath}/Register" method="post">
<table>
<tr>
<td>Tên đăng nhập*</td>
<td><input type="text" name="username" value="${user.tendangnhap}" required></td>
</tr>
<tr>
<td>Mật khẩu *</td>
<td> <input type="password" name="password" required></td>
</tr>
<tr>
<td>Nhập lại mật khẩu *</td>
<td> <input type="password" name="re_password" required></td>
</tr>
<tr>
<td>Họ và tên *</td>
<td> <input type="text" name="fullname" value="${user.hoten}" required></td>
</tr>
<tr>
<td>Số điện thoại *</td>
<td> <input type="text" name="tel_number" value="${user.sodienthoai}" required></td>
</tr>
<tr>
<td>Địa chỉ *</td>
<td> <input type="text" name="address" value="${user.diachi}" required></td>
</tr>
<tr>
<td></td>
<td> <input type="submit" value="đăng ký"> <a href="${pageContext.request.contextPath}/View/login.jsp"> Đang nhập</a></td>

</tr>
</table>

</form>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</div>

</body>
</html>