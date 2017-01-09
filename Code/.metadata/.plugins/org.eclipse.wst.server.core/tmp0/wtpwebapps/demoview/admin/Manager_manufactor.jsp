<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
          <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/admin/Adminstyle.css" rel="stylesheet" type="text/css">
<title>Quản lý nhà cung cấp</title>
</head>
<body>
<div class="wrapper">
<jsp:include page="headeradmin.jsp"></jsp:include>
<div class="content">
<div class="left">
<jsp:include page="menu.jsp"></jsp:include>
</div>
<div class="right">
<h1>Quản lý nhà cung cấp</h1>
<div class="add"><a href="${pageContext.request.contextPath}/admin/Add_manufactor.jsp">Thêm mới nhà cung cấp</a>
</div>
<div class="table">
<table>
<tr>
<th> Mã nhà cung cấp</th>
<th> Tên nhà cung cấp</th>
<th> Địa chỉ</th>
<th> Số điện thoại</th>
</tr>
<c:forEach items="${list_manufactor}" var="manufactor">
<tr>
<td>${manufactor.manhacungcap}</td>
<td>${manufactor.tennhacungcap}</td>
<td>${manufactor.diachi}</td>
<td>${manufactor.sodienthoai}</td>

<td><a href="${pageContext.request.contextPath}/AdminForward_edit?key=edit_manufactor&manufactorcode=${manufactor.manhacungcap}">sửa</a></td>
<td><a href="${pageContext.request.contextPath}/Adminmanufactor?key=delete&manufactorcodecode=${manufactor.manhacungcap}">xóa</a></td>
</tr>
</c:forEach>
</table>
</div>
</div>
</div>
</div>
</body>
</html>