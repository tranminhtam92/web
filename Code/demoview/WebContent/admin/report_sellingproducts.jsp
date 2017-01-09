<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/admin/Adminstyle.css" rel="stylesheet" type="text/css">
<title>Thống kê sản phẩm bán chạy</title>
</head>
<body>
<div class="wrapper">
<jsp:include page="headeradmin.jsp"></jsp:include>
<div class="content">
<div class="left">
<jsp:include page="menu.jsp"></jsp:include>
</div>
<div class="right">
<h1>Thống kê sản phẩm bán chạy</h1>


<table>

<tr>
<form action="${pageContext.request.contextPath}/Reportsellingproducts" action="post">
<td><input list="browsers" name="month" placeholder="nhập tháng" value="${month}">
  <datalist id="browsers">
 <option value="1">
 <option value="2">
  <option value="3">
   <option value="4">
    <option value="5">
     <option value="6">
      <option value="7">
  <option value="8">
  <option value="9">
  <option value="10">
  <option value="11">
  <option value="12">
  </datalist>
  </td>
<td> <input list="year" name="year" placeholder="nhập năm" value="${year}">
  <datalist id="year">

 <option value="2016">
 <option value="2017">
  <option value="2018">
   <option value="2019">
    <option value="2020">
     <option value="2021">
      <option value="2022">
  </datalist>
</td>
<td><input type="image" src="${pageContext.request.contextPath}/hinhanh/find.png" alt="submit" name="key" value="search" width="20px" height="20px"></td>
</form>
</tr>
</table>

<h2>Thống kê sản phẩm bán chạy </h2>
<div class="table">

<table>
<tr>
<th> Mã sản phẩm</th>
<th> Tên sản phẩm</th>
<th>Ảnh</th>
<th>Số lượng bán</th>

</tr>
<c:forEach items="${list_products}" var="product">
<tr>
<td>${product.masp }</td>
<td>${product.tensp}</td>
<td><input type="image" src="${pageContext.request.contextPath}/hinhanh/${product.anh} " class="imgsmall" /></td>
<td>${product.soluong} kg</td>
</c:forEach>
</table>
</div>

<form action="${pageContext.request.contextPath}/Exportsellingproducts" method="post">
<input type="hidden" name="month" value="${month }">
<input type="hidden" name="year" value="${year }">
<input type="submit" value="Export PDF" name="key">
</form>
</div>
</div>
</div>
</body>
</html>