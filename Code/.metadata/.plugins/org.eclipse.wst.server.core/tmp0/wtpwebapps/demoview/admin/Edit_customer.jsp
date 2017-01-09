<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<h1>Sửa thông tin khách hàng</h1>

<div class="table">
<form action="${pageContext.request.contextPath}/Admincustomer" method="post">
<table>
<tr>
<td>Tên đăng nhập :</td>
<td> ${customer.tendangnhap}</td>
<td> <input type="hidden" name="customercode" value="${customer.tendangnhap}" ></td>
</tr>
<tr>
<td> Mật khẩu:</td>
<td> <input type="text" name="customerpass" value="${customer.matkhau}"></td>
</tr>
<tr>
<td> Họ và tên:</td>
<td> <input type="text" name="customername" value="${customer.hoten}"></td>
</tr>
<tr>
<td> Địa chỉ:</td>
<td> <input type="text" name="customeraddress" value="${customer.diachi}"></td>
</tr>
<tr>
<td> Số điện thoại:</td>
<td> <input type="text" name="customertel" value="${customer.sodienthoai}" ></td>
</tr>

<tr>
<td></td>
<td> <input type="submit" name="key" value="edit"></td>
</tr>
</table>
</form>
</div>
</div>
</div>
</div>
</body>
</html>