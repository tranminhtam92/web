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
<h1>Thêm chi tiết đơn nhập hàng</h1>
<table>
<form action="${pageContext.request.contextPath}/Adminimportproduct" method="post">
<tr>

<td><input type="hidden" name="importproductcode" value="${importproductcode }"></td>
</tr>
<tr>
<td>mã sản phẩm</td>
<td>  <input list="browsers" name="productcode" required>
  <datalist id="browsers">
<c:forEach items="${list_product}" var="product">
 <option value="${product.masp}">${product.tensp}
</c:forEach>
  </datalist></td>
</tr>
<tr>
<td>Số lượng:</td>
<td><input type="number" name="quantity" min="1" max="500" required></td>
</tr>
<tr>
<td>Giá:</td>
<td><input type="number" name="amount" min="1" required></td>
</tr>
<tr>
<td><input type="submit" name="key" value="next"></td>
<td><input type="submit" name="key" value="end"></td>
</tr>
</form>
</table>
</div>
</div>
</div>
</body>
</html>