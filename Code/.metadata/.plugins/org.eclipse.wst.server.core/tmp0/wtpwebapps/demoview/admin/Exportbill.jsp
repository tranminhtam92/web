<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/admin/Adminstyle.css" rel="stylesheet" type="text/css">

<title>Hóa đơn</title>
</head>
<body>
<div class="wrapper">
<jsp:include page="headeradmin.jsp"></jsp:include>
<div class="content">
<div class="left">
<jsp:include page="menu.jsp"></jsp:include>
</div>
<div class="right">
<h1>Hóa đơn</h1>



<div class="table">
<table>
<tr>
<td>Tên khách hàng: 
<td>${order.tenkhachhang}
</tr>
<tr>
<td>Tên người nhận: 
<td>${order.tennguoinhan}
</tr>
<tr>
<td>Ngày đặt hàng: 
<td><fmt:formatDate pattern="dd/MM/yyyy"  value="${order.ngay}" />
</tr>
<tr>
<td>Địa chỉ: 
<td>${order.diachi}
</tr>
<tr>
<td>số điện thoại: 
<td>${order.sodienthoai}
</tr>
<tr>
<th> Tên sản phẩm</th>
<th> Số lượng</th>
<th>Giá</th>

</tr>
<c:forEach items="${detailorder}" var="product">
<tr>
<td>${product.tensp }</td>
<td>${product.soluong}</td>
<td><fmt:formatNumber type="number" pattern="###,###" value="${product.gia-((product.gia*product.khuyenmai)/100)}"/>đ/kg</td>
</tr>

</c:forEach>
<tr>
<td><h3> Tổng tiền:</h3>
<td colspan="2"><fmt:formatNumber type="number" pattern="###,###" value="${order.tongtien}"/>đ
</tr>
<tr>
<td>
<td colspan="2">Ngày... Tháng... Năm...
</tr>
<tr>
<td colspan="1">Nhân viên
<td colspan="2">Người nhận
</tr>
</table>

</div>
<center>
<form action="${pageContext.request.contextPath}/Exportbill" method="post">
<input type="hidden" name="ordercode" value="${order.maddh}">
	<input type="submit" name="report" value="In hóa đơn">
	</form>
	</center>
</div>
</div>
</div>
</body>
</html>