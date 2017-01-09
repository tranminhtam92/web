<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
          <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/admin/Adminstyle.css" rel="stylesheet" type="text/css">
<title>Quản lý khách hàng</title>
</head>
<body>
<div class="wrapper">
<jsp:include page="headeradmin.jsp"></jsp:include>
<div class="content">
<div class="left">
<jsp:include page="menu.jsp"></jsp:include>
</div>
<div class="right">
<h1>Quản lý khách hàng</h1>
<form action="${pageContext.request.contextPath}/Admincustomer" action="post">
<table>
<tr>
<td><input type="text" name="information" placeholder="nhập nội dung tìm kiếm"></td>
<td><select name="searchtype">
		<option value="username" selected="selected">tên đăng nhập</option>
		<option value="fullname" >Họ và tên</option>
		<option value="address">Địa chỉ</option>
		<option value="tel">Số điện thoại</option>
		</select>

</td>
<td><input type="image" src="${pageContext.request.contextPath}/hinhanh/find.png" alt="submit" name="key" value="search" width="20px" height="20px"></td>
</tr>
</table>
</form>
<div class="add"><a href="#">Thêm mới nhà cung cấp</a>
</div>
<div class="table">
<table>
<tr>
<th>Tên đăng nhập</th>
<th> Mật khẩu</th>
<th> Họ và tên</th>
<th> Địa chỉ</th>
<th> Số điện thoại</th>
</tr>
<c:forEach items="${list_customer}" var="customer">
<tr>
<td>${customer.tendangnhap}</td>
<td>${customer.matkhau}</td>
<td>${customer.hoten}</td>
<td>${customer.diachi}</td>
<td>${customer.sodienthoai}</td>

<td><a href="${pageContext.request.contextPath}/AdminForward_edit?key=edit_customer&customercode=${customer.tendangnhap}">sửa</a></td>
<td><a href="${pageContext.request.contextPath}/Admincustomer?key=delete&customercode=${customer.tendangnhap}">xóa</a></td>
</tr>
</c:forEach>
</table>
</div>
</div>
</div>
</div>
</body>
</html>