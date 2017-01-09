<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/admin/Adminstyle.css" rel="stylesheet" type="text/css">
<title>Chi tiết đơn nhập hàng</title>
</head>
<body>
<div class="wrapper">
<jsp:include page="headeradmin.jsp"></jsp:include>
<div class="content">
<div class="left">
<jsp:include page="menu.jsp"></jsp:include>
</div>
<div class="right">
<h1>Chi tiết đơn nhập hàng</h1>
<table class="tbcart" cellspacing="10px">
	<tr>
		<th>mã đơn nhập hàng</th>
		<th>Tên sản phẩm</th>
		<th> Số lượng</th>
		<th> Giá</th>
	</tr>
	<c:forEach items="${list_detail}" var="detail">
		<tr>
		<td>${detail.madnh}</td>
		<td>${detail.tensp}</td>
		<td>${detail.soluong}</td>
		<td><fmt:formatNumber type="number" pattern="###,###" value="${detail.gia}"/>đ/kg</td>
	   </tr>
	 </c:forEach>
	 <tr>
	 </tr>
	</table>
</div>
</div>
</div>
</body>
</html>