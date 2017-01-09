<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/admin/Adminstyle.css" rel="stylesheet" type="text/css">
<title>Quản lý loại sản phẩm</title>
</head>
<body>
<div class="wrapper">
<jsp:include page="headeradmin.jsp"></jsp:include>
<div class="content">
<div class="left">
<jsp:include page="menu.jsp"></jsp:include>
</div>
<div class="right">
<h1>Thêm loại sản phẩm</h1>

<div class="table">
<form action="${pageContext.request.contextPath}/AdminProducttype" method="post">
<table>
<tr>
<td> Mã loại:</td>

<td> <input type="text" name="producttypecode" requierd ></td>
</tr>
<tr>
<td> Tên loại:</td>
<td> <input type="text" name="producttypename" requierd></td>
</tr>
<tr>
<td> Vị trí:</td>
<td> <input type="text" name="producttypeposition" requierd></td>
</tr>
<tr>
<td> Màu sắc:</td>
<td> <input type="text" name="producttypecolor" requierd></td>
</tr>
<tr>
<td> kiểu chữ:</td>
<td> <input type="text" name="producttypefront" requierd ></td>
</tr>
<tr>
<td></td>
<td> <input type="submit" name="key" value="add"></td>
</tr>
</table>
</form>
</div>
</div>
</div>
</div>
</body>
</html>