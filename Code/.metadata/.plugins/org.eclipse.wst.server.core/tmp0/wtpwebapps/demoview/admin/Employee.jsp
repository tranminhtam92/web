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
<h1>Quản lý nhân viên </h1>
<div class="add"><a href="${pageContext.request.contextPath}/admin/AddEmployee.jsp">Thêm nhân viên</a>
</div>
<div class="table">
<table>
<tr>
<th> Mã nhân viên</th>
<th> Tên nhân viên</th>
<th>Giới tính</th>
<th> Địa chỉ</th>
<th>Số điện thoại</th>

</tr>
<c:forEach items="${list_employee}" var="employee">
<tr>
<td>${employee.manhanvien}</td>
<td>${employee.tennhanvien}</td>
<td>
<c:if test="${employee.gioitinh}">
Nam
</c:if>
<c:if test="${!employee.gioitinh}">
Nữ
</c:if>
</td>
<td>${employee.diachi}</td>
<td>${employee.sodienthoai}</td>

</tr>
</c:forEach>
</table>
</div>
</div>
</div>
</div>
</body>
</html>