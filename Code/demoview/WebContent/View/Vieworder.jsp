<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link href="Style.css" rel="stylesheet" type="text/css">
<title>quản lý đơn đặt hàng</title>
</head>
<body>
<div class="wrapper">
<jsp:include page="Header_vieworder.jsp"></jsp:include>
<jsp:include page="Nav.jsp"></jsp:include>
<div class="content">
<div class="contentvieworder">
<h2>${filler_order}</h2>
<c:if test="${not empty listorder}">

<div class="tableorder">
<table border="1px">

<tr>
<th>Mã đơn đặt hàng</th>
<th>Ngày đặt hàng</th>
<th>Tên người nhận</th>
<th>Địa chỉ</th>
<th>Số điện thoại</th>
<th>Tổng tiền</th>
<th>Tình trạng thanh toán</th>
<th>Ngày thanh toán</th>
<th>Tình trạng vận chuyển</th>
<th>Ngày vận chuyển</th>
</tr>
<c:forEach items="${listorder}" var="order">
<tr>
<td>${order.maddh}</td>
<td> <fmt:formatDate pattern="dd/MM/yyyy"  value="${order.ngay}" /></td>
<td>${order.tennguoinhan}</td>
<td>${order.diachi}</td>
<td>${order.sodienthoai}</td>
<td><fmt:formatNumber type="number" pattern="###,###" value="${order.tongtien}"/>đ</td>
<td>${order.thanhtoan}</td>
<td> <fmt:formatDate pattern="dd/MM/yyyy"  value="${order.ngaythanhtoan}" /></td>
<td>${order.vanchuyen}</td>
<td> <fmt:formatDate pattern="dd/MM/yyyy"  value="${order.ngayvanchuyen}" /></td>
<td><a href="Detailorder?ordercode=${order.maddh}">chi tiết</a></td>
</tr>
</c:forEach>
</table>
</div>
</c:if>
</div>
</div>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>