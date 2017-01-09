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
<h1>Sủa sản phẩm</h1>
<div class="table">

<form action="${pageContext.request.contextPath}/Editproduct" method="post" enctype="multipart/form-data">
<table>
<tr>
<th> Mã sản phẩm</th>
<th>${product.masp}<th>
<th><input type="hidden"name="productcode" value="${product.masp}"/><th>
</tr>
<tr>
<th> Tên sản phẩm</th>
<th><input type="text"name="productname" value="${product.tensp}" required/><th>
</tr>
<tr>
<th> Giá</th>
<th><input type="text"name="productamount" value="${product.gia}" required/><th>
</tr>
<tr>
<th>Đơn vị tính</th>
<th><input type="text"name="productdvt" value="${product.donvitinh}" required/><th>
</tr>
<tr>
<th> Số lượng</th>
<th><input type="number" min="0"  name="productquantity" value="${product.soluong}" required/><th>
</tr>
<tr>
<th> Mô tả</th>
<th><input type="textarea" cols="5" rows="5" name="productdescription" value="${product.mota}"/><th>
</tr>
<tr>
<th>Ảnh</th>
<th><input type="file" name="image" value="${pageContext.request.contextPath}/hinhanh/${product.anh}" required><th>
<th><img src="${pageContext.request.contextPath}/hinhanh/${product.anh}" class="imgsmall"><th>
</tr>
<tr>
<th> Ngày(mm/dd/yyyy)</th>
<th><input type="date"name="day" value="${product.ngay}" required/><th>
</tr>
<tr>
<th>Khuyến mãi</th>
<th><input type="text"name="sale" value="${product.khuyenmai}" required/><th>
</tr>
<tr>
<th>Sản phẩm mới</th>


<c:if test="${product.sanphammoi}">

<th><input type="radio" name="newproduct" value="true" checked="checked"/> mới

<input type="radio" name="newproduct" value="false"/> cũ</th>

</c:if>
<c:if test="${!product.sanphammoi}">

<th><input type="radio" name="newproduct" value="true"/> mới


<input type="radio" name="newproduct" value="false" checked="checked"/> cũ</th>

</c:if>
</tr>

<tr>
<th>Mã loại</th>
<th><select name="producttypecode">
<c:forEach items="${list_producttype}" var="producttype">
<c:if test="${producttype.maloai==product.maloai}">
<option value="${producttype.maloai}" selected="selected">${producttype.tenloai}</option>
</c:if>
<c:if test="${producttype.maloai!=product.maloai}">
<option value="${producttype.maloai}">${producttype.tenloai}</option>
</c:if>
</c:forEach>

</select><th>
</tr>
<tr>
<td></td>
<td><input type="submit" name="key" value="edit"></td>
</tr>
</table>
</form>

</div>
</div>
</div>
</div>
</body>
</html>