<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/admin/Adminstyle.css" rel="stylesheet" type="text/css">
<title>Quản lý nhân viên</title>
</head>
<body>
<div class="wrapper">
<jsp:include page="headeradmin.jsp"></jsp:include>
<div class="content">
<div class="left">
<jsp:include page="menu.jsp"></jsp:include>
</div>
<div class="right">
<h1>Thêm nhân viên</h1>
<h2>${error }</h2>
<div class="table">
<form action="${pageContext.request.contextPath}/Adminemployee" method="post">
<table>
<tr>
<td>Mã nhân viên :</td>

<td> <input type="text" name="employeecode" placeholder="nhập mã nhân viên" value="${employee.manhanvien}" required ></td>
</tr>
<tr>
<td> Tên nhân viên:</td>
<td> <input type="text" name="employeename" placeholder="nhập tên nhân viên" value="${employee.tennhanvien}" required></td>
</tr>
<tr>
<td> Địa chỉ:</td>
<td> <input type="text" name="employeeaddress" placeholder="nhập địa chỉ" value="${employee.diachi}" required></td>
</tr>
<tr>
<td> Số điện thoại:</td>
<td> <input type="text" name="employeetel" placeholder="nhập số điện thoại" value="${employee.sodienthoai}" required></td>
</tr>

<tr>
<td></td>
<td> <input type="submit" name="key" value="add"></td>
</tr>
</table>
</form>
</div>
</div>
</div>
</div>
</body>
</html>