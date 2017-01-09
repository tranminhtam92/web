<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
          <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/admin/Adminstyle.css" rel="stylesheet" type="text/css">
<title>Quản lý sản phẩm</title>
</head>
<body>
<div class="wrapper">
<jsp:include page="headeradmin.jsp"></jsp:include>
<div class="content">
<div class="left">
<jsp:include page="menu.jsp"></jsp:include>
</div>
<div class="right">

<h1>Thống kê số lượng sản phẩm hiện có/ số lượng khách đặt</h1>
<div class="table">
<table>
<tr>
<th> Mã sản phẩm</th>
<th> Tên sản phẩm</th>
<th> Số lượng hiện có</th>
<th> Số lượng khách đặt</th>

</tr>
<c:forEach items="${list_report}" var="product">
<tr>
<td>${product.masp}</td>
<td>${product.tensp}</td>
<td>${product.soluong}</td>
<td>${product.soluongdat}</td>
</tr>
</c:forEach>
</table>
</div>
<center>
<form action="${pageContext.request.contextPath}/Reportdemoservlet" method="get">
	<input type="submit" name="report" value="in san pham khach dat">
	</form>
</center>
</div>
</div>
</div>
</body>
</html>