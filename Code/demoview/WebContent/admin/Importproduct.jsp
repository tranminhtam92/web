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
<h1>Quản lý đơn nhập hàng</h1>


<table>

<tr>
<form action="${pageContext.request.contextPath}/Adminimportproduct" action="post">
<td><input type="text" name="information" placeholder="nhập nội dung tìm kiếm"></td>
<td><select name="searchtype">
		<option value="importproductcode" selected="selected">mã đơn nhập hàng</option>
		<option value="manufactorcode" >mã nhà cung cấp</option>
		<option value="employeecode">Mã nhân viên</option>
		</select>
</td>
<td><input type="image" src="${pageContext.request.contextPath}/hinhanh/find.png" alt="submit" name="key" value="search" width="20px" height="20px"></td>
</form>
</tr>

<tr>
<form action="${pageContext.request.contextPath}/Adminimportproduct" action="post">
<td colspan="2"><select name="fillorder">
		<option value="1" selected="selected">Đơn nhập hàng hôm nay</option>
		<option value="2" >Tất cả đơn nhập hàng</option>
		<option value="3">Đơn nhập hàng trong 1 tháng</option>
		<option value="4">Đơn nhập hàng trong 1 tuần</option>
		</select>
</td>
<td><input type="image" src="${pageContext.request.contextPath}/hinhanh/find.png" alt="submit" name="key" value="filler" width="20px" height="20px"></td>
</form>
</tr>
</table>

<h2>${error }</h2>
<a href="${pageContext.request.contextPath}/AdminForward_edit?key=add_importproduct">Thêm mới đơn nhập hàng</a>
<div class="table">
<table>
<tr>
<th> Mã đơn nhập hàng</th>
<th> Ngày nhập hàng</th>
<th>Tổng tiền</th>
<th>Thanh toán</th>
<th>Nhân viên nhận hàng</th>
<th>Nhà cung cấp</th>
</tr>
<c:forEach items="${list_importproduct}" var="importproduct">
<tr>
<td>${importproduct.madnh }</td>
<td><fmt:formatDate pattern="dd/MM/yyyy"  value="${importproduct.ngaynhaphang}" /></td>
<td><fmt:formatNumber type="number" pattern="###,###" value="${importproduct.tongtien}"/></td>
<td>${importproduct.thanhtoan}</td>
<td>${importproduct.tennhanvien}</td>
<td>${importproduct.tennhacungcap}</td>
<td><a href="${pageContext.request.contextPath}/Adminimportproduct?key=detail&importproductcode=${importproduct.madnh}">chi tiết</a></td>
<td><a href="#">sửa</a></td>
<td><a href="#">xóa</a></td>
</tr>
</c:forEach>
</table>
</div>
</div>
</div>
</div>
</body>
</html>