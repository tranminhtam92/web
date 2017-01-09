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

<h1>Quản lý sản phẩm</h1>
<form action="${pageContext.request.contextPath}/Adminproduct" action="post">
<table>
<tr>
<td><input type="text" name="information" placeholder="nhập nội dung tìm kiếm"></td>
<td><select name="searchtype">
		<option value="productcode" >Mã sản phẩm</option>
		<option value="productname" selected="selected">Tên sản phẩm</option>
		<option value="producttype">Loại sản phẩm</option>
		</select>

</td>
<td><input type="image" src="${pageContext.request.contextPath}/hinhanh/find.png" alt="submit" name="key" value="search" width="20px" height="20px"></td>
</tr>
</table>
</form>
<div class="add"><a href="${pageContext.request.contextPath}/AdminForward_edit?key=add_product">Thêm sản phẩm</a>
</div>
<div class="table">
<table>
<tr>
<th> Mã sản phẩm</th>
<th> Tên sản phẩm</th>
<th> Giá</th>
<th> Đơn vị tính</th>
<th> Số lượng</th>
<th> Mô tả</th>
<th> Ảnh</th>
<th> Ngày</th>
<th> Khuyến mãi</th>
<th> Sản phẩm mới</th>
<th> Mã loại</th>
</tr>
<c:forEach items="${list_product}" var="product">
<tr>
<td>${product.masp}</td>
<td>${product.tensp}</td>
<td>${product.gia}</td>
<td>${product.donvitinh}</td>
<td>${product.soluong}</td>
<td>${product.mota}</td>
<td><img src="${pageContext.request.contextPath}/hinhanh/${product.anh}" class="imgsmall"></td>
<td> <fmt:formatDate pattern="dd/MM/yyyy"  value="${product.ngay}" /></td>
<td>${product.khuyenmai}</td>
<td>${product.sanphammoi}</td>
<td>${product.maloai}</td>
<td><a href="${pageContext.request.contextPath}/AdminForward_edit?key=edit_product&productcode=${product.masp}">sửa</a></td>
<td><a href="${pageContext.request.contextPath}/AdminProduct?key=delete&producttypecode=${product.masp}">xóa</a></td>
</tr>
</c:forEach>
</table>
</div>
</div>
</div>
</div>
</body>
</html>