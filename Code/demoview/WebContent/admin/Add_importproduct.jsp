<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/admin/Adminstyle.css" rel="stylesheet" type="text/css">
<title>Quản lý đơn nhập hàng</title>
</head>
<body>
<div class="wrapper">
<jsp:include page="headeradmin.jsp"></jsp:include>
<div class="content">
<div class="left">
<jsp:include page="menu.jsp"></jsp:include>
</div>
<div class="right">
<h1>Thêm mới đơn nhập hàng</h1>
<h2>${error }</h2>
<div class="table">
<table>
<form action="${pageContext.request.contextPath}/Adminimportproduct" method="post">
<tr>
<td> Ngày nhập hàng</td>
<td><input type="date" name="importproductdate" required></td>
</tr>
<tr>
<td>Thanh toán</td>
<td><input type="radio" name="ispay" value="false">Chưa thanh toán<input type="radio" name="ispay" value="true" checked="checked">Đã thanh toán</td>
</tr>
<tr>
<td>Nhân viên nhận hàng</td>
<td><select name="employeecode">
<c:forEach items="${list_employee}" var="employee">
<option value="${employee.manhanvien}">${employee.tennhanvien}</option>
</c:forEach>
	
</select></td>
</tr>
<tr>
<td>Nhà cung cấp</td>
<td><select name="manufactorcode">
<c:forEach items="${list_manufactor}" var="manufactor">
<option value="${manufactor.manhacungcap}">${manufactor.tennhacungcap}</option>
</c:forEach>
	
</select>
</td>
</tr>
<tr>
<td></td>
<td><input type="submit" name="key" value="add"></td>
</tr>
</form>
</table>
</div>
</div>
</div>
</div>
</body>
</html>